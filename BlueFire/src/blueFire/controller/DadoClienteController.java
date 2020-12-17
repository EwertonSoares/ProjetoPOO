/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.model.domain.impl.Cliente;
import blueFire.model.domain.impl.Endereco;
import blueFire.utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    private final Utils utils = new Utils();
    private static Long idUsuario;
    private Cliente cliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cliente novoCliente = new Cliente();
        this.cliente = novoCliente.consultaPerfil(DadoClienteController.idUsuario);

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
        utils.fecharJanela(this.btnVoltar);
    }

    @FXML
    private void salvar() {
        Endereco endereco = new Endereco();

        cliente.setNome(this.txtNome.getText().toLowerCase());
        cliente.setSobrenome(this.txtSobrenome.getText().toLowerCase());
        cliente.setEmail(this.txtEmail.getText().toLowerCase());
        cliente.setTelefone(this.txtTelefone.getText().toLowerCase());
        endereco.setBairro(this.txtBairro.getText().toLowerCase());
        endereco.setRua(this.txtRua.getText().toLowerCase());
        endereco.setNumero(Long.parseLong(this.txtNumero.getText()));
        cliente.setEndereco(endereco);

        Cliente novoCliente = new Cliente();
        boolean atualizado = novoCliente.autualizaDadosCliente(this.cliente);

        if (atualizado) {
            utils.showAlert("Sucesso!", "Dados salvos!!!", "Seus dados foram "
                    + "atualizados com sucesso!!!", Alert.AlertType.INFORMATION);
        } else {
            utils.showAlert("Erro!", "Os dados não\n foram salvos!!!",
                    "Não foi possivel atualizar seu dados!", Alert.AlertType.ERROR);
        }
    }

    public void setarIdUsuario(Long idUsuario) {
        DadoClienteController.idUsuario = idUsuario;
    }

}
