/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.Confirma;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Veiculo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import blueFire.utils.Utils;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

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
    
    private static Cliente cliente;
    private static Veiculo veiculo;

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
    public void continuar() throws Exception {
        Period periodo = Period.between(this.pegarDataInicio(), this.pegarDataFim());
        int dias = periodo.getDays();
        this.abrirTelaDeConfirmacao(dias);
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static Veiculo getVeiculo() {
        return veiculo;
    }
    
  
    private void abrirTelaDeConfirmacao(int dias) throws Exception {

        
        LocalDate dI = this.dpInicio.getValue();
        Date dataInicio = Date.valueOf(dI);
        
        LocalDate dF = this.dpFim.getValue();
        Date dataFim = Date.valueOf(dF);
        
        System.out.println("Data Inicio: " + dataInicio);
        System.out.print("É do tipo Date? ");
        System.out.println(dataInicio instanceof Date);
        
        System.out.println("Data Fim: " + dataFim);
        System.out.print("É do tipo Date? ");
        System.out.println(dataFim instanceof Date);


        Confirma confirma = new Confirma(this.getCliente(), this.getVeiculo(), dias, dataInicio, dataFim);

        confirma.start(new Stage());

    }
}
