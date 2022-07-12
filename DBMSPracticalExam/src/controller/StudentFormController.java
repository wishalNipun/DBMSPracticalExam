package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Student;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colNIC;
    public JFXTextField txtContact;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtNIC;
    public JFXButton btnSearch;
    public TextField txtSearch;
    private final StudentCRUDController studentCRUDController = new StudentCRUDController();
    public void initialize(){
        loadAllCustomer();
    }

    private void loadAllCustomer() {

        try {
            ArrayList<Student> allStudent = studentCRUDController.getAllStudent();
            for (Student s:allStudent
                 ) {
                tblStudent.getItems().add(
                        new StudentTM(s.getId(),s.getName(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic())
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
