/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class ConfirmaController implements Initializable {

    @FXML
    private Label lblDtIni;

    @FXML
    private Label lblDtFim;

    @FXML
    private Label lblDias;

    private static Long idUsuario;
    private static Long idVeiculo;
    private static int qtdDias;
    private static String dataInicio;
    private static String dataFim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           this.getValues();
    }
    
    private void getValues() {
        this.lblDtIni.setText(dataInicio);
        this.lblDtFim.setText(dataFim);
        this.lblDias.setText("" + qtdDias);
    }

    public static void setIdUsuario(Long idUsuario) {
        ConfirmaController.idUsuario = idUsuario;

    }

    public static void setIdVeiculo(Long idVeiculo) {
        ConfirmaController.idVeiculo = idVeiculo;
    }

    public static void setQtdDias(int qtdDias) {
        ConfirmaController.qtdDias = qtdDias;
    }

    public static void setDataInicio(String dataInicio) {
        ConfirmaController.dataInicio = dataInicio;
    }

    public static void setDataFim(String dataFim) {
        ConfirmaController.dataFim = dataFim;
    }

}
