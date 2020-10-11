/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho1_Compactador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Denise Trevizo
 */
public class ListaEncadeada_2 {
    private No ini;
    
    public ListaEncadeada_2(){
        this.ini = null;
    }

    public No getIni() {
        return ini;
    }

    public void setIni(No ini) {
        this.ini = ini;
    }          

    @Override
    public String toString() {
        String strLista = "";
        No temp = ini;
        
        while(temp != null){
            strLista = strLista + temp.getElemento() + " ";
            temp = temp.getProx();
        }
        return strLista;
    }    
    
    /*********************************************************************/
    public void leArquivo(String arquivo){
        String linha = null;
        String[] palavra;
        ListaEncadeada_2 listaLinha = new ListaEncadeada_2();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((linha = bufferedReader.readLine()) != null) {
                palavra = linha.split("[!, -?'.@]+");
                for(int i = 0; i < palavra.length; i++){
                    String nova = palavra[i];
                    if(!listaLinha.buscaLinear(nova)){
                        listaLinha.insereInicio(nova);   
                    }
                    else if(listaLinha.buscaLinear(nova)){
                        //contar nó para pegar a posição!
                        //listaLinha.insereInicio(String.valueOf(i));
                    }                                 
                }
            }           
            System.out.println(listaLinha);
            
            //fechamento do arquivo
            bufferedReader.close(); 
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + arquivo + "'");                
        }
        catch(IOException ex) {
            System.out.println("Erro ao ler arquivo: '" + arquivo + "'");                  
        }
    }
    
        /*********************************************************************/
    public void leArquivo2(String arquivo){
        String linha = null;
        String[] palavra;
        ListaEncadeada_2 listaLinha = new ListaEncadeada_2();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((linha = bufferedReader.readLine()) != null) {
                palavra = linha.split("[!, -?'.@]+");
                for(int i = 0; i < palavra.length; i++){
                    String nova = palavra[i];
                    if(!listaLinha.buscaLinear(nova)){
                        listaLinha.insereInicio(nova);                        
                    } /*else if(listaLinha.buscaLinearPosicao(nova) > 0){
                        int posicao = listaLinha.buscaLinearPosicao(nova);
                        listaLinha.insereInicio(String.valueOf(posicao));
                        //busco
                        //vou contando o getProx
                        //contar nó para pegar a posição!
                        //listaLinha.insereInicio(String.valueOf(i));
                    } */                                
                }
            }           
            System.out.println(listaLinha);
            
            //fechamento do arquivo
            bufferedReader.close(); 
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + arquivo + "'");                
        }
        catch(IOException ex) {
            System.out.println("Erro ao ler arquivo: '" + arquivo + "'");                  
        }
    }
    
    /*********************************************************************/
    public void insereInicio(String elemento){
        No novo = new No(elemento, ini);
        ini = novo;
    }
    
    public boolean buscaLinear(String nova) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento().equals(nova)) {
                return true; //achou
            }
            temp = temp.getProx();
        }
        return false; //não achou
    }
}
