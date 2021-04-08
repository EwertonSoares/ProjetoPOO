/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.VeiculoReservado;
import blueFire.model.domain.impl.Administrador;
import blueFire.model.domain.impl.Reserva;
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

    private final Administrador administrador = new Administrador.Builder().buid();
    private final Utils utils = new Utils();

    @FXML
    private Button btnFechar;
    @FXML
    private ListView<Reserva> lvVeiculos;
    @FXML
    private Button btnRecarregar;

    private ObservableList<Reserva> oblVeiculos;
    private static Long idUsuario;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Reserva> lista = this.administrador.pegarListaVeiculosReservados();

        this.oblVeiculos = FXCollections.observableArrayList(lista);
        this.lvVeiculos.setItems(this.oblVeiculos);
    }

    @FXML
    public void foiRetirado() throws Exception {
        Reserva geral = (Reserva) this.lvVeiculos.getSelectionModel().getSelectedItem();

        boolean done = this.administrador.confirmaRetiradaVeiculo(geral.getVeiculo().getId());

        if (done) {
            utils.showAlert("Sucesso", "Vericulo retirado!",
                    "Veiculo foi retirado!", Alert.AlertType.INFORMATION);
        } else {
            utils.showAlert("Erro", "Vericulo não retirado!", "Erro inesperado"
                    + "\na retirada do veiculo com sucesso.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void foiDevolvido() throws Exception {
        Reserva geral = (Reserva) this.lvVeiculos.getSelectionModel().getSelectedItem();

        boolean done = this.administrador.devolveVeiculo(geral.getVeiculo().getId());

        if (done) {
            utils.showAlert("Sucesso", "Vericulo devolvido!",
                    "Veiculo foi devolvido com sucesso!!!", Alert.AlertType.INFORMATION);
        } else {
            utils.showAlert("Erro", "Vericulo não devolvido!", "Erro inesperado"
                    + "\na devolução do veiculo.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void voltar() {
        utils.fecharJanela(this.btnFechar);
    }

    @FXML
    public void recarregarJanela() throws Exception {
        Stage stage = (Stage) this.btnRecarregar.getScene().getWindow();
        stage.close();

        VeiculoReservado Veiculo = new VeiculoReservado();
        Veiculo.start(new Stage());
    }

    public void setarIdUsuario(Long idUsuario) {
        VeiculoReservadoController.idUsuario = idUsuario;
    }

}
