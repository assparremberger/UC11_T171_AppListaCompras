package br.pro.adalto.applistacompras.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.pro.adalto.applistacompras.model.Categoria;

/**
 * Created by assparremberger on 23/08/2018.
 */

public class CategoriaDAO {

    public static final void inserir(Context contexto, Categoria categoria){
        ContentValues valores = new ContentValues();
        valores.put("nome", categoria.getNome() );

        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco =  conn.getWritableDatabase();
        banco.insert("categorias", null, valores);

    }

    public static final List<Categoria> getCategorias(Context contexto){
        List<Categoria> listaDeCategorias = new ArrayList<>();

        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getReadableDatabase();

        String sql = "SELECT * FROM categorias ORDER BY nome";
        Cursor tabela = banco.rawQuery(sql, null) ;

        if ( tabela.getCount() > 0 ){

            tabela.moveToFirst();

            do{
                Categoria cat = new Categoria();
                cat.setId( tabela.getInt( 0 ) );
                cat.setNome( tabela.getString( 1 ) );

                listaDeCategorias.add(cat);

            }while ( tabela.moveToNext() );

        }



        return listaDeCategorias;
    }

}
