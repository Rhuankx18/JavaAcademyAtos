package pacote;

public class Calculadora {
	public float calcular(float a, float b, char operacao) {
		float resultado = 0;
		float maior=0,menor=0;
		
		maior=a;
		menor=b;
		if(maior<=0){
		resultado = menor - maior;
		} else {resultado = maior - menor;}
		switch (operacao) {
		case '+': {
			resultado = a + b;
			break;
		}
		case '-': {
			if(maior<b){
				resultado = menor - maior;
				} else {resultado = maior - menor;}
			break;
		}
		case '/': {
			resultado = a / b;
			break;
		}
		case '*': {
			resultado = a * b;
			break;
		}

		}
		return resultado;

	}
}
