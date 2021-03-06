package alura.com.br.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import alura.com.br.aluraviagens.R;
import alura.com.br.aluraviagens.dao.PacoteDAO;
import alura.com.br.aluraviagens.model.Pacote;
import alura.com.br.aluraviagens.ui.adapter.ListaPacotesAdapter;

import static alura.com.br.aluraviagens.ui.activity.PacoteActivitiesConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes,this));
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteSelecionado = pacotes.get(position);
                vaiParaResumoPacote(pacoteSelecionado);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteSelecionado) {
        Intent intent = new Intent(ListaPacotesActivity.this,
                ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteSelecionado);
        startActivity(intent);
    }
}