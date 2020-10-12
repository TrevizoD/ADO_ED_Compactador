package AtividadeED;

import static AtividadeED.Compactador.*;
import static AtividadeED.Descompactador.*;

public class Main {

    public static void main(String[] args) {
        //Chamada da funcao estatica para compactar o arquvo.
        compactarArquivoTxt("arquivoCompactar.txt");
        
        //Chamada da funcao estatica para descompactar o arquivo compactado.
        descompactarArquivoTxt("arquivoCompactar--COMPACTADO.txt");
    }
    
}
