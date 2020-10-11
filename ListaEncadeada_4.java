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
public class ListaEncadeada_4 {
    private No ini;
    
    public ListaEncadeada_4(){
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
    public ListaEncadeada_4 leArquivo(String arquivo){
        String linha = null;
        String[] palavra;
        ListaEncadeada_4 listaLinha = new ListaEncadeada_4();
        
        //abertura de arquivo e loop de leitura
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((linha = bufferedReader.readLine()) != null) {
                palavra = linha.split("[!, -?'.@]+");
                for(int i = 0; i < palavra.length; i++){
                    No nova = new No(palavra[i], ini);                    
                    //apenas palavras não repetidas entram na lista
                    if(!listaLinha.buscaLinear(nova)){
                        listaLinha.insereInicio(nova.getElemento());
                    } /*else{
                        listaLinha.insereInicio("(" + nova.getElemento() + ")");
                    }*/
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
    
    public boolean buscaLinear(No nova) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento().equals(nova.getElemento())) {
                return true; //achou
            }
            temp = temp.getProx();
        }
        return false; //não achou
    }
    
    public ListaEncadeada_4 repetidas(){
        ListaEncadeada_4 repetidas = new ListaEncadeada_4();
        No temp = ini;
        
        while (temp != null) {
            if (temp.getElemento().startsWith("(")) {
                if(!repetidas.buscaLinear(temp)){
                    repetidas.insereInicio(temp.getElemento()); //achou
                }
            }
            temp = temp.getProx();
        }
        
        return repetidas;
    }
    
    public ListaEncadeada_4 substitui0(ListaEncadeada_4 repetidas){
        ListaEncadeada_4 uniao = new ListaEncadeada_4();
        No ini1 = this.getIni();        //ini1 é o que olha para a lista1 (que chama o método)
        No ini2 = repetidas.getIni();   //ini2 é o que olha para a lista2 (parâmetro - que será percorrida)
        No iniUniao = ini1;             //ini da lista1 (a que chama o método)
                
        No temp = ini2;                 //percorro a lista2
        
        while (temp != null){
            No aux2 = temp;
            temp = temp.getProx();
            
            //se estiver, insiro na uniao
            //this porque percorro a lista1 (quem chama o método)
            if (this.buscaLinear(aux2)){
                aux2.setProx(iniUniao);
                iniUniao = aux2;
            }
        }
        
        uniao.setIni(iniUniao);     //tenho que set o ini da união, p/ que receba o ini
        return uniao;
    }
    
    public ListaEncadeada_4 substitui(ListaEncadeada_4 repetidas){
        ListaEncadeada_4 uniao = new ListaEncadeada_4();
        No ini1 = this.getIni();        //ini1 é o que olha para a lista1 (que chama o método)
        No ini2 = repetidas.getIni();   //ini2 é o que olha para a lista2 (parâmetro - que será percorrida)
        No iniUniao = ini1;             //ini da lista1 (a que chama o método)
                
        No temp = ini2;                 //percorro a lista2
        No aux1 = ini1;
        
        while (temp != null){
            No aux2 = temp;
            temp = temp.getProx();
            
            //se estiver, insiro na uniao
            //this porque percorro a lista1 (quem chama o método)
            if (this.buscaLinear(aux2)){
                //no da lista this tem o elemento set para o no da lista2 (aux2)
                aux1.setElemento(aux2.getElemento());
                aux2.setProx(iniUniao);
                iniUniao = aux2;
            }
        }
        
        uniao.setIni(iniUniao);     //tenho que set o ini da união, p/ que receba o ini
        return uniao;
    }
    
    /*public ListaEncadeada buscaLinear2(){
        ListaEncadeada compactada2 = new ListaEncadeada();
        No ini1 = this.getIni();
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento().equals(ini1.getElemento())) {
                return true; //achou
            }
            temp = temp.getProx();
        }
        return false; //não achou
    }*/
}
