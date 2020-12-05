/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.model.dao.HistoricoClienteDAO;
import blueFire.model.domain.impl.Veiculo;
import blueFire.utils.Utils;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author CIANDT\ewerton
 */
public class HistoricoClienteController implements Initializable {

    @FXML
    private ListView<Veiculo> lvHistorico;
    @FXML
    private Button btnVoltar;

    private ObservableList<Veiculo> oblVeiculos;
    HistoricoClienteDAO historico = new HistoricoClienteDAO();
    private static Long idUsuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Veiculo> lista = historico.pegarHistoricoCliente(this.idUsuario);

        this.oblVeiculos = FXCollections.observableArrayList(lista);
        this.lvHistorico.setItems(oblVeiculos);
    }

    @FXML
    private void voltar() {
        Utils utils = new Utils();
        utils.fecharJanela(this.btnVoltar);
    }

    public void setarIdUsuario(Long idUsuario) {
        HistoricoClienteController.idUsuario = idUsuario;
    }

}
