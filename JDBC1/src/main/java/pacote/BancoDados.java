package pacote;

import java.sql.*;

public class BancoDados implements InterfaceBancoDados {
    private Connection conexao;

    private Statement statement;

    @Override
    public void conectar(String db_url, String db_user, String db_password) {
        try {
            conexao = DriverManager.getConnection(db_url, db_user, db_password);
            statement = conexao.createStatement();
            System.out.println("Estou conectado ao banco");
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }

    @Override
    public void desconectar() {
        try {
            statement.close();
            conexao.close();
            System.out.println("Desconectado do banco");

        } catch (SQLException e) {
            System.out.println("Erro ao desconectar" + e.getMessage());
        }
    }

    @Override
    public void consultar(String db_query) {
        try {
            ResultSet resultado = statement.executeQuery(db_query);
            while (resultado.next()) {
                System.out.println(resultado.getString(1) + " | " + resultado.getString(2) + " | " + resultado.getString(3));

            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    @Override
    public int inserirAlterarExcluir(String db_query) {
        try {
            int linhasAfetadas = statement.executeUpdate(db_query);
            System.out.println(linhasAfetadas + "linha afetada");
            return linhasAfetadas;
        } catch (SQLException e) {
            System.out.println("Erro na operação:" + e.getMessage());
            return 0;
        }
    }
}