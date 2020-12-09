/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.TelaVeiculo;
import blueFire.model.dao.VeiculoReservadoDAO;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.InformacoesGerais;
import blueFire.utils.Utils;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class VeiculoReservadoController implements Initializable {

    VeiculoReservadoDAO veiculoReservadoDAO = new VeiculoReservadoDAO();
    Utils utils = new Utils();
    Cliente cliente;

    @FXML
    private Button btnFechar;
    @FXML
    private ListView<InformacoesGerais> lvVeiculos;
    @FXML
    private Button btnRecarregar;

    private ObservableList<InformacoesGerais> oblVeiculos;
    private static Long idUsuario;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<InformacoesGerais> lista = this.veiculoReservadoDAO.listarVeiculosRservados();

        this.oblVeiculos = FXCollections.observableArrayList(lista);
        this.lvVeiculos.setItems(oblVeiculos);
    }

    @FXML
    public void foiRetirado() throws Exception {
        InformacoesGerais geral = (InformacoesGerais) this.lvVeiculos.getSelectionModel().getSelectedItem();

        boolean done = this.veiculoReservadoDAO.retiraVeiculo(geral.getVeiculo().getId());

        if (done) {
            utils.showAlert("Sucesso", "Vericulo retirado!", "Veiculo foi retirado!", Alert.AlertType.INFORMATION);
        } else {
            utils.showAlert("Erro", "Vericulo não retirado!", "Não foi possivel permitir"
                    + "\na retirada do veiculo.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void fechar() {
        utils.fecharJanela(this.btnFechar);
    }

    @FXML
    public void recarregarJanela() throws Exception {
        Stage stage = (Stage) this.btnRecarregar.getScene().getWindow();
        stage.close();

        TelaVeiculo Veiculo = new TelaVeiculo();
        Veiculo.start(new Stage());
    }

    public void setarIdUsuario(Long idUsuario) {
        VeiculoReservadoController.idUsuario = idUsuario;
    }

}
