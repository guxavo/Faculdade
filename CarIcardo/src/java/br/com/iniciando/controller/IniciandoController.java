/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CadastroDAO;
import br.com.iniciando.dominio.Cadastro;
import br.com.iniciando.dominio.Funcionario;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author guzno
 */
@Controller
public class IniciandoController {

    @RequestMapping("/index")
    public String iniciando() {

        return "index";
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/registro")
    public String registro() {

        return "registro";
    }

    @RequestMapping("/indexDashboard")
    public String indexDashboard() {

        return "indexDashboard";
    }
    
    @RequestMapping("/tabelas")
    public String tabelas() {

        return "tabelas";
    }
    

    @RequestMapping("/recuperar")
    public String recuperar() {

        return "recuperar";
    }
    
    @RequestMapping("/logar")
    public String logar( Funcionario funcionario, HttpSession session){
        
        CadastroDAO dao = new CadastroDAO();
        Funcionario pessoa = dao.login(funcionario);
        
        if (pessoa.isLogin()){
            session.setAttribute("funcionarioLogin", pessoa);
            return "indexDashboard"; 
        }    
        else return "login";
    }
    
    @RequestMapping("/logout")
    public String logout( Funcionario funcionario, HttpSession session){
        
        funcionario.setLogin(Boolean.FALSE);
        
        return "login";
    }
    
    @RequestMapping("/cadastroFuncionario")
    public String cadastroFuncionario(Model model, Funcionario funcionario){
        
        CadastroDAO dao = new CadastroDAO();
        
        try {
            dao.adicionaFuncionario(funcionario);
            
            model.addAttribute("retorno", funcionario.getNome());
            
        } catch (Exception e) {
            System.out.println("ERRO no cadastroFuncionario do IniciandoController..: " + e.getMessage());
        }
        
        return "login";
    }
    
    @RequestMapping("/cadastro")
    public String iniciando(Model model, Cadastro cadastro) {

        CadastroDAO dao = new CadastroDAO();
        Verificador verificador = new Verificador();

        String mensagem = verificador.validaNome(cadastro.getNome());

        if (mensagem.equalsIgnoreCase("erro")) {
            System.out.println("Erro no nome");
        } else if (mensagem.equalsIgnoreCase("ok")) {
            try {
                dao.adiciona(cadastro);

                model.addAttribute("retorno", cadastro.getNome());
            } catch (Exception e) {
                System.out.println("ERRO no iniciando do IniciandoController..: " + e.getMessage());
            }
        }

        return "index";
    }

    @RequestMapping("/lista")
    public String lista(Model model, @RequestParam("cpf") String cpf) {

        CadastroDAO dao = new CadastroDAO();

        try {
            model.addAttribute("lista", dao.busca(cpf));

        } catch (Exception e) {
            System.out.println("ERRO na lista do IniciandoController..:" + e.getMessage());
        }

        return "index";
    }
    
    @RequestMapping("/editarExcluir")
    public String editarExcluir(Model model, Cadastro cadastro, String submit) {
        
        CadastroDAO dao = new CadastroDAO();

        try {
            if(submit.compareTo("Editar")== 0){
                System.out.println("AKI1");
                dao.alterarLocacao(cadastro);
            }
            else if(submit.compareTo("Excluir")== 0){
               dao.excluirDados(cadastro);
            }            

        } catch (Exception e) {
            System.out.println("ERRO na lista do IniciandoController..:" + e.getMessage());
        }

        return "index";
    }
}
