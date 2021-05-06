package alura.com.br.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import alura.com.br.aluraviagens.model.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmtexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableEmtexto, DRAWABLE,
                context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
