package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button btnPrintPDF;

    @FXML
    private Button btnEditMaths;

    @FXML
    private Button btnViewStudentDetails;

    @FXML
    private Button btnLogout;

    @FXML
    void btnEditMaths_Click(ActionEvent event) {
        HelperUI.openNewPane("ChangeGrades.fxml", event);
    }

    @FXML
    void btnLogout_Click(ActionEvent event) {

        HelperUI.openNewPane("login.fxml", event);
    }

    @FXML
    void btnPrintPDF_Click(ActionEvent event) {
        HelperUI.openNewPane("DownloadPDF.fxml", event);
    }

    @FXML
    void btnViewStudentDetails_Click(ActionEvent event) {
        HelperUI.openNewPane("Details.fxml", event);

    }

}
