package ui;

import database.Repository;
import domain.Course;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class LoginController {
    Scene stage = null;

    @FXML
    private AnchorPane PanStage;


    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    @FXML
    void initialize() {
        txtUsername.setText("1");
        txtPassword.setText("one");
    }
    @FXML
    void btnLogin_click(ActionEvent event) throws IOException {

        Boolean canbeLoggedin = Repository.getInstance().getShopRepository().login(Integer.parseInt(txtUsername.getText()),txtPassword.getText());
        if(canbeLoggedin){
            HelperUI.openNewPane("Menu.fxml",event);
        }
        else{
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "Wrong username / password", "Warning: Wrong login", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setTheStage(Scene scene2) {
        stage = scene2;
    }
}
