package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DetailsController {

    @FXML
    private TextField btnName;

    @FXML
    private TextField btnClass;

    @FXML
    private TextField btnRollnumber;

    @FXML
    private TextField btnFathersname;

    @FXML
    private TextField txtContactnumber;

    @FXML
    private TextField btnBloodgroup;

    @FXML
    private TextField btnDisability;

    @FXML
    private TextField btnSection;

    @FXML
    private TextArea txaArea;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtClass;

    @FXML
    private TextField txtSection;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnHome;

    @FXML
    void btnHome(ActionEvent event) {

        HelperUI.openNewPane("Menu.fxml",event);
    }

    @FXML
    void btnSearch_Click(ActionEvent event) {

    }

}
