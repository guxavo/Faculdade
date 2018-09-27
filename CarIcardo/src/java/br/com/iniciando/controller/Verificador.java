package br.com.iniciando.controller;

import br.com.iniciando.dominio.Funcionario;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.Z;
import static org.apache.coyote.http11.Constants.a;

public class Verificador {

    public String validaEmail(String text) {

        int aux;
        int conf = 0;
        int erro = 0;        
        String mensagem = "";

        String reservadas[] = {"SELECT", "WHERE", "FROM", "INSERT", "INTO"};
        Character chr[] = {'\'', '\"', ' ', '*', '+', ',', '<', '>', '|',
            '#', '%', '\\', ';', '/', '$', '!', '(', ')', '=', '´', '`', '^',
            '~', '[', ']', '{', '}', 'º', 'ª', '?'};
        
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < chr.length; j++) {
                if (text.charAt(i) == chr[j]) {
                    erro += 1;
                }
            }
        }
        
        String palavras[] = text.split(" ");
        
        for (int i = 0; i < palavras.length; i++) {
            for (int j = 0; j < reservadas.length; j++) {

                if (palavras[i].equalsIgnoreCase(reservadas[j])) {
                    erro += 1;
                }
            }
        }
        
        if(erro != 0){
            mensagem = "erro";
        }
        else{
            mensagem = "ok";
        }

        return mensagem;
    }

    public String validaNome(String text) {

        int aux;
        int conf = 0;
        int erro = 0;
        String mensagem = "";

        //Verificação dos caracteres
        Character chr[] = {'\'', '\"', ' ', '*', '-', '+', '|', ',', '<', '>',
            '#', '%', '\\', ';', '/', '$', '!', '(', ')', '=', '´', '`', '^',
            '~', '[', ']', '{', '}', 'º', 'ª', '?', '.', '@'};
        
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < chr.length; j++) {
                if (text.charAt(i) == chr[j]) {
                    erro += 1;
                }
            }
        }

        //verificação de algumas palavras reservadas
        String palavras[] = text.split(" ");
        /*o split eh uma funcao do String que separa o texto em linhas de acordo 
                                                com uma regra, por exemplo, quero que meu texto seja separado cada vez 
                                                que aparecer um ";"*/
        String reservadas[] = {"SELECT", "WHERE", "FROM", "INSERT", "INTO"};

        for (int i = 0; i < palavras.length; i++) {
            for (int j = 0; j < reservadas.length; j++) {

                if (palavras[i].equalsIgnoreCase(reservadas[j])) {
                    erro += 1;
                }
            }
        }
        
        if(erro != 0){
            mensagem = "erro";
        }else{
            mensagem = "ok";
        }
        
        return mensagem;
    }
}
