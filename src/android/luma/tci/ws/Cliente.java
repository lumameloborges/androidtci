/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.ws;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.luma.tci.ws.exception.ServicoException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author User
 */
public class Cliente {

    static final String BASE_URI = "http://10.20.5.14:8080/TCI-war/meuservico/testeservico";

    public User validaLogin(String usuario, String senha) throws ServicoException {
        try {
            HttpClient httpcliente=new DefaultHttpClient();
            HttpGet request=new HttpGet();
            request.setURI(new URI(Cliente.BASE_URI));
            HttpResponse response=httpcliente.execute(request);
            InputStream content=response.getEntity().getContent();
            Reader reader=new InputStreamReader(content);
            Gson gson=new  Gson();
            User retorno = gson.fromJson(reader, User.class);
            return retorno;
        } catch (Exception ex) {
            throw new ServicoException("Falha na conexão http", ex);
        }
    }

//    private User makeRequestPost(byte[] params, String path) throws ServicoException {
//        try {
//            
//            URL urlObj = new URL(Cliente.BASE_URI + path);
//            HttpURLConnection httpConn = (HttpURLConnection) urlObj.openConnection();
//            httpConn.setDoInput(true);
//            httpConn.setDoOutput(true);
//            httpConn.setUseCaches(false);
//            httpConn.setRequestMethod("GET");
//            httpConn.setRequestProperty("Content-Type", "application/json");
//            httpConn.setRequestProperty("Connection", "close");
//            OutputStream output = httpConn.getOutputStream();
//            output.write(params);
//            String msg = httpConn.getResponseMessage();
//            int code = httpConn.getResponseCode();
//            if (code == 200) {
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                InputStream in = httpConn.getInputStream();
//                for (int c = in.read(); c != -1; c = in.read()) {
//                    baos.write(c);
//                }
//                baos.close();
//                return baos.toByteArray();
//            } else {
//                throw new ServicoException(String.format("Falha na conexão http [%s], Retorno [%d] Mensagem [%s]",
//                        Cliente.BASE_URI + path, code, msg));
//            }
//        } catch (ServicoException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw new ServicoException("Falha na conexão http", ex);
//        }
//    }
}
