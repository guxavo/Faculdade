package br.com.iniciando.controller;

import java.util.Scanner;
import static javafx.scene.input.KeyCode.Z;
import static org.apache.coyote.http11.Constants.a;

public class Verificador {


    public String validaNome(String nome) {
        
        System.out.println("Entrou no validaNome");
        
        int aux;
        int conf = 0;
        int erro = 0;
        String mensagem = "";

        
        //Verificação dos caracteres
        Character chr[] = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E',
            'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l',
            'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R',
            's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y',
            'Y', 'z', 'Z', ' '};

        for (int i = 0; i < nome.length(); i++) {
            aux = 0;
            for (int j = 0; j < chr.length; j++) {
                if (nome.charAt(i) == chr[j]) {
                    aux += 1;
                }
            }
            if (aux == 1) {
                conf = 1;
            } else {
                erro = 1;
            }
        }

        if (conf != 1 || erro == 1) {
            mensagem = "erro";
        } else {
            mensagem = "ok";
        }
        
        
        //verificação de algumas palavras reservadas
        String palavras[] = nome.split(" "); /*o split eh uma funcao do String que separa o texto em linhas de acordo 
                                                com uma regra, por exemplo, quero que meu texto seja separado cada vez 
                                                que aparecer um ";"*/
        String reservadas[] = {"SELECT", "WHERE", "FROM", "INSERT", "INTO"};
        erro=0;        
        for (int i = 0; i < palavras.length; i++) {
            for (int j = 0; j < reservadas.length; j++) {
                
                if(palavras[i].equalsIgnoreCase(reservadas[j])){
                    erro += 1;
                    System.out.println("Palavra..:"+palavras[i]+" = "+reservadas[j]);
                }
            }
        }
        
        if(erro != 0){
            mensagem = "erro";
        }
        else if(erro == 0){
            mensagem = "ok";
        }
        
        return mensagem;
    }
}
