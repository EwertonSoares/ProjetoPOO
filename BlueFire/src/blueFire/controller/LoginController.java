/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueFire.controller;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import blueFire.model.domain.UsuarioLogado;
import blueFire.utils.Utils;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CIANDT\ewerton
 */
public class LoginController implements Initializable {

    Utils utils = new Utils();
    LoginFacade facade = new LoginFacade();

    private Long idUsuario;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Hyperlink linkCadastrar;

    @FXML
    private Hyperlink linkEsqueceu;

    @FXML
    private Button btnFechar;

    @FXML
    private RadioButton rbdAdm;

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
            UsuarioLogado usuario = UsuarioLogadoFactory.criar(this.txtEmail.getText(),
                    this.txtSenha.getText(), this.rbdAdm.isSelected());

            facade.logar(usuario);
            if (usuario instanceof Cliente) {

                PrincipalUser telaPrincipalDeUsuario = new PrincipalUser(this.pegarIdUsuario());
                telaPrincipalDeUsuario.start(new Stage());

            } else if (usuario instanceof Administrador) {
                //TODO redirecionar tela Administrador
            }

        } catch (Exception ex) {

            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Long pegarIdUsuario() {
        UtilsDAO utilsDAO = new UtilsDAO();
        Long id = utilsDAO.pegarIdUsuario(this.txtEmail.getText());
        return id;
    }

    @FXML
    private void fechar() {
        utils.fecharJanela(this.btnFechar);
    }

}
