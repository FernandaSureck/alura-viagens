package alura.com.br.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRÃO = "R$";
    public static final String FORMATO_COM_ESPACO = "R$ ";

    public static String formataParaBrasileiro(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale(PORTUGUES, BRASIL));
        return formatoBrasileiro.format(valor)
                .replace(FORMATO_PADRÃO, FORMATO_COM_ESPACO);
    }
}
