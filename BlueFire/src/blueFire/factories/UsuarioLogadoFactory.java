/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.factories;

import blueFire.model.domain.UsuarioLogado;
import blueFire.model.domain.impl.Administrador;
import blueFire.model.domain.impl.Cliente;

/**
 *
 * @author CIANDT\ewerton
 */
public class UsuarioLogadoFactory {
    
    private final static String administrador = "ewerton@email.com";
    
    public static UsuarioLogado criar(String email, String senha) {
        
        if(email.equals(administrador)){
            return new Administrador.Builder()
                    .email(email)
                    .senha(senha)
                    .buid();
        }
        
        return new Cliente.Builder()
                .email(email)
                .senha(senha)
                .buid();
        
    }
}
