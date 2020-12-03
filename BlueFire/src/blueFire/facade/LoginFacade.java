/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.facade;

import blueFire.model.domain.UsuarioLogado;

/**
 *
 * @author CIANDT\ewerton
 */
public class LoginFacade {
    
    public void logar(UsuarioLogado usuario) throws Exception {
        
        if(!usuario.logar()){
            throw new Exception("Login invalido");
        }
    }
    
}
