package br.com.iniciando.dominio;

public class Funcionario {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Boolean login;
    
    public Funcionario(){
        login = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }
    
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha=" + senha + ", login=" + login +'}';
    }
}
