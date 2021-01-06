/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.ConfirmaController;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Veiculo;
import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CIANDT\ewerton
 */
public class Confirma extends Application {

    private final Cliente cliente;
    private final Veiculo veiculo;
    private final Date dataInicio;
    private final Date dataFim;
    private final int qtdDias;

    public Confirma(Cliente cliente, Veiculo veiculo, int dias, Date dataInicio, Date dataFim) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.qtdDias = dias;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConfirmaController confirmaController = new ConfirmaController();
        ConfirmaController.setCliente(this.cliente);
        ConfirmaController.setVeiculo(this.veiculo);
        ConfirmaController.setQtdDias(this.qtdDias);
        ConfirmaController.setDataInicio(this.dataInicio);
        ConfirmaController.setDataFim(this.dataFim);

        Parent root = FXMLLoader.load(getClass().getResource("/blueFire/view/FXML_CONFIRMAR.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
