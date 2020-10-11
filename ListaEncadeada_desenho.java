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
public class ListaEncadeada_desenho {
    private No ini;
    
    public ListaEncadeada_desenho(){
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
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                        
            while((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }   
                
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
    
    public void leArquivo2(String arquivo){
        String linha = null;
        ListaEncadeada_desenho listaLinha = new ListaEncadeada_desenho();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                        
            while((linha = bufferedReader.readLine()) != null) {
                //ListaEncadeada listaLinha = new ListaEncadeada();
                listaLinha.insereInicio(linha);
                //System.out.println(listaLinha);
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
    
    public void leArquivo3(String arquivo){
        String linha = null;
        ListaEncadeada_desenho listaLinha = new ListaEncadeada_desenho();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            linha = bufferedReader.readLine();
            String[] palavra = linha.split("[!, -?'.@]+");
            for(int i = 0; i < palavra.length; i++){
                listaLinha.insereInicio(palavra[i]);                
            }
            System.out.println(listaLinha);
            /*while((linha = bufferedReader.readLine()) != null) {
                //ListaEncadeada listaLinha = new ListaEncadeada();
                listaLinha.insereInicio(linha);
                //System.out.println(listaLinha);
            }           
            System.out.println(listaLinha);*/
            
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
    
    public void leArquivo4(String arquivo){
        String linha = null;
        ListaEncadeada_desenho listaLinha = new ListaEncadeada_desenho();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((linha = bufferedReader.readLine()) != null) {
                String[] palavra = linha.split("[!, -?'.@]+");
                for(int i = 0; i < palavra.length; i++){
                    listaLinha.insereInicio(palavra[i]);                
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
    
    public void leArquivo5(String arquivo){
        String linha = null;
        String[] palavra;
        ListaEncadeada_desenho listaLinha = new ListaEncadeada_desenho();
        
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
