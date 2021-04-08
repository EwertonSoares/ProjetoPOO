/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.domain.impl;

import blueFire.model.dao.ClienteDAO;
import blueFire.model.dao.DadoClienteDAO;
import blueFire.model.dao.HistoricoClienteDAO;
import blueFire.model.dao.LoginDAO;
import blueFire.model.domain.UsuarioLogado;
import java.util.List;

/**
 *
 * @author CIANDT\ewerton
 */
public final class Cliente extends Usuario implements UsuarioLogado {

    private final ClienteDAO clienteDao = new ClienteDAO();
    private final DadoClienteDAO dadosCliente = new DadoClienteDAO();
    private final HistoricoClienteDAO historico = new HistoricoClienteDAO();

    private final String email;
    private final String senha;

    public Cliente(Long id, String nome, String sobrenome, String telefone, Endereco endereco, String email, String senha) {
        super(id, nome, sobrenome, telefone, endereco, email, senha);

        this.email = email;
        this.senha = senha;
    }

    @Override
    public boolean logar() {
        LoginDAO logar = new LoginDAO();
        return logar.checkarLoginESenha(email, senha);
    }

    public boolean fazerReserva(Reserva reserva) {
        return this.clienteDao.reservarVeiculo(reserva);
    }

    public List<Veiculo> consultarHistoricoReserva(Long id) {
        return this.historico.pegarHistoricoCliente(id);
    }

    public Cliente consultaPerfil(Long id) {
        return this.dadosCliente.carregarDadosCliente(id);
    }

    public boolean autualizaDadosCliente(Cliente cliente) {
        return this.dadosCliente.autualizaDadosCliente(cliente);
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

        public Cliente buid() {
            return new Cliente(id, nome, sobrenome, telefone, endereco, email, senha);
        }
    }
}
