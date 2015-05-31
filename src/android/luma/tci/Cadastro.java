/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci;

import android.app.Activity;
import android.content.Intent;
import android.luma.tci.bean.Usuario;
import android.luma.tci.ws.Entidade;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * @author User
 */
public class Cadastro extends Activity {
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        //this.atualiza();
        /* ListView lv = getListView();
         lv.setTextFilterEnabled(true);
         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
         }
         }); */
    }

    public void onClickVolta(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        
        

    }
    
    public void onClickLimpa(View v) {
        
        final EditText etNome       = (EditText) findViewById(R.id.txNome);
        final EditText etEndereco   = (EditText) findViewById(R.id.txEndereco);
        final EditText etUf         = (EditText) findViewById(R.id.txUf);
        final EditText etBairro     = (EditText) findViewById(R.id.txBairro);
        final EditText etCidade     = (EditText) findViewById(R.id.txCidade);
        final EditText etUsuario    = (EditText) findViewById(R.id.txUsuario);
        final EditText etSenha      = (EditText) findViewById(R.id.txSenha);
        final EditText etEmail      = (EditText) findViewById(R.id.txEmail);
        
        etNome.setText("");
        etEndereco.setText("");
        etUf.setText("");
        etBairro.setText("");
        etCidade.setText("");
        etUsuario.setText("");
        etSenha.setText("");
        etEmail.setText("");
        
        
        
    }

}
