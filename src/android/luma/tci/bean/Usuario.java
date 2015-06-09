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
    public int cod;
    public String nome;
    public String endereco;
    public String uf;
    public String bairro;
    public String cidade;
    public String email;
    public String complemento;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String endereco, String uf, String bairro, String cidade, String email, String username, String senha, String complemento) {
        this.nome = nome;
        this.endereco = endereco;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

     public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.cod;
        hash = 79 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 79 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 79 * hash + (this.uf != null ? this.uf.hashCode() : 0);
        hash = 79 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 79 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
        hash = 79 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 79 * hash + (this.username != null ? this.username.hashCode() : 0);
        hash = 79 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 79 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.cod != other.cod) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if ((this.uf == null) ? (other.uf != null) : !this.uf.equals(other.uf)) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.cidade == null) ? (other.cidade != null) : !this.cidade.equals(other.cidade)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s %s", username, senha);
    }

}
