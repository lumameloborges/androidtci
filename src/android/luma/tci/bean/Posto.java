/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.bean;

import java.io.Serializable;

/**
 *
 * @author User
 */


public class Posto implements Serializable {
    public String nome;
    public int cod;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 53 * hash + this.cod;
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
        final Posto other = (Posto) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }
    
}
