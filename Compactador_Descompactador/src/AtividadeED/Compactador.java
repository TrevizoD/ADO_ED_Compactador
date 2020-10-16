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
                String palavraDepoisCaractereEspecial = "";
                
                //Caso a palavra atual possua algum caractere especial
                if (matcher.find()) {
                    //Divide a palavra atual e o seu caractere especial
                    String[] palavraAtualArray = palavraAtual.split("[!, --?'.@]+");
                    
                    //Captura a palavra e o caractere especial
                    try {
                        palavraAtual = palavraAtualArray[0];
                        caractereEspecial = matcher.group();
                        
                        //Tenta capturar a palavra que vem depois do caractere especial, caso exista
                        try {
                            palavraDepoisCaractereEspecial = palavraAtualArray[1];
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            //Pass
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //Caso a palavra atual nao possua um caractere especial
                        //Pass
                    }
                }
                
                //Verifica se a palavra atual ja foi compactada ou nao
                int indicePalavraAtual = palavrasCompactadas.buscaElementoRetornaIndice(palavraAtual);
                
                //Verifica as condicoes
                boolean palavraPossuiCaractereEspecial = !caractereEspecial.equals("");
                boolean palavraJaFoiCompactada = indicePalavraAtual > 0;
                boolean palavraPossuiOutraPalavraDepoisCaractereEspecial = !palavraDepoisCaractereEspecial.equals("");
                
                //Caso a palavra atual ja tenha sido compactada e nao possua caracter especial
                if (palavraJaFoiCompactada && !palavraPossuiCaractereEspecial) {
                    escreverArquivo(arquivoCompactado, indicePalavraAtual + " ");
                    continue;
                }
                
                //Caso a palavra atual ja tenha sido compactada porem possui caractere especial
                if (palavraJaFoiCompactada && palavraPossuiCaractereEspecial) {
                    
                    //Verifica se existe alguma palavra depois do caractere especial
                    if (palavraPossuiOutraPalavraDepoisCaractereEspecial) {
                        //Verifica se essa outra palavra ja foi compactada
                        int indiceSegundaPalavra = palavrasCompactadas.buscaElementoRetornaIndice(palavraDepoisCaractereEspecial);
                        
                        //Caso a segunda palavra ja tenha sido compactada
                        if (indiceSegundaPalavra > 0) {
                            escreverArquivo(arquivoCompactado, indicePalavraAtual + caractereEspecial + indiceSegundaPalavra + " ");
                            continue;
                        }
                        
                        //Caso a segunda palavra nao tenha sido compactada, colocar direto no arquivo e adicionar na ListaEncadeada
                        escreverArquivo(arquivoCompactado, indicePalavraAtual + caractereEspecial + palavraDepoisCaractereEspecial + " ");
                        palavrasCompactadas.insereInicio(palavraDepoisCaractereEspecial);
                        continue;
                    }
                    
                    escreverArquivo(arquivoCompactado, indicePalavraAtual + caractereEspecial + " ");
                    continue;
                }
                
                //Adiciona a primeira palavra na ListEncadeada
                palavrasCompactadas.insereInicio(palavraAtual);
                
                //Caso a palavra atual ainda nao tenha sido compactada e nao possua caractere especial
                //colocar direto no arquivo e adicionar na ListaEncadeada
                if (!palavraPossuiCaractereEspecial) {
                    escreverArquivo(arquivoCompactado, palavraAtual + " ");
                    continue;
                }
                
                //Caso a palavra atual ainda nao tenha sido compactada e possua caractere especial
                //Verifica se existe alguma palavra depois do caractere especial
                if (palavraPossuiOutraPalavraDepoisCaractereEspecial) {
                    //Verifica se essa outra palavra ja foi compactada
                    int indiceSegundaPalavra = palavrasCompactadas.buscaElementoRetornaIndice(palavraDepoisCaractereEspecial);

                    //Caso a segunda palavra ja tenha sido compactada
                    if (indiceSegundaPalavra > 0) {
                        escreverArquivo(arquivoCompactado, palavraAtual + caractereEspecial + indiceSegundaPalavra + " ");
                        continue;
                    }
                    
                    //Caso a segunda palavra nao tenha sido compactada e nao tenha caracter especial
                    //colocar direto no arquivo e adicionar na ListaEncadeada
                    escreverArquivo(arquivoCompactado, palavraAtual + caractereEspecial + palavraDepoisCaractereEspecial + " ");
                    palavrasCompactadas.insereInicio(palavraDepoisCaractereEspecial);
                    continue;
                }
                
                //Caso a palavra atual ainda nao tenha sido compactada, mas possui um caractere especial
                escreverArquivo(arquivoCompactado, palavraAtual + caractereEspecial + " ");
                palavrasCompactadas.insereInicio(palavraDepoisCaractereEspecial);
            }
            
            //Pular a linha no arquivo final
            escreverArquivo(arquivoCompactado, "\n");
        }
    }
}
