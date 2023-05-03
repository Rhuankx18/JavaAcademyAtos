package pacote;


import java.sql.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.Scanner;
import java.lang.String;

public class Teste {

    private Log meuLogger;

    public Teste() throws IOException{
     meuLogger = new Log("Log.txt");
   }

    public static void main(String[] args) throws IOException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "";
        BancoDados bd = new BancoDados();
        bd.conectar(url, user, password);
        Log meuLogger = new Log("Log.txt");

        try {
            meuLogger.logger.setLevel(Level.FINE);
            meuLogger.logger.warning("Aplicação JDBC iniciada");
            meuLogger.logger.info("Dado seguimento da ferramenta para inserção de usuários no banco de dados");
            //meuLogger.logger.severe("Log Severo");

        } catch (Exception e) {
            meuLogger.logger.info("Erro na execução da ferramenta JDBC" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Seja bem vindo ao banco de usuários");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Digite o seu usuário:");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String column1 = s.next();
        meuLogger.logger.info("Usuário inserido no banco de dados: " + column1);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Digite o seu e-mail:");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String column2 = s.next();
        meuLogger.logger.info("E-mail inserido no banco de dados: " + column2);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Digite a sua senha:");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String column3 = s.next();
        meuLogger.logger.info("Senha inserida no banco de dados: " + column3);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO conta (usuario, email, senha) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, column1);
            stmt.setString(2, column2);
            stmt.setString(3, column3);
            stmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao adicionar o usuário: " + e.getMessage());
            meuLogger.logger.severe("Erro ao adicionar o usuário" + e);
        }
        meuLogger.logger.info("Usuário registrado no banco de dados com sucesso:"+" "+ column1 +" "+ column2 +" "+ column3);

        String consultar = "SELECT * FROM conta";

        bd.consultar(consultar);



        meuLogger.logger.info("Aplicação executada e encerrada com sucesso");
        bd.desconectar();

    }
}
