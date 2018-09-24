package br.com.iniciando.dao;

import br.com.iniciando.dominio.Cadastro;
import br.com.iniciando.dominio.Funcionario;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroDAO {
    
    private Conexao con;

    public CadastroDAO() {
        con = new Conexao();
    }

    public void adiciona(Cadastro cadastro){
        con.iniciaConexao();
        Cadastro c = cadastro;

        String sql = "insert into cliente(nome, cpf, loc, dev, carro) "
                + "values('" + c.getNome() + "','" + c.getCpf() + "',"
                + "'" + c.getLocacao() + "','" + c.getDevolucao() + "',"
                + "'" + c.getCarro() + "')";
        
        try {
            con.stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
    }

    public void adicionaFuncionario(Funcionario funcionario) throws SQLException {
        Funcionario f = funcionario;
        con.iniciaConexao();

        String sql = "insert into funcionario(nome, sobrenome, email, senha) "
                + "values('" + f.getNome() + "','" + f.getSobrenome() + "',"
                + "'" + f.getEmail() + "',SHA('" + f.getSenha() + "'))";

        try {
            con.stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.fechaConexao();
    }

    public Funcionario login(Funcionario funcionario) {
        Funcionario f = funcionario;
        con.iniciaConexao();
        String sql = "select * from funcionario where email='" + f.getEmail() + "' and senha=SHA('" + f.getSenha() + "')";

        try {
            ResultSet rs = con.stmt.executeQuery(sql);

            if (rs.next()) {
                f.setEmail(rs.getString("email"));
                f.setNome(rs.getString("nome"));
                f.setSobrenome(rs.getString("sobrenome"));
                f.setLogin(true);
                f.setSenha("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public List<Cadastro> busca(String cpf) throws SQLException {

        List<Cadastro> lista = new ArrayList<>();

        con.iniciaConexao();

        String sql = "select * from cliente where CPF = '" + cpf + "'";

        ResultSet rs = con.stmt.executeQuery(sql);

        while (rs.next()) {
            Cadastro cadastro = new Cadastro();

            cadastro.setNome(rs.getString("nome"));
            cadastro.setCpf(rs.getString("cpf"));
            cadastro.setLocacao(rs.getString("loc"));
            cadastro.setDevolucao(rs.getString("dev"));
            cadastro.setCarro(rs.getString("carro"));

            lista.add(cadastro);
        }

        return lista;
    }

    public void alterarLocacao(Cadastro cadastro) throws SQLException {

        Cadastro c = cadastro;
        con.iniciaConexao();
        
        String sql = "UPDATE cliente SET nome='" + c.getNome() + "', cpf='" + c.getCpf()
                + "', loc='" + c.getLocacao() + "', dev='" + c.getDevolucao()
                + "', carro='" + c.getCarro() + "' WHERE cpf='" + c.getCpf() + "'";

        con.stmt.executeUpdate(sql);
    }

    public void excluirDados(Cadastro cadastro) {

        Cadastro c = cadastro;
        con.iniciaConexao();

        String sql = "DELETE FROM cliente WHERE cpf='" + c.getCpf()+ "'";
        
        try {
            con.stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
