/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 *
 * @author User
 */
public class Cadastro extends Activity {
    
    TextView limpar;

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
        //i.setClass(this, Cadastro.class);
        startActivity(i);
    }
    
    public void onClickLimpa(View v) {
        limpar.setText("");
    }

}
