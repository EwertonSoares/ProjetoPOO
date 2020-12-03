/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.dao;

import blueFire.model.database.ConnectionSingleton;
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
public class LoginDAO {
    ConnectionSingleton connSing = ConnectionSingleton.getInstance();
    Connection conexao = connSing.connect();
    
    public boolean checkarLoginESenha(String login, String senha, String tipo) {
        
        PreparedStatement stmt = null;
        ResultSet result;
        try  {

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ? "
                    + "AND senha = ? "
                    + "AND tipo = ?");

            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setString(3, tipo);

            result = stmt.executeQuery();

            if (result.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return false;
    }
}
