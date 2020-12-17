/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.PrincipalUserController;
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
public class PrincipalAdm extends Application {

    private static Cliente cliente;

    public PrincipalAdm(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/blueFire/view/FXML_PRINCIPAL_ADM.fxml"));

        PrincipalUserController principalUserController = new PrincipalUserController();
        principalUserController.setCliente(this.cliente);

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
