/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Usuario implements Serializable {

    public String nome;
    public String endereco;
    public String uf;
    public String bairro;
    public String cidade;
    public String email;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String endereco, String uf, String bairro, String cidade, String email, String username, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.email = email;
        this.username = username;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s %s", username, senha);
    }

}
