/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

import blueFire.model.dao.ClienteDAO;
import blueFire.model.dao.LoginDAO;
import blueFire.model.domain.UsuarioLogado;
import blueFire.utils.Utils;

/**
 *
 * @author CIANDT\ewerton
 */
public final class Cliente extends Pessoa implements UsuarioLogado {

    private final ClienteDAO clienteDao = new ClienteDAO();

    private Long idUsuario;
    private String email;
    private String senha;

    public Cliente(String nome, String sobrenome, String telefone, Endereco endereco, String email, Long idUsuario) {
        super(nome, sobrenome, telefone, endereco);
        
        this.email = email;
        this.idUsuario = idUsuario;
    }

    public Cliente(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Cliente() {

    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
        Utils utils = new Utils();

        boolean done;
        done = this.clienteDao.reservarVeiculo(idUsuario, idVeiculo, qtd, dataInicio);

        return done;
    }

}
