/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

import blueFire.PrincipalAdm;
import blueFire.PrincipalUser;
import blueFire.facade.LoginFacade;
import blueFire.factories.UsuarioLogadoFactory;
import blueFire.model.dao.UtilsDAO;
import blueFire.model.domain.impl.Administrador;
import blueFire.model.domain.impl.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import blueFire.model.domain.UsuarioLogado;
import blueFire.utils.Utils;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class LoginController implements Initializable {

    Utils utils = new Utils();
    LoginFacade facade = new LoginFacade();

    private Cliente cliente;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnFechar;

    @FXML
    private Hyperlink linkCadastrar;

    @FXML
    private Hyperlink linkEsqueceu;

    @FXML
    private Label erroText;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void logar() {
        try {
            UsuarioLogado usuario = UsuarioLogadoFactory
                    .criar(this.txtEmail.getText(), this.txtSenha.getText());

            boolean check = tratarErro(facade.logar(usuario));

            if (!check) {
                return;
            }

            if (usuario instanceof Cliente) {

                PrincipalUser telaPrincipalDeUsuario = new PrincipalUser(this.pegarInfoUsuario());
                telaPrincipalDeUsuario.start(new Stage());

            } else if (usuario instanceof Administrador) {
                PrincipalAdm telaPrincipalAdm = new PrincipalAdm(this.pegarInfoUsuario());
                telaPrincipalAdm.start(new Stage());
            }

        } catch (Exception ex) {

            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente pegarInfoUsuario() {
        UtilsDAO utilsDAO = new UtilsDAO();
        cliente = utilsDAO.buscaCliente(this.txtEmail.getText());
        return cliente;
    }

    private boolean tratarErro(boolean logar) {
        if (!logar) {
            erroText.setVisible(true);
            return false;
        }

        return true;
    }

    @FXML
    private void fechar() {
        utils.fecharJanela(this.btnFechar);
    }

}
