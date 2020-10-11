/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho1_Compactador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Denise Trevizo
 */
public class ListaEncadeada {
    private No ini;
    
    public ListaEncadeada(){
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
    public ListaEncadeada leArquivo(String arquivo){
        String linha = null;
        String[] palavra;
        ListaEncadeada listaLinha = new ListaEncadeada();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((linha = bufferedReader.readLine()) != null) {
                //(problema no split > tem um espaço a mais na saída - sujeirinha)
                //(está sem ponto, vírgula e traço - aparecem na saída da professora,
                //mas, se manter aqui, a palavra repetida vem junto = por isso escolhi tirar tudo)
                palavra = linha.split("[!, -?'.@]+");
                for(int i = 0; i < palavra.length; i++){
                    No nova = new No(palavra[i], ini);                    
                    //apenas palavras não repetidas entram na lista
                    //se for repetida, a posição da primeira ocorrência é inserida
                    if(!listaLinha.buscaLinear(nova)){
                        listaLinha.insereInicio(nova.getElemento());
                    } else{                        
                        int posicao = listaLinha.buscaLinearCont(nova);
                        listaLinha.insereInicio(String.valueOf(posicao));
                    }
                }
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
        
        return listaLinha;
    }
    
    /*public void escreveArquivo(String arquivo){
        String arquivoDeSaida = "saida_trabalho1.txt";

        try {
            FileWriter fileWriter = new FileWriter(arquivoDeSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write();

            // feche o arquivo
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro de escrita em '" + arquivoDeSaida + "'");
        }    
    }*/
        
    /*********************************************************************/
    public void insereInicio(String elemento){
        No novo = new No(elemento, ini);
        ini = novo;
    }
    
    public boolean buscaLinear(No nova) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento().equals(nova.getElemento())) {
                return true;
            }
            temp = temp.getProx();
        }
        return false; 
    } 
    
    public int buscaLinearCont(No nova) {   
        No temp = this.getIni();    //(ini listaLinha)
        int cont = 1;
        
        while (temp != null) {
            if (temp.getElemento().equals(nova.getElemento())) {
                return cont;
            }
            temp = temp.getProx();
            //(está contando as Strings numéricas também!
            //if que ignore esses números (para bater com a saída da professora))
            cont++;
        }
        return cont;
    }
    
}
