/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho1_Compactador;

/**
 *
 * @author Denise Trevizo (usp)
 */
public class Compactador {
    public static void main(String[] args){
        ListaEncadeada compactada = new ListaEncadeada();
        compactada = compactada.leArquivo("entrada_trabalho1.txt");
        
        //lista compactada: palavras únicas e sem caracteres especiais/ pontuação
        System.out.println(compactada);
        
        //lista descompactada
        //compactada.escreveArquivo("entrada_trabalho1.txt");
                
        //lista de palavras repetidas
        //System.out.println(compactada.repetidas());
        
        //lista compactada: palavras únicas, sem caracteres especiais/ pontuação 
        //e com posição de palavras repetidas
        //System.out.println(compactada.substitui(compactada.repetidas()));
    }
}
