package AtividadeED;

import static Utils.EscreverArquivoTxt.escreverArquivo;
import static Utils.LerArquivoTxt.lerArquivo;
import static Utils.Utils.isNumber;

public class Descompactador {
    
    /**
     * Descompacta um determinado arquivo .txt passado como parametro.
     * @param caminhoArquivo String - String com o caminho do arquivo que deve ser descompactado.
     */
    public static void descompactarArquivoTxt(String caminhoArquivo) {
        //Le o arquivo a ser descompactado e separa linha por linha no array "linhasArray"
        String linhasArquivo = lerArquivo(caminhoArquivo);
        String[] linhasArray = linhasArquivo.split("\n");
        
        //Cria o caminho do arquivo final compactado
        String arquivoDescompactado = caminhoArquivo.replace("--COMPACTADO.txt", "") + "--DESCOMPACTADO.txt";
        
        //Cria uma nova lista encadeada que contem todas as palavras do arquivo descompactado
        ListaEncadeada palavrasDescompactadas = new ListaEncadeada();
        
        for (String linhaAtual : linhasArray) {
            //Separa palavra por palavra no aray "palavrasLinha"
            String[] palavrasLinha = linhaAtual.split(" ");
            
            for (String palavraAtual : palavrasLinha) {                 
                //Caso seja um numero, verificar qual e a palavra correspondente
                //(cada numero representa o indice da palavra correspondente na ListaEncadeada)
                if (isNumber(palavraAtual)) { 
                    String palavraCorrespondente = palavrasDescompactadas.getElementoIndice(Integer.parseInt(palavraAtual));
                    
                    escreverArquivo(arquivoDescompactado, palavraCorrespondente + " ");
                } else {
                    //Caso seja uma palavra, escrever ela mesmo no arquivo final e adicionar ela na ListaEncadeada
                    escreverArquivo(arquivoDescompactado, palavraAtual + " ");
                    palavrasDescompactadas.insereInicio(palavraAtual);
                }
            }
            
            //Pular a linha no arquivo final
            escreverArquivo(arquivoDescompactado, "\n");
        }
    }
}
