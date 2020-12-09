/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.model.dao;

import blueFire.model.domain.impl.InformacoesGerais;
import blueFire.model.database.ConnectionSingleton;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Endereco;
import blueFire.model.domain.impl.Veiculo;
import java.sql.Connection;
import java.sql.Date;
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
public class VeiculoReservadoDAO {

    public List<InformacoesGerais> listarVeiculosRservados() {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;
        ResultSet result;
        List<InformacoesGerais> lista = new ArrayList();

        try {

            stmt = conexao.prepareStatement("SELECT * FROM vw_informacoes_gerais;");

            result = stmt.executeQuery();

            while (result.next()) {
                String nome = result.getString("nome");
                String sobreNome = result.getString("sobrenome");
                String telefone = result.getString("telefone");
                String bairro = result.getString("bairro");
                String rua = result.getString("rua");
                Long numero = result.getLong("numero");
                String email = result.getString("email");

                Endereco endereco = new Endereco(rua, numero, bairro);
                Cliente cliente = new Cliente(nome, sobreNome, telefone, endereco, email, null);

                String placa = result.getString("placa");
                Long ano = result.getLong("ano");
                String carro = result.getString("Carro");
                String cor = result.getString("cor");
                Long id = result.getLong("idVeiculo");
                int qtdDias = result.getInt("Qtd_dias");
                float valorLocacao = result.getFloat("valor_dia");

                Date dataLocacao = result.getDate("DataLocacao");
                Date dataDevolucao = result.getDate("DataDevolucao");
                boolean retirado = result.getBoolean("retirado");

                Veiculo veiculo = new Veiculo(placa, ano, carro, cor, id, qtdDias, valorLocacao);

                InformacoesGerais geral = new InformacoesGerais(cliente, veiculo, dataLocacao, dataDevolucao, retirado);

                lista.add(geral);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoReservadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return lista;
    }

    public boolean retiraVeiculo(Long id) {
        ConnectionSingleton connSing = ConnectionSingleton.getInstance();
        Connection conexao = connSing.connect();

        PreparedStatement stmt = null;
        boolean check = false;

        try {

            stmt = conexao.prepareStatement("UPDATE veiculo SET retirado = true WHERE idVeiculo = ?;");
            stmt.setLong(1, id);
            check = stmt.execute();

            if (!check) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoReservadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connSing.disconnect();
        }

        return check;
    }

}
