/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.luma.tci.bean.Posto;
import android.luma.tci.util.ConexaoBancoSQLite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PostoDAO {

    private Context context;

    public PostoDAO(Context context) {
        this.context = context;
    }

    public void apagaTudo(){
        ConexaoBancoSQLite bd = new ConexaoBancoSQLite(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        String sql = "DELETE FROM posto";
        conn.execSQL(sql);
        
    }
    public void insert(Posto posto) {
        ConexaoBancoSQLite bd = new ConexaoBancoSQLite(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues postos = new ContentValues(1);
        postos.put("nome", posto.getNome());
        conn.insert("posto", null, postos);
        conn.close();

    }
    
    public List<Posto> listaTodos(){
             List<Posto> listaPost = new ArrayList<Posto>();
        ConexaoBancoSQLite bd = new ConexaoBancoSQLite(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        Cursor cursor = conn.rawQuery("SELECT p.cod, p.nome FROM posto p ORDER BY p.nome", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Posto post = new Posto();
            post.setCod(cursor.getInt(0));
            post.setNome(cursor.getString(1));
            listaPost.add(post);
            cursor.moveToNext();
        }
        conn.close();
        return listaPost;
    }
}
