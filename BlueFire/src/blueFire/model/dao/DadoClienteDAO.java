/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.dao;

import blueFire.model.database.ConnectionSingleton;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIANDT\ewerton
 */
public class DadoClienteDAO {

    public Cliente carregarDadosCliente(Long idUsuario) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;
        ResultSet result;
        Cliente dadosCliente = new Cliente();

        try {

            stmt = conexao.prepareStatement("CALL pegarDadosDoUsuario(?)");
            stmt.setLong(1, idUsuario);

            result = stmt.executeQuery();

            while (result.next()) {
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String email = result.getString("email");
                String telefone = result.getString("telefone");

                String rua = result.getString("rua");
                Long numero = result.getLong("numero");
                String bairro = result.getString("bairro");

                Endereco endereco = new Endereco(rua, numero, bairro);
                Cliente cliente = new Cliente(nome, sobrenome, telefone, endereco, email, idUsuario);

                dadosCliente = cliente;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DadoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return dadosCliente;
    }

    public boolean autualizaDadosCliente(Cliente cliente) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;

        try {

            stmt = conexao.prepareStatement("CALL atualizaDadosCliente(?,?,?,?,?,?,?,?);");

            stmt.setLong(1, cliente.getIdUsuario());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getSobrenome());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco().getBairro());
            stmt.setString(6, cliente.getEndereco().getRua());
            stmt.setLong(7, cliente.getEndereco().getNumero());
            stmt.setString(8, cliente.getTelefone());

            if (!stmt.execute()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DadoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return false;
    }

}
