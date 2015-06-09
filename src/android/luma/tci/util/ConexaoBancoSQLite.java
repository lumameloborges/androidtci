/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author User
 */
public class ConexaoBancoSQLite extends SQLiteOpenHelper{
    private Context context;
 
    public ConexaoBancoSQLite(Context context) {
        super(context, "posto", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE posto (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL);");
        db.execSQL("CREATE TABLE usuario (cod INTEGER PRIMARY KEY AUTOINCREMENT, bairro TEXT, cidade TEXT, complemento REAL, email TEXT, endereco TEXT, nome TEXT, senha TEXT, uf TEXT, username TEXT);");
        
        db.execSQL("INSERT INTO posto (nome) values ('Miguel');");
        db.execSQL("INSERT INTO posto (nome) values ('Daniel');");
        db.execSQL("INSERT INTO posto (nome) values ('Luma');");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS posto;");
        db.execSQL("DROP TABLE IF EXISTS usuario;");
        this.onCreate(db);
    }
    
}
