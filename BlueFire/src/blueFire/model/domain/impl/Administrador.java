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

    private final String email;
    private final String senha;

    public Administrador(Long id, String nome, String sobrenome, String telefone, Endereco endereco, String email, String senha) {
        super(id, nome, sobrenome, telefone, endereco, email, senha);
        this.email = email;
        this.senha = senha;
    }

    @Override
    public boolean logar() {
        LoginDAO logar = new LoginDAO();
        return logar.checkarLoginESenha(this.email, this.senha);
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

    public static class Builder {

        protected String nome;
        protected String sobrenome;
        protected String telefone;
        protected Endereco endereco;
        protected String email;
        protected String senha;
        protected Long id;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder sobreNome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Administrador buid() {
            return new Administrador(id, nome, sobrenome, telefone, endereco, email, senha);
        }
    }

}
