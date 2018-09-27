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
    private Funcionario f;
    private String mensagem;
    private Cadastro c;

    public CadastroDAO(Funcionario f) {
        con = new Conexao();
        this.f = f;
    }

    public CadastroDAO(Cadastro c) {
        con = new Conexao();
        this.c = c;
    }

    public String adiciona() {
        con.iniciaConexao();
        mensagem = "";

        String sql = "insert into cliente(nome, cpf, loc, dev, carro) "
                + "values('" + c.getNome() + "','" + c.getCpf() + "',"
                + "'" + c.getLocacao() + "','" + c.getDevolucao() + "',"
                + "'" + c.getCarro() + "')";

        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Cadastro realizado!";

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Falha no Cadastro!";
        }
        con.fechaConexao();
        return mensagem;
    }

    public String adicionaFuncionario() {
        con.iniciaConexao();
        String sql = "insert into funcionario(nome, sobrenome, email, senha) "
                + "values('" + f.getNome() + "','" + f.getSobrenome() + "',"
                + "'" + f.getEmail() + "',SHA('" + f.getSenha() + "'))";
        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Cadastro realizado!";
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Falha ao Cadastrar!";
        }
        return mensagem;
    }

    public Funcionario login() {
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
        con.fechaConexao();
        return f;
    }

    public List<Cadastro> busca() {
        List<Cadastro> lista = new ArrayList<>();

        con.iniciaConexao();

        String sql = "select * from cliente where CPF = '" + c.getCpf() + "'";

        try {
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

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "CPF não encontrado!";
        }
        return lista;
    }

    public String alterarLocacao() {
        con.iniciaConexao();

        String sql = "UPDATE cliente SET nome='" + c.getNome() + "', cpf='" + c.getCpf()
                + "', loc='" + c.getLocacao() + "', dev='" + c.getDevolucao()
                + "', carro='" + c.getCarro() + "' WHERE cpf='" + c.getCpf() + "'";

        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Dados Alterados!";
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Falha na Alteração!";
        }

        return mensagem;
    }

    public String excluirDados() {
        con.iniciaConexao();

        String sql = "DELETE FROM cliente WHERE cpf='" + c.getCpf() + "'";

        try {
            con.stmt.executeUpdate(sql);
            mensagem = "Dados Apagados!";
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem = "Falha ao Apagar Dados!";
        }
        return mensagem;
    }
    
    public List<Cadastro> buscaTodos() {
        List<Cadastro> lista = new ArrayList<>();

        con.iniciaConexao();

        String sql = "select * from cliente";

        try {
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

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
