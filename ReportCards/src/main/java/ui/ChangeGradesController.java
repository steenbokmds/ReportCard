package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangeGradesController {

    @FXML
    private TextField btnClass;

    @FXML
    private TextField txtSection;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnHome;


    @FXML
    void btnSearch_Click(ActionEvent event) {

    }
    @FXML
    void btnHome_Click(ActionEvent event) {

        HelperUI.openNewPane("Menu.fxml",event);
    }
}
