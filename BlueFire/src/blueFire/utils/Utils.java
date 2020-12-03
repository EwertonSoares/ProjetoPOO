/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.utils;

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

    public void recarregarJanela(Button botao) {
        Stage stage = (Stage) botao.getScene().getWindow();
        stage.close();
    }
}
