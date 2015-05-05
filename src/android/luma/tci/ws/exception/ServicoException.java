/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.luma.tci.ws.exception;

/**
 *
 * @author User
 */
public class ServicoException extends Exception {
     public ServicoException() {
    }
    
    public ServicoException(String message) {
        super(message);
    }

    public ServicoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicoException(Throwable cause) {
        super(cause);
    }
    
    
}
