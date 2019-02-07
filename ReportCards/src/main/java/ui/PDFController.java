package ui;

import domain.Pdff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PDFController {

    @FXML
    private TextField txtClass;

    @FXML
    private TextField txtSection;

    @FXML
    private Button btnSearch;

    @FXML
    private AnchorPane panPDFPreview;

    @FXML
    private Label lblMessage;

    @FXML
    private Button btnHome;

    @FXML
    void btnSearch_Click(ActionEvent event) {
        Pdff pdf = new Pdff(txtClass.getText(),txtSection.getText());
    }

    @FXML
    void btnHome_Click(ActionEvent event) {
        HelperUI.openNewPane("Menu.fxml",event);
    }
}

