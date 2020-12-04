/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.InserirDatas;
import blueFire.model.dao.VeiculoDAO;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Veiculo;
import blueFire.utils.Utils;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class VeiculosController implements Initializable {
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    Utils utils = new Utils();
    Cliente cliente;

    private ObservableList<Veiculo> oblVeiculos;

    @FXML
    private Button btnFechar;

    @FXML
    private ListView<Veiculo> lvVeiculos;
    private static Long idUsuario;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Veiculo> lista = this.veiculoDAO.listarVeiculos();

        this.oblVeiculos = FXCollections.observableArrayList(lista);
        this.lvVeiculos.setItems(oblVeiculos);
    }

    @FXML
    public void irParaProximaPagina() throws Exception {
        Veiculo veiculo = (Veiculo) this.lvVeiculos.getSelectionModel().getSelectedItem();
        
        InserirDatas inserirDatas = new InserirDatas(this.idUsuario, veiculo.getId());
        inserirDatas.start(new Stage());
     }
    
    @FXML
    public void fechar() {
        utils.fecharJanela(this.btnFechar);
    }

    public void setarIdUsuario(Long idUsuario) {
        VeiculosController.idUsuario = idUsuario;
    }   
}
