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

   public void onClickGetEntidadeParam(View view) {
        EditText txtentidadeparam1 = (EditText) findViewById(R.id.widget28);
        EditText txtentidadeparam2 = (EditText) findViewById(R.id.widget27);

        ClienteGSON cliente = new ClienteGSON();
        try {
            Entidade testeGet = cliente.testeGet(txtentidadeparam1.getText().toString(), txtentidadeparam2.getText().toString());
            Log.w("Principal", testeGet.toString());
            Toast.makeText(this, testeGet.toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Log.w("Principal", "Erro", ex);
        }
    }

}
