/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.dao;

import blueFire.model.database.ConnectionSingleton;
import blueFire.model.domain.impl.Reserva;
import blueFire.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIANDT\ewerton
 */
public class ClienteDAO {
    
    private Utils utils;

    public boolean reservarVeiculo(Reserva reserva) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;
        boolean check = false;

        try {

            stmt = conexao.prepareStatement("CALL reservarVeiculo(?,?,?,?);");
            stmt.setLong(1, reserva.getCliente().getIdUsuario());
            stmt.setLong(2, reserva.getVeiculo().getId());
            stmt.setInt(3, reserva.getQtdDias());                  
            stmt.setDate(4, reserva.getDataLocacao());
            check = stmt.execute();

            if (!check) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return check;
    }

}
