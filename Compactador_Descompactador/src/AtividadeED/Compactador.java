package AtividadeED;

import static Utils.EscreverArquivoTxt.escreverArquivo;
import static Utils.LerArquivoTxt.lerArquivo;

public class Compactador {
    
    /**
     * Compacta um determinado arquivo .txt passado como parametro.
     * @param caminhoArquivo String - String com o caminho do arquivo que deve ser compactado.
     */
    public static void compactarArquivoTxt(String caminhoArquivo) {
        //Le o arquivo a ser compacatado e separa linha por linha no array "linhasArray"
        String linhasArquivo = lerArquivo(caminhoArquivo);
        String[] linhasArray = linhasArquivo.split("\n");
        
        //Cria o caminho do arquivo final compactado
        String arquivoCompactado = caminhoArquivo.replace(".txt", "") + "--COMPACTADO.txt";
        
        //Cria uma nova lista encadeada que contem todas as palavras que ja foram compactadas,
        //ou seja, que ja foram transferidas para o arquivo final.
        ListaEncadeada palavrasCompactadas = new ListaEncadeada();
        
        //Iterage cada linha no arquivo a ser compactado
        for (String linhaAtual : linhasArray){
            //Separa palavra por palavra no aray "palavrasLinha"
            String[] palavrasLinha = linhaAtual.split("[!, -?'.@]+");
            
            for (String palavraAtual : palavrasLinha) {                
                int indicePalavraJaCompactada = palavrasCompactadas.buscaElementoRetornaIndice(palavraAtual);
                
                //Caso essa palavra ja tenha  sido compactada, inserir no arquivo final o indice dela na ListaEncadeada
                if (indicePalavraJaCompactada > 0){
                    escreverArquivo(arquivoCompactado, indicePalavraJaCompactada + " ");
                } else {
                    //Caso seja a primeira vez que essa palavra aparece no arquivo,
                    //inserir a propria palavra no arquivo final e adiciona ela na ListaEncadeada
                    escreverArquivo(arquivoCompactado, palavraAtual + " ");
                    palavrasCompactadas.insereInicio(palavraAtual);
                }
            }
            
            //Pular a linha no arquivo final
            escreverArquivo(arquivoCompactado, "\n");
        }
    }
}
