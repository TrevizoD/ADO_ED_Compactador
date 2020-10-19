package AtividadeED;

import static Utils.EscreverArquivoTxt.escreverArquivo;
import static Utils.LerArquivoTxt.lerArquivo;
import static Utils.Utils.isNumber;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                            //Caso a palavra atual nao possua uma palavra depois do caractere especial
                            //Pass
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //Caso a palavra atual nao possua um caractere especial
                        //Pass
                    }
                }
                
                //Verifica as condicoes
                boolean palavraPossuiCaractereEspecial = !caractereEspecial.equals("");
                boolean palavraEstaCompactada = isNumber(palavraAtual);
                boolean palavraPossuiOutraPalavraDepoisCaractereEspecial = !palavraDepoisCaractereEspecial.equals("");
                String palavraCorrespondente = "";
                
                //Caso a palavra esteja compactada, pegar o numero correspondente
                if (palavraEstaCompactada) {
                    palavraCorrespondente = palavrasDescompactadas.getElementoIndice(Integer.parseInt(palavraAtual));
                }
                
                //Caso a palavra atual ja tenha sido compactada e nao possua caracter especial
                if (palavraEstaCompactada && !palavraPossuiCaractereEspecial) {
                    escreverArquivo(arquivoDescompactado, palavraCorrespondente + " ");
                    continue;
                }
                
                //Caso a palavra atual ja tenha sido compactada porem possui caractere especial
                if (palavraEstaCompactada && palavraPossuiCaractereEspecial) {
                    
                    //Verifica se existe alguma palavra depois do caractere especial
                    if (palavraPossuiOutraPalavraDepoisCaractereEspecial) {
                        //Caso a segunda palavra tambem esteja compactada
                        if (isNumber(palavraDepoisCaractereEspecial)) {
                            String segundaPalavraCorrespondente = palavrasDescompactadas.getElementoIndice(Integer.parseInt(palavraDepoisCaractereEspecial));
                            escreverArquivo(arquivoDescompactado, palavraCorrespondente + caractereEspecial + segundaPalavraCorrespondente + " ");
                            continue;
                        }
                        
                        //Caso a segunda palavra nao esteja compactada, colocar direto no arquivo e adicionar na ListaEncadeada
                        escreverArquivo(arquivoDescompactado, palavraCorrespondente + caractereEspecial + palavraDepoisCaractereEspecial + " ");
                        palavrasDescompactadas.insereInicio(palavraDepoisCaractereEspecial);
                        continue;
                    }
                    
                    //Caso nao exista uma palavra depois do caractere especial
                    escreverArquivo(arquivoDescompactado, palavraCorrespondente + caractereEspecial + " ");
                    continue;
                }
                
                //Adiciona a primeira palavra na ListEncadeada
                palavrasDescompactadas.insereInicio(palavraAtual);
                
                //Caso a palavra atual nao esteja compactada e nao possua caractere especial
                //colocar direto no arquivo e adicionar na ListaEncadeada
                if (!palavraPossuiCaractereEspecial) {
                    escreverArquivo(arquivoDescompactado, palavraAtual + " ");
                    continue;
                }
                
                //Caso a palavra atual nao esteja compactada e possua caractere especial,
                //verifica se existe alguma palavra depois do caractere especial
                if (palavraPossuiOutraPalavraDepoisCaractereEspecial) {
                    //Caso a segunda palavra esteja compactada
                    if (isNumber(palavraDepoisCaractereEspecial)) {
                        String segundaPalavraCorrespondente = palavrasDescompactadas.getElementoIndice(Integer.parseInt(palavraDepoisCaractereEspecial));
                        escreverArquivo(arquivoDescompactado, palavraAtual + caractereEspecial + segundaPalavraCorrespondente + " ");
                        continue;
                    }
                    
                    //Caso a segunda palavra nao esteja compactada e nao tenha caracter especial
                    //colocar direto no arquivo e adicionar na ListaEncadeada
                    escreverArquivo(arquivoDescompactado, palavraAtual + caractereEspecial + palavraDepoisCaractereEspecial + " ");
                    palavrasDescompactadas.insereInicio(palavraDepoisCaractereEspecial);
                    continue;
                }
                
                //Caso a palavra atual nao esteja compactada, mas possua um caractere especial
                escreverArquivo(arquivoDescompactado, palavraAtual + caractereEspecial + " ");
                palavrasDescompactadas.insereInicio(palavraDepoisCaractereEspecial);
            }
            
            //Pular a linha no arquivo final
            escreverArquivo(arquivoDescompactado, "\n");
        }
    }
}