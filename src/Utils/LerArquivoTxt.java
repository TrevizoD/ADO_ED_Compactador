package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoTxt {
    
    public static String lerArquivo(String nomeArquivo){
        String linha;
        String resultado = "";
        
        try {
            FileReader fileReader = new FileReader(nomeArquivo);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // loop por cada linha do arquivo
            while((linha = bufferedReader.readLine()) != null) {
                resultado = resultado + linha + "\n";
            }   

            // feche o arquivo
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeArquivo + "'");                
        }
        catch(IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeArquivo + "'");                  
        }
        
        return resultado;
    }
}
