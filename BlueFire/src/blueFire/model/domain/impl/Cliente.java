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

    private Long idUsuario;
    private String email;
    private String senha;

    public Cliente(String nome, String sobrenome, String telefone, Endereco endereco,
            String email, Long idUsuario) {
        super(nome, sobrenome, telefone, endereco);

        this.email = email;
        this.idUsuario = idUsuario;
    }

    public Cliente(String email, String senha) {
        super(email, senha);
        
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

 
    @Override
    public boolean logar() {
        LoginDAO logar = new LoginDAO();
        return logar.checkarLoginESenha(this.email, this.senha, "user");
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
}
