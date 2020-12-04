/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.model.domain.impl.Veiculo;
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
    @FXML
    private Label lblNome;
    @FXML
    private Label lblPlaca;
    @FXML
    private Label lblCor;
    @FXML
    private Label lblAno;
    @FXML
    private Label lblValorDia;
    @FXML
    private Label lblValorTotal;

    private static Long idUsuario;
    private static int qtdDias;
    private static String dataInicio;
    private static String dataFim;
    private static Veiculo veiculo;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lblNome.setText(veiculo.getNome());
        this.lblPlaca.setText(veiculo.getPlaca());
        this.lblCor.setText(veiculo.getCor());
        this.lblAno.setText(veiculo.getAno().toString());
        this.lblDtIni.setText(dataInicio);
        this.lblDtFim.setText(dataFim);
        this.lblDias.setText(String.valueOf(qtdDias));
        this.lblValorDia.setText(String.valueOf(veiculo.getValorLocacao()));
        this.lblValorTotal.setText(String.valueOf(veiculo.getValorLocacao() * qtdDias));
    }

    public static void setIdUsuario(Long idUsuario) {
        ConfirmaController.idUsuario = idUsuario;

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

    public static void setVeiculo(Veiculo veiculo) {
        ConfirmaController.veiculo = veiculo;
    }
    
    

}
