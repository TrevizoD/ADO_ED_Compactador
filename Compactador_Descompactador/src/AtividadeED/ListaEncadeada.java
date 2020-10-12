package AtividadeED;

public class ListaEncadeada {
    private No ini;
    
    //Construtor
    public ListaEncadeada() {
        this.ini = null;
    }
    
    /**
     * Checa se a ListaEncadeada esta vazia ou nao.
     * @return boolean - True caso a ListaEncadeada esteja vazia / False caso a ListaEncadeda nao esteja vazia.
     */
    public boolean isEmpty() {
        return this.ini == null;
    }
    
    /**
     * Insere um novo elemento no inicio da ListaEncadeada.
     * @param elemento String - String que deve ser adicionada no inicio da ListaEncadeada.
     */
    public void insereInicio(String elemento) {
        No novoNo = new No(elemento, ini);
        ini = novoNo;
    }
    
    /**
     * Insere um novo elemento no final da ListaEncadeada.
     * @param elemento String - String que deve ser adicionada no final da ListaEncadeada.
     */
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
    
    /**
     * Busca um elemento na ListaEncadeada, e caso ele exista retorna o indice do mesmo na ListaEncadeada.
     * @param elemento String - String que deve ser procurada na ListaEncadeada.
     * @return int - O indice do elemento encontrado na ListaEncadeada. Caso nao seja encontrado retornara 0.
     */
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
    
    /**
     * Procura por um elemento num determinado indice da ListaEncadeada.
     * @param indice int - indice do elemento que deve ser retornado.
     * @return String - String do elemento no indice escolhido na ListaEncadeada.
     */
    public String getElementoIndice(int indice) {
        No temp = ini;
        int count = 1;
        
        //Percorre todos os elementos da lista, ate achar o elemento procurado, ou ate chegar ao final
        while (temp != null){
            if (count == indice) {
                //Caso tenha encontrado o elemento
                return temp.getElemento();
            }
            
            temp = temp.getProx();
            count++;
        }
        
        return "";
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
