package alura.com.br.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int qtdeDias){
        if(qtdeDias > 1) {
            return qtdeDias + PLURAL;
        }
        return qtdeDias + SINGULAR;
    }
}
