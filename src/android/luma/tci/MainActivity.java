package android.luma.tci;

import android.app.Activity;
import android.content.Intent;
import android.luma.tci.ws.Cliente;
import android.luma.tci.ws.User;
import android.luma.tci.ws.exception.ServicoException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
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

    public void onClickLogar(View v) {
        Log.i(MainActivity.class.getName(), "Chamou método");
        try {
            Cliente clientews = new Cliente();
            TextView txtLogin = (TextView) findViewById(R.id.widget30);
            User user = clientews.validaLogin(txtLogin.getText().toString(), "");
            if (user.isLogado()) {
                Toast.makeText(this, "Logou", Toast.LENGTH_LONG);
            } else {
                Toast.makeText(this, "Não logou", Toast.LENGTH_LONG);
            }

        } catch (ServicoException ex) {
            Log.w(MainActivity.class.getName(), "Chamou método", ex);
            Toast.makeText(this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG);
        }
    }

}
