/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci;

import android.app.Activity;
import android.luma.adapter.PostoAdapter;
import android.luma.tci.bean.Posto;
import android.luma.tci.dao.PostoDAO;
import android.luma.tci.ws.ClienteGSON;
import android.luma.tci.ws.Post;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import java.util.List;

/**
 *
 * @author User
 */
public class Principal extends Activity {
    public PostoDAO postoDAO;
    public List<Posto> postoList;
    public PostoAdapter postoAdapter;
    public ListView lista;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //this.atualiza();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
        this.atualizaListPosto();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        
        
            if(id == R.id.action_menu_sincronizar){
                this.sincronismo();
        
        }
        return super.onOptionsItemSelected(item);
    }

     private void sincronismo() {
        ClienteGSON cliente = new ClienteGSON();
        try {
            List<Post> postos = cliente.getPostos();
            PostoDAO postoDAO = new PostoDAO(this);
            postoDAO.apagaTudo();
            for (Post post : postos) {
                Posto posto = new Posto();
                posto.setCod(post.getId());
                posto.setNome(post.getNome());
                postoDAO.insert(posto);
                
                
                Log.i("Principal", post.getNome());
            }
            
        } catch (Exception ex) {
            Log.w("Principal", "Erro", ex);
        }
        
        this.atualizaListPosto();
    }

    public void onClickAtualiza(View v) {
        ClienteGSON cliente = new ClienteGSON();
        try {
            List<Post> postos = cliente.getPostos();
            PostoDAO postoDAO = new PostoDAO(this);
            postoDAO.apagaTudo();
            for (Post post : postos) {
                Posto posto = new Posto();
                posto.setCod(post.getId());
                posto.setNome(post.getNome());
                postoDAO.insert(posto);
                Log.i("Principal", post.getNome());
            }
        } catch (Exception ex) {
            Log.w("Principal", "Erro", ex);
        }
    }

    public void onClickLeBDLocal(View v) {
        try {
            PostoDAO postoDAO = new PostoDAO(this);
            for (Posto posto : postoDAO.listaTodos()) {
                Log.i("Principal BD", posto.getNome());
            }
        } catch (Exception ex) {
            Log.w("Principal", "Erro", ex);
        }
    }

    private void atualiza() {
        PostoDAO postDAO = new PostoDAO(this);
        List<Posto> lista = postDAO.listaTodos();
        //setListAdapter(new ArrayAdapter(this, R.layout.principal, lista));
    }

    private void atualizaListPosto() {
        postoDAO = new PostoDAO(this);
        postoList = postoDAO.listaTodos();
        postoAdapter = new PostoAdapter(this, postoList);
        
        lista = (ListView) findViewById(R.id.lvPosto);
        lista.setAdapter(postoAdapter);
    }

   
}
