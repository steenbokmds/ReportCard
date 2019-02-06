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
    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("r_id"));
    }


    @FXML
    void btnSearch_Click(ActionEvent event) {
        List<Student> students = Repository.getInstance().getShopRepository().getStudentsFromClassSection(Integer.parseInt(btnClass.getText()),txtSection.getText());

        ObservableList<Student> studsObservableList = FXCollections.observableList(students);
        System.out.println(students.size());
        System.out.println(students.get(0).toString());
        table.setItems(studsObservableList);

    }
    @FXML
    void btnHome_Click(ActionEvent event) {

        HelperUI.openNewPane("Menu.fxml",event);
    }
}
