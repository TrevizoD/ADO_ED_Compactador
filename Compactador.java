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
        
        //saída de arquivo da lista compactada
        //verificar se o arquivo "saida_trabalho1.txt" foi gerado na pasta do projeto
        compactada.escreveArquivo();
        
        //(próximos passos: 1. ler o arquivo de saída (como foi feito com o original)
        //                  2. fazer a substituição dos números pelas palavras correspondentes
        //                  3. imprimir aqui na tela, para verificar se tudo ok
        //                  4. inverter a ordem dos nós para corresponder com o arquivo original
        
    }
}
