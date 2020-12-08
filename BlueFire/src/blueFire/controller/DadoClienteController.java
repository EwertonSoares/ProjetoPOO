/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.model.dao.DadoClienteDAO;
import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Endereco;
import blueFire.utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author CIANDT\ewerton
 */
public class DadoClienteController implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtNumero;

    DadoClienteDAO dadosCliente = new DadoClienteDAO();
    private static Long idUsuario;
    private Cliente cliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cliente = this.dadosCliente.carregarDadosCliente(DadoClienteController.idUsuario);

        this.txtNome.setText(cliente.getNome().toUpperCase());
        this.txtSobrenome.setText(cliente.getSobrenome().toUpperCase());
        this.txtEmail.setText(cliente.getEmail().toUpperCase());
        this.txtTelefone.setText(cliente.getTelefone());

        this.txtBairro.setText(cliente.getEndereco().getBairro().toUpperCase());
        this.txtRua.setText(cliente.getEndereco().getRua().toUpperCase());
        this.txtNumero.setText(cliente.getEndereco().getNumero().toString());
    }

    @FXML
    private void voltar() {
        Utils utils = new Utils();
        utils.fecharJanela(this.btnVoltar);
    }

    @FXML
    private void salvar() {
       Endereco endereco = new Endereco();

        cliente.setNome(this.txtNome.getText());
        cliente.setSobrenome(this.txtSobrenome.getText());
        cliente.setEmail(this.txtEmail.getText());
        cliente.setTelefone(this.txtTelefone.getText());
        endereco.setBairro(this.txtBairro.getText());
        endereco.setRua(this.txtRua.getText());
        endereco.setNumero(Long.parseLong(this.txtNumero.getText()));
        cliente.setEndereco(endereco);

        this.dadosCliente.autualizaDadosCliente(this.cliente);
    }

    public void setarIdUsuario(Long idUsuario) {
        DadoClienteController.idUsuario = idUsuario;
    }

}
