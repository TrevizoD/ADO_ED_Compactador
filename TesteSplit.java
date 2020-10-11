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
public class TesteSplit {
    public static void main(String[] args){
        String str = "word1, word2's!gur word3@word4?word5.word6"; 
        String[] arrOfStr = str.split("[!, ?'.@]+");    //tem que ficar dentro dos colchetes 
  
        for (String a : arrOfStr){ 
            System.out.println(a);
        }
    }
}
