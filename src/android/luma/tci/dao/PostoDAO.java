/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.luma.tci.util.ConexaoBancoSQLite;
import android.luma.tci.ws.Post;
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
}
