/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

import blueFire.model.dao.ClienteDAO;
import blueFire.model.dao.LoginDAO;
import blueFire.model.domain.UsuarioLogado;
import java.util.Date;

/**
 *
 * @author CIANDT\ewerton
 */
public class Cliente extends Pessoa implements UsuarioLogado {
    
    private ClienteDAO clienteDao = new ClienteDAO();

    private String email;
    private String senha;

    public Cliente(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Cliente() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public boolean logar() {
        LoginDAO logar = new LoginDAO();
        return logar.checkarLoginESenha(email, senha, "user");
    }

    public boolean fazerReserva(Long idUsuario, Long idVeiculo, int qtd, String dataInicio) {
        boolean done;
        done = this.clienteDao.reservarVeiculo(idUsuario, idVeiculo, qtd, dataInicio);
        
        return done;
    }
    
}
