/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.DataController;
import blueFire.model.domain.impl.Cliente;
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
public class InserirDatas extends Application {

    private static Cliente cliente;
    private static Veiculo veiculo;
    

    public InserirDatas(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/blueFire/view/FXML_INSERIR_DATAS.fxml"));
        
        DataController dataController = new DataController();
        dataController.setCliente(this.cliente);
        dataController.setVeiculo(this.veiculo);
        
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
