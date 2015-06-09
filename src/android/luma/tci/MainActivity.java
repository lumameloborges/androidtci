package android.luma.tci;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.luma.tci.ws.ClienteGSON;
import android.luma.tci.ws.Entidade;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText edtUsuario, edtSenha;
    private CheckBox ckbConectado;

    private static final String MANTER_CONECTADO = "manter_conectado";
    private static final String PREFERENCE_NAME = "LoginActivityPreferences";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edtUsuario = (EditText) findViewById(R.id.login);
        edtSenha = (EditText) findViewById(R.id.senha);
        ckbConectado = (CheckBox) findViewById(R.id.login_ckbConectado);

        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        boolean conectado = preferences.getBoolean(MANTER_CONECTADO, false);

        if (conectado) {
            this.logar();
        }
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
            if (testeGet.isLogado()) {
                if (ckbConectado.isChecked()) {
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putBoolean(MANTER_CONECTADO, true);
                    editor.commit();
                }

                this.logar();

                //Toast.makeText(this, "autorizdo", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "sai fora!", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {
            Log.w("Principal", "Erro", ex);
        }
    }

    private void logar() {
        Intent i = new Intent();
        i.setClass(this, Principal.class);
        startActivity(i);
    }

}
