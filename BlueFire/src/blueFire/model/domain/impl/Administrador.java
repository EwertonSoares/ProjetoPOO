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
public class Administrador extends Usuario implements UsuarioLogado {

    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private String email;
    private String senha;


    public Administrador(String email, String senha) {
        super(email, senha);
        
        this.email = email;
        this.senha = senha;
    }

    public Administrador() {
    }

    @Override
    public boolean logar() {
        LoginDAO logar = new LoginDAO();
        return logar.checkarLoginESenha(this.email, this.senha, "adm");
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
