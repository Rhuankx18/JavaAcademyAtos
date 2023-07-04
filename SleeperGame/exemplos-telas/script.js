let pontuacao;
let tempoRestante;
let level;

let corAlvo;

const cores = ["red", "blue", "green", "yellow", "orange", "purple", "grey", "brown", "black"];
const coresTradução = ["vermelho", "azul", "verde", "amarelo", "laranja", "roxo", "cinza", "marrom", "preto"];
const botaoInicio = document.getElementById("start-button");
const elementoPlacar = document.getElementById("score");
const elementoBotao = document.getElementById("buttons");
const elementoAlvo = document.getElementById("target");
const elementoTempo = document.getElementById("time");
const elementoLevel = document.getElementById("level");



botaoInicio.addEventListener("click", comecarJogo);
function comecarJogo() {
    botaoInicio.disabled = true;
    pontuacao = 0;
    level = 1;
    tempoRestante = tempoLevel(level);
    atualizarPlacar();
    atualizarLevel();
    atualizarAlvo();
    atualizarBotao();
    temporizador();
}
function atualizarPlacar() {
    elementoPlacar.textContent = pontuacao;
}
function atualizarLevel() {
    elementoLevel.textContent = level;
}
function atualizarAlvo() {
    corAlvo = corAleatoria();
    elementoAlvo.style.color = corAlvo;
    elementoAlvo.textContent = palavraAleatoria();
}
function atualizarBotao() {
    elementoBotao.innerHTML = "";
    const shuffledcores = embaralhar(cores.slice(0, 9));
    shuffledcores.forEach(color => {
        const button = criaCorBotao(color);
        elementoBotao.appendChild(button);
    });
}
function criaCorBotao(color) {
    const button = document.createElement("button");
    button.style.backgroundColor = color;
    button.addEventListener("click", () => cliqueBotao(color));
    return button;
}
function cliqueBotao(selectedColor) {
    if (selectedColor === corAlvo) {
        pontuacao++;
        atualizarPlacar();
        level = Math.ceil(pontuacao / 10);
        tempoRestante = tempoLevel(level);
        atualizarLevel();
        atualizarAlvo();
        atualizarBotao();
    } else {
        fimJogo();
    }
}
function temporizador() {
    const timer = setInterval(() => {
        tempoRestante--;
        elementoTempo.textContent = tempoRestante;
        if (tempoRestante <= 0) {
            fimJogo();
            clearInterval(timer);
        }
    }, 1000);
}
function fimJogo() {
    botaoInicio.disabled = false;
    alert(`O jogo acabou, sua pontuação: ${pontuacao}`);
}
function tempoLevel(level) {
    const levelTimes = [3, 2, 1.7, 1.7, 1.5, 1];
    return levelTimes[Math.min(level - 1, levelTimes.length - 1)];
}
function embaralhar(array) {
    return array.slice().sort(() => Math.random() - 0.5);
}
function corAleatoria() {
    return cores[Math.floor(Math.random() * cores.length)];
}
function palavraAleatoria() {
    const randomIndex = Math.floor(Math.random() * cores.length);
    return coresTradução[randomIndex];
}

