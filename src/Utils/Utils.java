package Utils;

public class Utils {
    /**
     * Checa uma String para validar se e um numero ou nao.
     * @param elemento - String que deve ser checada.
     * @return boolean True caso a String seja um numero / False caso a String nao seja um numero.
     */
    public static boolean isNumber(String elemento) {
        try {
            Integer.parseInt(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
