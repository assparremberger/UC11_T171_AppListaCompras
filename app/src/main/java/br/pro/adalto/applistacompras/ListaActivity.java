package br.pro.adalto.applistacompras;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private EditText produto;
    private ListView lvLista;

    private List<String> listaDeProdutos;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        produto = (EditText) findViewById(R.id.etProduto);
        lvLista = (ListView) findViewById(R.id.lvLista);


        //INICIO ----  Linhas para carregar o ListView ------
        listaDeProdutos = new ArrayList<>();
        adapter = new ArrayAdapter(
                ListaActivity.this,
                android.R.layout.simple_list_item_1,
                listaDeProdutos);
        lvLista.setAdapter(adapter);
        //FIM ----  Linhas para carregar o ListView ------



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        ListaActivity.this,
                        FormularioActivity.class);
                startActivity( intent );

//                listaDeProdutos.add( produto.getText().toString() );
//                adapter.notifyDataSetChanged();
//                produto.setText("");
//
//                Snackbar.make(view, "Produto salvo!", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {



                AlertDialog.Builder alerta = new AlertDialog.Builder(ListaActivity.this);
                alerta.setTitle("Atenção");
                alerta.setIcon(android.R.drawable.ic_dialog_alert);
                alerta.setMessage("Confirma a exclusão do produto "
                        + listaDeProdutos.get(position) + "?");
                alerta.setNeutralButton("Cancelar", null);
                alerta.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listaDeProdutos.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                alerta.show();

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
