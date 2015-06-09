/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.ws;

import java.io.InputStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author User
 */
public class ClienteGSON {

    private static final String BASE_URI = "http://192.168.0.8:8080/TCI-war/meuservico/servico";
    private static final String BASE_URLPOSTO = "http://192.168.0.8:8080/TCI-war/meuservico/servicoposto/Posto/listatodos";

    public Entidade testeGet(String param1, String param2) throws Exception {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(String.format("%s/%s/%s", BASE_URI, param1.trim(), param2.trim())));
            HttpResponse response = httpclient.execute(request);
            InputStream content = response.getEntity().getContent();
            Reader reader = new InputStreamReader(content);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
            return gson.fromJson(reader, Entidade.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public List< Post> getPostos() throws Exception {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(String.format("%s", BASE_URLPOSTO)));
            HttpResponse response = httpclient.execute(request);
            InputStream content = response.getEntity().getContent();
            Reader reader = new InputStreamReader(content);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
            return gson.fromJson(reader, new TypeToken<List<Post>>() {
            }.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
