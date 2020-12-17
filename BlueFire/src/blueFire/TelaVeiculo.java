/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.VeiculoController;
import blueFire.model.domain.impl.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CIANDT\ewerton
 */
public class TelaVeiculo extends Application {

    private static Cliente cliente;

    public TelaVeiculo(Cliente cliente) {
        TelaVeiculo.cliente = cliente;
    }

    public TelaVeiculo() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/blueFire/view/FXML_VEICULOS.fxml"));
        Parent root = (Parent) loader.load();
        
        VeiculoController ListarVeiculosController = new VeiculoController();
        ListarVeiculosController.setCliente(this.cliente);

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
