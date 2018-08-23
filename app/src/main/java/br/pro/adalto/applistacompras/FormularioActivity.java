package br.pro.adalto.applistacompras;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
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

            EditText nomeCat = new EditText(FormularioActivity.this);
            nomeCat.setHint(R.string.hintCategoria);
            nomeCat.setTextColor(Color.BLUE);

            alerta.setView(nomeCat);
            alerta.setNeutralButton("Cancelar", null);
            alerta.setPositiveButton("SIM", null);
            alerta.show();

        }

        return super.onOptionsItemSelected(item);
    }
}
