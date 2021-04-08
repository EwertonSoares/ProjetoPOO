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
public class UtilsDAO {

    public Cliente buscaCliente(String email) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt;
        ResultSet result;
        Endereco endereco = new Endereco();
        Cliente cliente = new Cliente.Builder().buid();

        try {

            stmt = conexao.prepareStatement("CALL buscarCliente(?)");
            stmt.setString(1, email);

            result = stmt.executeQuery();

            while (result.next()) {
                endereco.setBairro(result.getString("bairro"));
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getLong("numero"));

                cliente = new Cliente.Builder()
                        .id(result.getLong("idUsuario"))
                        .nome(result.getString("nome"))
                        .sobreNome(result.getString("sobrenome"))
                        .email(result.getString("email"))
                        .telefone(result.getString("telefone"))
                        .endereco(endereco)
                        .buid();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return cliente;
    }
}
