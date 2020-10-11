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
public class ListaEncadeada_3 {
    private No ini;
    
    public ListaEncadeada_3(){
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
    public ListaEncadeada_3 leArquivo(String arquivo){
        String linha = null;
        String[] palavra;
        ListaEncadeada_3 listaLinha = new ListaEncadeada_3();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((linha = bufferedReader.readLine()) != null) {
                palavra = linha.split("[!, -?'.@]");
                for(int i = 0; i < palavra.length; i++){
                    No nova = new No(palavra[i], ini);                    
                    //apenas palavras não repetidas entram na lista
                    if(!listaLinha.buscaLinear(nova.getElemento())){
                        listaLinha.insereInicio(nova.getElemento());
                    } else if(listaLinha.contaNos2(nova) > 0){
                        int posicao = listaLinha.contaNos2(nova);
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
    
    public int contaNos2(No nova){  //está pegando o próprio valor da nova, não da original
        No temp = ini;
        int cont = 0;
          
        while (temp != null){
            if(!temp.getElemento().equals(nova.getElemento())){
                cont++;
            }              
            temp = temp.getProx();
        }
        return cont;
    }
        
}
