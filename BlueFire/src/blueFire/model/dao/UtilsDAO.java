/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.dao;

import blueFire.model.database.ConnectionSingleton;
import blueFire.model.domain.impl.Cliente;
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

        PreparedStatement stmt = null;
        ResultSet result;
        Cliente cliente = new Cliente();

        try {

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, email);

            result = stmt.executeQuery();

            while (result.next()) {
                cliente.setIdUsuario(result.getLong("idUsuario"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobrenome(result.getString("sobrenome"));
                cliente.setEmail(result.getString("email"));
                cliente.getEndereco().setBairro(result.getString("bairro"));
                cliente.getEndereco().setRua(result.getString("rua"));
                cliente.getEndereco().setNumero(result.getLong("numero"));
                cliente.setTelefone(result.getString("telefone"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return cliente;
    }
}
