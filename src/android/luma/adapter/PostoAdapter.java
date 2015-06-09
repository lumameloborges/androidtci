/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.adapter;

import android.app.Activity;
import android.content.Context;
import android.luma.tci.R;
import android.luma.tci.bean.Posto;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 *
 * @author User
 */
public class PostoAdapter extends BaseAdapter{

    private Context context;
    private List<Posto> listPosto;

    public PostoAdapter(Context context, List<Posto> listPosto) {
        this.context = context;
        this.listPosto = listPosto;
    }
    
    public int getCount() {
        return listPosto.size();
    }

    public Object getItem(int arg0) {
        return listPosto.get(arg0);
    }

    public long getItemId(int arg0) {
        return arg0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        Posto posto = listPosto.get(position);
        
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.posto_list_view, null);
        }
        
        TextView txtTitulo = (TextView) view.findViewById(R.id.txtNomePosto);
        txtTitulo.setText(posto.getNome());
        
        return view;
    }
    
    
}
