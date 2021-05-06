package alura.com.br.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.aluraviagens.R;
import alura.com.br.aluraviagens.model.Pacote;
import alura.com.br.aluraviagens.util.DataUtil;
import alura.com.br.aluraviagens.util.MoedaUtil;
import alura.com.br.aluraviagens.util.ResourceUtil;

import static alura.com.br.aluraviagens.ui.activity.PacoteActivitiesConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);
        carregaPacoteSelecionado();
    }

    private void carregaPacoteSelecionado() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String precoEmReal = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoEmReal);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_viagem);
        String dataEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}