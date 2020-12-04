/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.ConfirmaController;
import blueFire.model.domain.impl.Veiculo;
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

    private final Long idUsuario;
    private final String dataInicio;
    private final int qtdDias;
    private final String dataFim;
    private final Veiculo veiculo;

    public Confirma(Long idUsuario, Veiculo veiculo, int dias, String dataInicio, String dataFim) {
        this.idUsuario = idUsuario;
        this.veiculo = veiculo;
        this.qtdDias = dias;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public void start(Stage stage) throws Exception {
        ConfirmaController confirmaController = new ConfirmaController();
        confirmaController.setIdUsuario(this.idUsuario);
        confirmaController.setVeiculo(this.veiculo);
        confirmaController.setQtdDias(this.qtdDias);
        confirmaController.setDataInicio(this.dataInicio);
        confirmaController.setDataFim(this.dataFim);

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
