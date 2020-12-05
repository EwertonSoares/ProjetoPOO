/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.HistoricoCliente;
import blueFire.TelaVeiculo;
import blueFire.model.domain.impl.Cliente;
import blueFire.utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class PrincipalUserController implements Initializable {

    Cliente cliente;
    Utils utils = new Utils();
    private static Long idUsuario;

    @FXML
    private Button btnContinuar;
    @FXML
    private Button btnFechar;
    @FXML
    private RadioButton rdbFzrRes;
    @FXML
    private RadioButton rdbMinRes;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void abrirTelaDeVeiculos() throws Exception {
        if (this.rdbFzrRes.isSelected()) {
            TelaVeiculo listaDeVeiculos = new TelaVeiculo(this.idUsuario);
            listaDeVeiculos.start(new Stage());
        } else if (this.rdbMinRes.isSelected()) {
            HistoricoCliente historio = new HistoricoCliente(this.idUsuario);
            historio.start(new Stage());
        }
    }

    @FXML
    private void fechar() {
        utils.fecharJanela(btnFechar);
    }

    public void setarIdUsuario(Long idUsuario) {
        PrincipalUserController.idUsuario = idUsuario;
    }

    @FXML
    private void checkarRdbFzrRes() {
        if (this.rdbFzrRes.isSelected()) {
            this.rdbMinRes.setDisable(true);

        }

        if (!this.rdbFzrRes.isSelected()) {
            this.rdbMinRes.setDisable(false);

        }
    }

    @FXML
    private void checkarRdbMinhaRes() {
        if (this.rdbMinRes.isSelected()) {
            this.rdbFzrRes.setDisable(true);

        }

        if (!this.rdbMinRes.isSelected()) {
            this.rdbFzrRes.setDisable(false);

        }
    }
}
