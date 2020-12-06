/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.DadoClienteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CIANDT\ewerton
 */
public class DadoCliente extends Application {

    private static Long idUsuario;

    public DadoCliente(Long idUsuario) {
        DadoCliente.idUsuario = idUsuario;
    }

    public DadoCliente() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        DadoClienteController dadosCliente = new DadoClienteController();
        dadosCliente.setarIdUsuario(this.idUsuario);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/blueFire/view/FXML_DADO_CLIENTE.fxml"));
        Parent root = (Parent) loader.load();

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
