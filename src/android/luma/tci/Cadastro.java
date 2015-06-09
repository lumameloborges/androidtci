/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci;

import android.app.Activity;
import android.content.Intent;
import android.luma.tci.bean.Usuario;
import android.luma.tci.dao.UsuarioDAO;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 *
 * @author User
 */
public class Cadastro extends Activity {
    
 private EditText bairro;
 private EditText endereco;
 private EditText cidade;
 private EditText nome;
 private EditText senha;
 private EditText username;
 private EditText uf;
// private EditText complemento;
 private EditText email;
 
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
    }

    public void onClickVolta(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        
        

    }
    
    public void onClickCadastra(View v) {
        UsuarioDAO userDAO = new UsuarioDAO(this);
        Usuario user = new Usuario();
        user.setBairro(bairro.getText().toString());
        user.setCidade(cidade.getText().toString());
        user.setEmail(email.getText().toString());
        user.setEndereco(endereco.getText().toString());
        user.setNome(nome.getText().toString());
        user.setSenha(senha.getText().toString());
        user.setUf(uf.getText().toString());
        user.setUsername(username.getText().toString());
        userDAO.create(user);
        finish();
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
