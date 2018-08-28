package br.pro.adalto.applistacompras;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import br.pro.adalto.applistacompras.dao.CategoriaDAO;
import br.pro.adalto.applistacompras.dao.ProdutoDAO;
import br.pro.adalto.applistacompras.model.Categoria;
import br.pro.adalto.applistacompras.model.Produto;

public class FormularioActivity extends AppCompatActivity {

    private Spinner spCategoria;
    private ArrayAdapter adapter;
    private List<Categoria> listaDeCategorias;

    private EditText etNome, etQuantidade;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome =       (EditText) findViewById(R.id.etNomeProduto);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        btnSalvar =    (Button)   findViewById(R.id.btnSalvar);

        spCategoria = (Spinner) findViewById(R.id.spCategoria);
        carregarCategorias();
    }

    private void salvarProduto(){

        String nome = etNome.getText().toString();

        if ( nome.isEmpty() || spCategoria.getSelectedItemPosition() == 0 ){
            //implementar mensagem de erro
        }else {
            Produto prod = new Produto();
            prod.setNome( nome );

            String quantidade = etQuantidade.getText().toString();
            double qtd = 0;
            if( ! quantidade.isEmpty() ){
                quantidade = quantidade.replace("," , ".");
                qtd = Double.valueOf( quantidade );
            }
            prod.setQuantidade(qtd);
            prod.setCategoria( (Categoria) spCategoria.getSelectedItem() );
            ProdutoDAO.inserir(this, prod);
            finish();

        }


    }



    private void carregarCategorias(){
        listaDeCategorias = CategoriaDAO.getCategorias(this);

        Categoria fake = new Categoria();
        fake.setId(0);
        fake.setNome( getResources().getString(R.string.txtSelecione) );

        listaDeCategorias.add(0 , fake);

        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1 , listaDeCategorias );
        spCategoria.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if( item.getItemId() == R.id.menu_nova_categoria ){

            AlertDialog.Builder alerta =
                    new AlertDialog.Builder(FormularioActivity.this);
            alerta.setTitle( getResources().getString(R.string.txtNovaCategoria));
            alerta.setIcon( android.R.drawable.ic_menu_edit );

            final EditText nomeCat = new EditText(FormularioActivity.this);
            nomeCat.setHint(R.string.hintCategoria);
            nomeCat.setTextColor(Color.BLUE);

            alerta.setView(nomeCat);
            alerta.setNeutralButton("Cancelar", null);
            alerta.setPositiveButton(getResources().getString(R.string.txtSalvar),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Categoria cat = new Categoria();
                            cat.setNome(  nomeCat.getText().toString() );
                            CategoriaDAO.inserir(FormularioActivity.this, cat);
                            carregarCategorias();
                        }
                    });
            alerta.show();

        }

        return super.onOptionsItemSelected(item);
    }
}
