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
    public static UsuarioLogado criar(String email, String senha, boolean ehAdm) {
        if(ehAdm){
            return new Administrador(email, senha);
        }
        
        return new Cliente(email, senha);
        
    }
}
