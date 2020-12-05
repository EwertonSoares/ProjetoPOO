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
public class HistoricoClienteDAO {

    public List<Veiculo> pegarHistoricoCliente(Long idUsuario) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;
        ResultSet result;
        List<Veiculo> lista = new ArrayList();

        try {

            stmt = conexao.prepareStatement("CALL pegarHistoricoCliente(?)");
            stmt.setLong(1, idUsuario);

            result = stmt.executeQuery();

            while (result.next()) {
                String placa = result.getString("placa");
                Long ano = result.getLong("ano");
                String nome = result.getString("nome");
                String cor = result.getString("cor");
                int qtd = result.getInt("qtd");
                float valorLocacao = result.getFloat("valorLocacao");

                Veiculo veiculo = new Veiculo(placa, ano, nome, cor, null, qtd, valorLocacao);

                lista.add(veiculo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HistoricoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return lista;
    }
}
