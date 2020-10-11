package ManipularArquivoTxt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivoTxt {
    public static void escreverArquivo(String nomeArquivo, String textoArquivo){
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(textoArquivo);

            // feche o arquivo
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Erro de escrita em '" + nomeArquivo + "'");
        }  
    }
}
