package conexao;

import java.sql.*;

public class Conexao {
    
    private String URLConexao;
    private String DriverConexao;
    private Connection Conexao;
    public Statement stmt;

    public Conexao() {
        URLConexao = "jdbc:mysql://localhost:3306/caricardo?user=root&password=gustavo&autoReconnect=true";
        DriverConexao = "com.mysql.jdbc.Driver";
    }

    public Conexao(String BancoDados, String IpHost) {
        URLConexao = "jdbc:mysql://" + IpHost + ":3306/" + BancoDados + "?user=root&password=senha&autoReconnect=true";
        DriverConexao = "org.gjt.mm.mysql.Driver";
    }

    public void iniciaConexao() {
        try {
            Class.forName(DriverConexao);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro na criação do Dirver" + e + '\t');
        }
        try {
            Conexao = DriverManager.getConnection(URLConexao);
            stmt = Conexao.createStatement();
            System.out.println("Iniciando conexao com o Banco de Dados");
        } catch (SQLException e) {
            System.out.println("Erro Na conexao com o Banco de Dados" + e + '\t');

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState:     " + e.getSQLState());
            System.out.println("VendorError:  " + e.getErrorCode());
        }
    }

    public void fechaConexao() {
        try {
            stmt.close();
            Conexao.close();
            System.out.println("Fechando conexao com o Banco de Dados");
        } catch (SQLException e) {
            System.out.println("Erro Na conexao com o Banco de Dados" + e + '\t');
        }
    }
}
