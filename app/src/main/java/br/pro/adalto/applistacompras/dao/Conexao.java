package br.pro.adalto.applistacompras.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by assparremberger on 23/08/2018.
 */

public class Conexao extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "appLista";
    private static final int VERSAO_BANCO = 1;

    public Conexao(Context contexto){
        super(contexto, NOME_BANCO, null, VERSAO_BANCO );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                " CREATE TABLE IF NOT EXISTS categorias (           " +
                "   id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "   nome TEXT NOT NULL  )                           " );

        sqLiteDatabase.execSQL(
                " CREATE TABLE IF NOT EXISTS produtos (             " +
                "   id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "   nome TEXT NOT NULL ,                            " +
                "   preco DOUBLE ,                                  " +
                "   codCategoria INTEGER )                          " );
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}








