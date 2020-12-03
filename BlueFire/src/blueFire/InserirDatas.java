/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire;

import blueFire.controller.DataController;
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

    private static Long idUsuario;
    private static Long idVeiculo;
    

    public InserirDatas(Long idUsuario, Long idVeiculo) {
        this.idUsuario = idUsuario;
        this.idVeiculo = idVeiculo;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/blueFire/view/FXML_INSERIR_DATAS.fxml"));
        
        DataController dataController = new DataController();
        dataController.setIdUsuario(InserirDatas.idUsuario);
        dataController.setIdVeiculo(InserirDatas.idVeiculo);
        
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
