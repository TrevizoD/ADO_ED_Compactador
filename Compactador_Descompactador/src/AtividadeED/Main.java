package AtividadeED;

import static AtividadeED.Compactador.*;
import static AtividadeED.Descompactador.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //Chamada da funcao estatica para compactar o arquvo.
        compactarArquivoTxt("arquivoCompactar.txt");
        
        //Chamada da funcao estatica para descompactar o arquivo compactado.
        descompactarArquivoTxt("arquivoCompactar--COMPACTADO.txt");
        
//        String teste = "Teste--";
//        Pattern pattern = Pattern.compile("[!, --?'.@]+");
//        Matcher matcher = pattern.matcher(teste);
//        matcher.find();
//        
//        System.out.println(matcher.group());
//        
        
    }
    
}
