/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Veiculo;
import blueFire.utils.Utils;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author CIANDT\ewerton
 */
public class HistoricoClienteController implements Initializable {

    @FXML
    private ListView<Veiculo> lvHistorico;
    @FXML
    private Button btnVoltar;

    private ObservableList<Veiculo> oblVeiculos;
    private Cliente cliente;

    public HistoricoClienteController(Cliente cliente) {
        this.cliente = cliente;
    }
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cliente novoCliente = new Cliente.Builder().buid();
        List<Veiculo> lista = novoCliente.consultarHistoricoReserva(this.cliente.getId()); 

        this.oblVeiculos = FXCollections.observableArrayList(lista);
        this.lvHistorico.setItems(oblVeiculos);
    }

    @FXML
    private void voltar() {
        Utils utils = new Utils();
        utils.fecharJanela(this.btnVoltar);
    }

    public void setCliente(Cliente cliente) {
       this.cliente = cliente;
    }

}
