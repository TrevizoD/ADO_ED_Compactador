package AtividadeED;

public class teste {
    public static void main(String[] args){
        String teste1 = "it";

        boolean b1 = teste1.matches(".*,$");
        boolean b2 = teste1.matches(".*'$");
        boolean b3 = teste1.matches(".*[.,'-@?!+()]$");
        boolean b4 = teste1.matches(".*-$");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        
        //Teste
        /*
        Compactador.java
        linha 27: String[] palavrasLinha = linhaAtual.split("[' -]+");
        - essa expressão do split separa por apóstrofe, espaço e traço, 
        não incluindo esses caracteres no arquivo de saída
        
        ListaEncadeada.java
        linha 61:
        if ((temp.getElemento().equals(elemento)) 
                || (temp.getElemento().equals(elemento + ".")) 
                || (temp.getElemento().equals(elemento + ","))) {
            //Caso tenha encontrado o elemento
            return count;
        }
        - combinado com o split descrito anteriormente, 
        esse if permite que ponto e vírgula sejam incluídos no arquivo de saída
        (se elemento = "much" ou elemento = "much.", por exemplo)
        */
    }
}
