/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iniciando.controller;

import br.com.iniciando.dao.CadastroDAO;
import br.com.iniciando.dominio.Cadastro;
import br.com.iniciando.dominio.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/recuperar")
    public String recuperar() {

        return "recuperar";
    }

    @RequestMapping("/indexDashboard")
    public String indexDashboard(HttpSession session) {

        if (session.getAttribute("funcionarioLogin") != null) {
            return "indexDashboard";
        } else {
            return "login";
        }
    }

    @RequestMapping("/tabelas")
    public String tabelas(Model model, Cadastro cadastro, HttpSession session) {
        if (session.getAttribute("funcionarioLogin") != null) {
            model.addAttribute("lista", new CadastroDAO(cadastro).buscaTodos());
            return "tabelas";
        } else {
            return "login";
        }
    }

    @RequestMapping("/logar")
    public String logar(Funcionario funcionario, HttpSession session) {
        funcionario = new CadastroDAO(funcionario).login();

        if (funcionario.isLogin()) {
            session.setAttribute("funcionarioLogin", funcionario);
            return "indexDashboard";
        } else {
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(Funcionario funcionario, HttpSession session) {
        session.removeAttribute("funcionarioLogin");
        return "login";
    }

    @RequestMapping("/cadastroFuncionario")
    public String submit(Model model, Funcionario funcionario, String submit) {

        Verificador verificador = new Verificador();

        String mensagem = verificador.validaNome(funcionario.getNome());
        String mensagem1 = verificador.validaNome(funcionario.getSobrenome());
        if (mensagem.equalsIgnoreCase("erro") || mensagem1.equalsIgnoreCase("erro")) {
            System.out.println("Erro no nome");
        } else if (mensagem.equalsIgnoreCase("ok")) {
            mensagem = new CadastroDAO(funcionario).adicionaFuncionario();
            model.addAttribute(mensagem);
            model.addAttribute(funcionario);
        }
        return "login";
    }

    @RequestMapping("/cadastro")
    public String iniciando(Model model, Cadastro cadastro, String submit) {
        Verificador verificador = new Verificador();
        String mensagem = verificador.validaNome(cadastro.getNome());

        if (mensagem.equalsIgnoreCase("erro")) {
            System.out.println("Erro no nome");
        } else if (mensagem.equalsIgnoreCase("ok")) {
            mensagem = new CadastroDAO(cadastro).adiciona();

            model.addAttribute("mensagem", mensagem);
        }
        return "index";
    }

    @RequestMapping("/lista")
    public String lista(Model model, Cadastro cadastro) {
        String mensagem;
        
        List<Cadastro> busca = new ArrayList<>();
        busca = new CadastroDAO(cadastro).busca();
        model.addAttribute("lista", busca);
        
        System.out.println("...:"+busca);
        
        if(busca.isEmpty()){
            mensagem = "CPF não encontrado!";
            model.addAttribute("mensagem2", mensagem);
        }

        return "index";
    }

    @RequestMapping("/editarExcluir")
    public String editarExcluir(Model model, Cadastro cadastro, String submit) {

        String mensagem = "";

        try {
            if (submit.compareTo("Editar") == 0) {
                mensagem = new CadastroDAO(cadastro).alterarLocacao();
            } else if (submit.compareTo("Excluir") == 0) {
                mensagem = new CadastroDAO(cadastro).excluirDados();
            }

        } catch (Exception e) {
            System.out.println("ERRO na lista do IniciandoController..:" + e.getMessage());
        }

        return "index";
    }
}
