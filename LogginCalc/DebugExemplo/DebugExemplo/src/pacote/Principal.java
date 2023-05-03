package pacote;
import java.util.Scanner;
import java.util.logging.Level;
import java.io.IOException;


public class Principal {
	
	public static void main(String[] args) throws IOException{
		
		Log meuLogger = new Log("Log.txt");
		try {
			
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de início do programa");
			//meuLogger.logger.warning("Log de Aviso");
			//meuLogger.logger.severe("Log Severo");
		
		} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();
		}
		
		meuLogger.logger.info("\n A calculadora foi iniciada");
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));
			meuLogger.logger.info("O operador selecionado foi o: " + operador);
			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			meuLogger.logger.info("\n O valor incluso no primeiro valor foi: " + a);
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();
			meuLogger.logger.info("\n O valor incluso no segundo valor foi: " + b);
		
			resultado = c.calcular(a, b, operador.charAt(0));
			System.out.println("O resultado de " + a + " " + operador + " " + b + " �:" + resultado);
			
			meuLogger.logger.info("\n A calculadora chegou no seu resultado: " + resultado + " e encerrou seu processo, caso queira realizar outra solicitação, abrir processo novamente.");
		}

	}

}
