/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.luma.tci.bean.Usuario;
import android.luma.tci.util.ConexaoBancoSQLite;

/**
 *
 * @author User
 */
public class UsuarioDAO {

    private Context context;

    public UsuarioDAO(Context context) {
        this.context = context;
    }

 public void create(Usuario user) {
        ConexaoBancoSQLite bd = new ConexaoBancoSQLite(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues usuarios = new ContentValues(1);
        usuarios.put("nome", user.getNome());
        usuarios.put("bairro", user.getBairro());
        usuarios.put("cidade", user.getCidade());
        usuarios.put("nome", user.getNome());
        usuarios.put("endereco", user.getEndereco());
        usuarios.put("email", user.getEmail());
        usuarios.put("uf", user.getUf());
        usuarios.put("username", user.getUsername());
        usuarios.put("senha", user.getSenha());
        usuarios.put("complemento", user.getComplemento());
        usuarios.put("cod", user.getCod());
        conn.insert("usuario", null, usuarios);
        conn.close();
    }
}
