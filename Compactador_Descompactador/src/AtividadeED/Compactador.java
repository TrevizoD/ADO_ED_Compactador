package AtividadeED;

import static Utils.EscreverArquivoTxt.escreverArquivo;
import static Utils.LerArquivoTxt.lerArquivo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            String[] palavrasLinha = linhaAtual.split(" ");
            
            for (String palavraAtual : palavrasLinha) {                
                //Cria o regex para verificar caracteres especiais
                Pattern pattern = Pattern.compile("[!, --?'.@]+");
                Matcher matcher = pattern.matcher(palavraAtual);
                String caractereEspecial = "";
                
                //Caso a palavra atual possua algum caractere especial
                if (matcher.find()) {
                    //Divide a palavra atual e o seu caractere especial
                    String[] palavraAtualArray = palavraAtual.split("[!, -?'.@]+");
                    
                    //Captura a palavra e o caractere especial
                    try {
                        palavraAtual = palavraAtualArray[0];
                        caractereEspecial = matcher.group();
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //Caso caia no catch, quer dizer que a palavra atual somente possui caracteres especiais
                        //portanto adicionamos direto no arquivo compactado
                        escreverArquivo(arquivoCompactado, palavraAtual + " ");
                        continue;
                    }
                }
                
                int indicePalavraJaCompactada = palavrasCompactadas.buscaElementoRetornaIndice(palavraAtual);
                
                //Caso essa palavra ja tenha  sido compactada, inserir no arquivo final o indice dela na ListaEncadeada
                if (indicePalavraJaCompactada > 0){
                    escreverArquivo(arquivoCompactado, indicePalavraJaCompactada + caractereEspecial + " ");
                } else {
                    //Caso seja a primeira vez que essa palavra aparece no arquivo,
                    //inserir a propria palavra no arquivo final e adiciona ela na ListaEncadeada
                    escreverArquivo(arquivoCompactado, palavraAtual + caractereEspecial + " ");
                    palavrasCompactadas.insereInicio(palavraAtual);
                }
            }
            
            //Pular a linha no arquivo final
            escreverArquivo(arquivoCompactado, "\n");
        }
    }
}
