package ui;

import domain.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.List;

public class DetailsController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtClassR;

    @FXML
    private TextField txtRollnumber;

    @FXML
    private TextField txtFathersname;

    @FXML
    private TextField txtContactnumber;

    @FXML
    private TextField txtBloodgroup;

    @FXML
    private TextField txtDisability;

    @FXML
    private TextField txtSectionR;

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
    private Button btnUpdate;

    @FXML
    private Button btnHome;

    @FXML
    void initialize() {

//
//        txtName = new TextField();
//        txtClassR = new TextField();
//        txtSectionR = new TextField();
//        txtRollnumber = new TextField();
//        txtFathersname = new TextField();
//        txtContactnumber = new TextField();
//        txaArea = new TextArea();
//        txtBloodgroup = new TextField();
//        txtDisability = new TextField();
    }

    Student st = null;

    @FXML
    void btnHome(ActionEvent event) {

        HelperUI.openNewPane("Menu.fxml",event);
    }

    @FXML
    void btnSearch_Click(ActionEvent event) {
//        FXMLLoader loader = new FXMLLoader();
//        DetailsController controller = (DetailsController) loader.getController();
//        controller.setTheStage(btnSearch.getScene());

        int id = Integer.parseInt(txtID.getText());
        int myClass = Integer.parseInt(txtClass.getText());
        String section = txtSection.getText();
        st = database.Repository.getInstance().getShopRepository().searchStudent(id,myClass,section);
        if(st!=null){
            System.out.println(st.getName());
            System.out.println(st.toString());
            txtContactnumber.setText(st.getContactnumber());
            txtName.setText(st.getName());
            txtClassR.setText(""+st.getC_id());
            txtSectionR.setText(st.getSection());
            txtRollnumber.setText(""+st.getR_id());
            txtFathersname.setText(st.getFathersname());
            txaArea.setText(st.getAddress());
            txtBloodgroup.setText(st.getBloodgroup());
            txtDisability.setText(st.getDisability());
        }
        else{
            JOptionPane.showMessageDialog(null, "No student found", "Warning: no student found", JOptionPane.WARNING_MESSAGE);
        }
    }
    @FXML
    void btnUpdate_Click(ActionEvent event) {
        st.setName(txtName.getText());
        st.setC_id(Integer.parseInt(txtClassR.getText()));
        st.setSection(txtSectionR.getText());
        st.setR_id(Integer.parseInt(txtRollnumber.getText()));
        st.setFathersname(txtFathersname.getText());
        st.setContactnumber(txtContactnumber.getText());
        st.setAddress(txaArea.getText());
        st.setBloodgroup(txtBloodgroup.getText());
        st.setDisability(txtDisability.getText());

        database.Repository.getInstance().getShopRepository().updateStudent(st);
    }
}
