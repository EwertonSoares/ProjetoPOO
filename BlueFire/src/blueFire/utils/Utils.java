/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author CIANDT\ewerton
 */
public class Utils {

    public void fecharJanela(Button botao) {
        Stage stage = (Stage) botao.getScene().getWindow();
        stage.close();
    }

    public void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setResizable(true);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
