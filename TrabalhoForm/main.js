const form = document.querySelector('#formulario')
const nomeForm = document.querySelector('#nome')
const sobrenomeForm = document.querySelector('#sobrenome')
const emailForm = document.querySelector('#email')
const loginForm = document.querySelector('#login')
const senhaForm = document.querySelector('#senha')
const cepForm = document.querySelector('#cep')
const erroCep = document.querySelector('#cep-erro')
const enderecoForm = document.querySelector('#endereco')
const complementoForm = document.querySelector('#complemento')
const bairroForm = document.querySelector('#bairro')
const cidadeForm = document.querySelector('#cidade')
const estadoForm = document.querySelector('#estado')
const githubForm = document.querySelector('#github')
const academiaForm = document.querySelector('#academia')
const professorForm = document.querySelector('#professor')
const termosForm = document.querySelector('#termos')
const infoForm = document.querySelector('#info')
const tabelaDados = document.querySelector('#tabela-dados')
const camposTabela = tabelaDados.getElementsByTagName('td')

function login() {
  const nome = nomeForm.value.toLowerCase().trim()
  const sobrenome = sobrenomeForm.value.toLowerCase().trim()
  const login = `${nome}.${sobrenome}`
  loginForm.value = login.split(' ').join('')
}
nomeForm.addEventListener('input', login)
sobrenomeForm.addEventListener('input', login)
cepForm.addEventListener('blur', pesquisarCEP)

function limpa_Form_cep() {
  cepForm.value = ""
  enderecoForm.value = ""
  bairroForm.value = ""
  cidadeForm.value = ""
  estadoForm.value = ""
}

function pesquisarCEP() {
  if (cepForm.value.length !== 8) {
    div = document.getElementById("cep-erro")
    document.body.classList.remove('d-none')
    return
  } 
  const url = `https://viacep.com.br/ws/${cepForm.value}/json/`

  fetch(url).then(function (response) {
      return response.json()
    }).then(function inserirDados(data) {
      if (data.erro) {
        erroCep.classList.remove('d-none')
        limpa_Form_cep()
      } else {
        enderecoForm.value = data.logradouro;
        bairroForm.value = data.bairro;
        cidadeForm.value = data.localidade;
        estadoForm.value = data.uf;
      }
    }).catch(function (error) {
      console.log(error);
    })
}

form.addEventListener('submit', (event) => {
  event.preventDefault()
  const nome = nomeForm.value
  const sobrenome = sobrenomeForm.value
  const email = emailForm.value
  const login = loginForm.value
  const senha = senhaForm.value
  const cep = cepForm.value
  const endereco = enderecoForm.value
  const complemento = complementoForm.value
  const bairro = bairroForm.value
  const cidade = cidadeForm.value
  const estado = estadoForm.value
  const github = githubForm.value
  const academia = academiaForm.value
  const professor = professorForm.value
  const termos = termosForm.checked ? 'Aceito' : 'Não aceito'
  const info = document.querySelector('input[name="info"]:checked').value === 'info-sim' ? 'Sim' : 'Não'
  const dados = {
    nome: nome,
    sobrenome: sobrenome,
    email: email,
    login: login,
    senha: senha,
    cep: cep,
    endereco: endereco,
    complemento: complemento,
    bairro: bairro,
    cidade: cidade,
    estado: estado,
    github: github,
    academia: academia,
    professor: professor,
    termos: termos,
    info: info
  }
  exibirDados(dados)
  form.reset()
})
function exibirDados(dados) {
  form.classList.add('d-none');
  tabelaDados.classList.remove('d-none');
  document.querySelector('#t-nome').textContent = dados.nome
  document.querySelector('#t-sobrenome').textContent = dados.sobrenome
  document.querySelector('#t-email').textContent = dados.email
  document.querySelector('#t-login').textContent = dados.login
  document.querySelector('#t-senha').textContent = dados.senha
  document.querySelector('#t-cep').textContent = dados.cep
  document.querySelector('#t-endereco').textContent = dados.endereco
  document.querySelector('#t-complemento').textContent = dados.complemento
  document.querySelector('#t-bairro').textContent = dados.bairro
  document.querySelector('#t-cidade').textContent = dados.cidade
  document.querySelector('#t-estado').textContent = dados.estado
  document.querySelector('#t-github').textContent = dados.github
  document.querySelector('#t-academia').textContent = dados.academia
  document.querySelector('#t-professor').textContent = dados.professor
  document.querySelector('#t-termos').textContent = dados.termos
  document.querySelector('#t-info').textContent = dados.info
}