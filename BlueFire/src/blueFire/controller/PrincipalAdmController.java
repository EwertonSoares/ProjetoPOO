/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.DadoCliente;
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
public class PrincipalAdmController implements Initializable {

    Cliente cliente;
    Utils utils = new Utils();
    private static Long idUsuario;

    @FXML
    private Button btnContinuar;
    @FXML
    private RadioButton rdbConfDev;
    @FXML
    private RadioButton rdbCadasVei;
    @FXML
    private RadioButton rdbVeriReser;
    @FXML
    private RadioButton rdbAtuaVei;
    @FXML
    private RadioButton rdbRemoveVei;

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
    private void continuar() throws Exception {
//        if (this.rdbFzrRes.isSelected()) {
//            TelaVeiculo listaDeVeiculos = new TelaVeiculo(this.idUsuario);
//            listaDeVeiculos.start(new Stage());
//        } else if (this.rdbMinRes.isSelected()) {
//            HistoricoCliente historio = new HistoricoCliente(this.idUsuario);
//            historio.start(new Stage());
//        } else if(this.rdbMeusDados.isSelected()) {
//            DadoCliente dadosCliente = new DadoCliente(this.idUsuario);
//            dadosCliente.start(new Stage());
//        }
    }

    public void setarIdUsuario(Long idUsuario) {
        PrincipalAdmController.idUsuario = idUsuario;
    }

    @FXML
    private void checkRdbConfDev() {
        if (this.rdbConfDev.isSelected()) {
            this.rdbAtuaVei.setDisable(true);
            this.rdbCadasVei.setDisable(true);
            this.rdbRemoveVei.setDisable(true);
            this.rdbVeriReser.setDisable(true);
        }

        if (!this.rdbConfDev.isSelected()) {
            this.rdbAtuaVei.setDisable(false);
            this.rdbCadasVei.setDisable(false);
            this.rdbRemoveVei.setDisable(false);
            this.rdbVeriReser.setDisable(false);
        }
    }

    @FXML
    private void checkRdbCadasVei() {
        if (this.rdbCadasVei.isSelected()) {
            this.rdbAtuaVei.setDisable(true);
            this.rdbConfDev.setDisable(true);
            this.rdbRemoveVei.setDisable(true);
            this.rdbVeriReser.setDisable(true);

        }

        if (!this.rdbCadasVei.isSelected()) {
            this.rdbAtuaVei.setDisable(false);
            this.rdbConfDev.setDisable(false);
            this.rdbRemoveVei.setDisable(false);
            this.rdbVeriReser.setDisable(false);

        }
    }

    @FXML
    private void checkRdbVeriReser() {
        if (this.rdbVeriReser.isSelected()) {
            this.rdbAtuaVei.setDisable(true);
            this.rdbCadasVei.setDisable(true);
            this.rdbRemoveVei.setDisable(true);
            this.rdbConfDev.setDisable(true);

        }

        if (!this.rdbVeriReser.isSelected()) {
            this.rdbAtuaVei.setDisable(false);
            this.rdbCadasVei.setDisable(false);
            this.rdbRemoveVei.setDisable(false);
            this.rdbConfDev.setDisable(false);
        }
    }

    @FXML
    private void checkRdbAtuaVei() {
        if (this.rdbAtuaVei.isSelected()) {
            this.rdbVeriReser.setDisable(true);
            this.rdbCadasVei.setDisable(true);
            this.rdbRemoveVei.setDisable(true);
            this.rdbConfDev.setDisable(true);

        }

        if (!this.rdbAtuaVei.isSelected()) {
            this.rdbVeriReser.setDisable(false);
            this.rdbCadasVei.setDisable(false);
            this.rdbRemoveVei.setDisable(false);
            this.rdbConfDev.setDisable(false);
        }
    }

    @FXML
    private void checkRdbRemoveVei() {
        if (this.rdbRemoveVei.isSelected()) {
            this.rdbVeriReser.setDisable(true);
            this.rdbCadasVei.setDisable(true);
            this.rdbAtuaVei.setDisable(true);
            this.rdbConfDev.setDisable(true);

        }

        if (!this.rdbRemoveVei.isSelected()) {
            this.rdbVeriReser.setDisable(false);
            this.rdbCadasVei.setDisable(false);
            this.rdbAtuaVei.setDisable(false);
            this.rdbConfDev.setDisable(false);
        }
    }
}
