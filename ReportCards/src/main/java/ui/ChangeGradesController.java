package ui;

import database.Repository;
import domain.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.swing.*;
import java.util.List;

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
    private TableColumn<Integer, Integer> colNumber;

    @FXML
    private TableColumn<String, String> colName;

    @FXML
    private TableView<Student> table;

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("r_id"));
    }


    @FXML
    void btnSearch_Click(ActionEvent event) {
        //need to add teacher
        List<Student> students = Repository.getInstance().getShopRepository().getStudentsFromClassSection(Integer.parseInt(btnClass.getText()), txtSection.getText());
        ObservableList<Student> studsObservableList = FXCollections.observableList(students);
        if (students.size() == 0) {
            JOptionPane.showMessageDialog(null, "No students in class / section", "Info: no students in class / section", JOptionPane.INFORMATION_MESSAGE);

        } else {
            table.setItems(studsObservableList);
            colName.setCellFactory(TextFieldTableCell.forTableColumn());
        }

    }

    @FXML
    void btnHome_Click(ActionEvent event) {
        HelperUI.openNewPane("Menu.fxml", event);
    }
}
