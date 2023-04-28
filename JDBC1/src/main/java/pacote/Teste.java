package pacote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "";
        BancoDados bd = new BancoDados();
        bd.conectar(url, user, password);
        Scanner s = new Scanner(System.in);
        System.out.println("Seja bem vindo ao banco de usuários");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Digite o seu usuário:");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String column1 = s.next();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Digite o seu email:");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String column2 = s.next();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Digite a sua senha:");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String column3 = s.next();

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
        }

        String consultar = "SELECT * FROM conta";
        bd.consultar(consultar);
        bd.desconectar();
    }
}
