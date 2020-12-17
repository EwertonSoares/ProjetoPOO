/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

import blueFire.model.dao.LoginDAO;
import blueFire.model.dao.VeiculoDAO;
import blueFire.model.domain.UsuarioLogado;
import java.util.List;

/**
 *
 * @author CIANDT\ewerton
 */
public class Administrador extends Pessoa implements UsuarioLogado {

    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private String email;
    private String senha;

    public Administrador(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Administrador() {
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
        return logar.checkarLoginESenha(email, senha, "adm");
    }

    public List<Reserva> pegarListaVeiculosReservados() {
        return this.veiculoDAO.listarVeiculosRservados();
    }

    public boolean confirmaRetiradaVeiculo(Long id) {
        return this.veiculoDAO.retiraVeiculo(id);
    }

    public boolean devolveVeiculo(Long id) {
        return this.veiculoDAO.devolverVeiculo(id);
    }

}
