/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.VeiculoReservadoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CIANDT\ewerton
 */
public class VeiculoReservado extends Application {

    private static Long idUsuario;

    public VeiculoReservado(Long idUsuario) {
        VeiculoReservado.idUsuario = idUsuario;
    }

    public VeiculoReservado() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/blueFire/view/FXML_VEICULO_RESERVADO.fxml"));
        Parent root = (Parent) loader.load();
        
        VeiculoReservadoController ListarVeiculosReservadosController = new VeiculoReservadoController();
        ListarVeiculosReservadosController.setarIdUsuario(this.idUsuario);

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
