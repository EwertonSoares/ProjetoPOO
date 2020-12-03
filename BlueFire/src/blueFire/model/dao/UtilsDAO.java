/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.dao;

import blueFire.model.database.ConnectionSingleton;
import blueFire.model.domain.impl.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIANDT\ewerton
 */
public class UtilsDAO {

    public Long pegarIdUsuario(String email) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;
        ResultSet result;
        Long id = 0L;

        try {

            stmt = conexao.prepareStatement("SELECT idUsuario FROM usuario WHERE email = ?");
            stmt.setString(1, email);

            result = stmt.executeQuery();

            while (result.next()) {
                id = result.getLong("idUsuario");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return id;
    }
}
