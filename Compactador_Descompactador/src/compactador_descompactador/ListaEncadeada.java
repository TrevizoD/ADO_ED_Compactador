package compactador_descompactador;

public class ListaEncadeada {
    private No ini;
    
    //Construtor
    public ListaEncadeada() {
        this.ini = null;
    }
    
    public boolean isEmpty() {
        return this.ini == null;
    }
    
    //Insere elemento no comeco da lista
    public void insereInicio(String elemento) {
        No novoNo = new No(elemento, ini);
        ini = novoNo;
    }
    
    //Insere elemento no final da lista
    public void insereFinal(String elemento) {
        No novoNo = new No(elemento, null);
        No temp = ini;
        
        //Caso a lista esteja vazia
        if (temp == null){
            ini = novoNo;
        } else {
            //Caminha ate o ultimo No, dentre todos os nos dessa listaa
            while (temp.getProx() != null) {
                temp = temp.getProx();
            }

            //Se chegou ate o ultimo no, adicionar o elemento desejado
            temp.setProx(novoNo);
        }
    }
    
    //Procura por um elemento na lista
    public boolean buscaLinear(String elemento) {
        No temp = ini;
        
        //Percorre todos os elementos da lista, ate achar o elemento procurado, ou ate chegar ao final
        while (temp != null){
            if (temp.getElemento().equals(elemento)) {
                //Caso tenha encontrado o elemento
                return true;
            }
            
            temp = temp.getProx();
        }
        
        //Caso nao tenha encontrado o elemento
        return false;
    }
    
    //Procura por um elemento na lista
    public int buscaElementoRetornaIndice(String elemento) {
        No temp = ini;
        int count = 1;
        
        //Percorre todos os elementos da lista, ate achar o elemento procurado, ou ate chegar ao final
        while (temp != null){
            if (temp.getElemento().equals(elemento)) {
                //Caso tenha encontrado o elemento
                return count;
            }
            
            temp = temp.getProx();
            count++;
        }
        
        //Caso nao tenha encontrado o elemento
        return 0;
    }
    
    @Override
    public String toString() {
        String strLista = "";
        No temp = ini;
        
        while (temp != null){
            strLista = strLista + temp.getElemento() + " ";
            temp = temp.getProx();
        }
        
        return strLista;
    }
}
