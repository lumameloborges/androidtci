package android.luma.tci;

import android.app.Activity;
import android.content.Intent;
import android.luma.tci.ws.ClienteGSON;
import android.luma.tci.ws.Entidade;
import android.os.Bundle;
import android.util.Log; 
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickCadastrar(View v) {
        Intent i = new Intent();
        i.setClass(this, Cadastro.class);
        startActivity(i);
    }

   public void onClickLogar(View view) {
        EditText etLogin = (EditText) findViewById(R.id.login);
        EditText etSenha = (EditText) findViewById(R.id.senha);
        

       // String ChamadaWS = "http://localhost:8080/TCI-war/meuservico/testeservico/luma/101010";
        
        ClienteGSON cliente = new ClienteGSON();
       
        try {
           Entidade testeGet = cliente.testeGet(etLogin.getText().toString(), etSenha.getText().toString());
           // Entidade testeGet = cliente.testeGet("luma", "101010");
            //Log.w("Principal", testeGet.toString());
           if(testeGet.isLogado()){
               Toast.makeText(this, "autorizdo", Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(this, "sai fora!", Toast.LENGTH_SHORT).show();
           }
            
        } catch (Exception ex) {
            Log.w("Principal", "Erro", ex);
        }
    }

}
