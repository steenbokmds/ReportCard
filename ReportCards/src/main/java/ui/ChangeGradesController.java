package ui;

import database.Repository;
import domain.Grades;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChangeGradesController {

    @FXML
    private TextField btnClass;

    @FXML
    private TextField txtSection;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnHome;

    @FXML
    private TableColumn<Integer, Integer> colStudID;

    @FXML
    private TableColumn<Integer, Integer> colNumber;

    @FXML
    private TableColumn<String, String> colName;

    @FXML
    private TableColumn<String, String> colSubject;

    @FXML
    private TableColumn<String, String> colMarks;

    @FXML
    private TableColumn<Integer, Integer> colSubid;

    @FXML
    private TableView<Grades> table;

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("r_id"));
        colMarks.setCellValueFactory(new PropertyValueFactory<String, String>("grades"));
        colSubject.setCellValueFactory(new PropertyValueFactory<String, String>("subjectName"));
        colSubid.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("subid"));
        colStudID.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("stud_id"));



    }


    @FXML
    void btnSearch_Click(ActionEvent event) {
        //need to add teacher
        List<Grades> students = Repository.getInstance().getShopRepository().getStudentsFromClassSection(Integer.parseInt(btnClass.getText()), txtSection.getText());
        ObservableList<Grades> studsObservableList = FXCollections.observableList(students);
        System.out.println(studsObservableList.size());

        if (students.size() == 0) {
            JOptionPane.showMessageDialog(null, "No students in class / section", "Info: no students in class / section", JOptionPane.INFORMATION_MESSAGE);

        } else {
            table.setItems(studsObservableList);
            colMarks.setCellFactory(TextFieldTableCell.forTableColumn());
        }

    }

    @FXML
    void btnHome_Click(ActionEvent event) {
        HelperUI.openNewPane("Menu.fxml", event);
    }


    @FXML
    void btnUpdate_Click(ActionEvent event) {
        List<Integer> id = new ArrayList<>();
        List<Integer> subid = new ArrayList<>();
        List<String> grades = new ArrayList<>();
        int j = 0;
        for (Grades item : table.getItems()) {
            grades.add(colMarks.getCellObservableValue(j).getValue());
            System.out.println("value of cell: " + item.getGrades());
            System.out.println(grades.toString());
            System.out.println(item.getName() + " " + item.getStud_id() + " " + item.getSubid());
            id.add(item.getStud_id());
            subid.add(item.getSubid());

//            colMarks.setOnEditCommit((TableColumn.CellEditEvent<Map<String, String>, String> t) -> {
//                ((Map<String, String>) t.getTableView().getItems().get(t.getTablePosition().getRow())).put(Column1MapKey, t.getNewValue());
//            });


            j++;
        }
        for (int i = 0; i < grades.size(); i++) {
            System.out.println(id.get(i) + " " + subid.get(i) + " " + grades.get(i));
            Repository.getInstance().getShopRepository().updateGrades(id.get(i), subid.get(i), Integer.parseInt(grades.get(i)));
        }
        btnSearch_Click(new ActionEvent());
    }

//    @FXML
//    void SaveValue(TableColumn.CellEditEvent<String, String> event) {
//        System.out.println("testing");
//        table.getSelectionModel().getSelectedItem().setGrades(event.getNewValue());
//
//    }




    @FXML
    void SaveValue(ActionEvent event) {
        System.out.println("testing");
//        table.getSelectionModel().getSelectedItem().setGrades(event.getNewValue());
//
    }


    @FXML
    void EditStart(ActionEvent event) {
        System.out.println("testing12345");
    }
}
