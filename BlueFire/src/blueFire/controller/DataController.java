/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.model.domain.impl.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import blueFire.utils.Utils;
import java.time.LocalDate;
import java.time.Period;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class DataController implements Initializable {

    @FXML
    private Button btnFechar;
    @FXML
    private DatePicker dpInicio;
    @FXML
    private DatePicker dpFim;

    private Utils utils;
    Cliente cliente = new Cliente();

    private static Long idUsuario;
    private static Long idVeiculo;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void continuar() {
        Period periodo = Period.between(this.pegarDataInicio(), this.pegarDataFim());
        int dias = periodo.getDays();

        this.cliente.fazerReserva(DataController.idUsuario, 
                DataController.idVeiculo, dias, this.dpInicio.getValue().toString());
    }

    @FXML
    public LocalDate pegarDataFim() {
        LocalDate dataFim = this.dpFim.getValue();

        return dataFim;
    }

    @FXML
    public LocalDate pegarDataInicio() {
        LocalDate dataInicio = this.dpInicio.getValue();

        return dataInicio;
    }

    @FXML
    public void fechar() {
        utils.fecharJanela(this.btnFechar);
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

}
