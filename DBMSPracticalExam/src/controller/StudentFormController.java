package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public TableView<StudentTM> tblStudent;
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
        loadAllStudent();
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSave.setText(newValue != null ? "Update" : "Save");
            if (newValue!= null){
                txtStudentId.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtEmail.setText(newValue.getEmail());
                txtNIC.setText(newValue.getNic());
                txtContact.setText(newValue.getContact());
            }else {
                clearText();
            }
        });

    }

    private void clearText() {
        txtStudentId.clear();
        txtName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtNIC.clear();
        txtContact.clear();
    }

    private void loadAllStudent() {
        tblStudent.getItems().clear();
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
        String id = txtStudentId.getText();
        try {
            boolean b = studentCRUDController.deleteStudent(id);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
            }
            clearText();
            loadAllStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Student student = new Student(txtStudentId.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNIC.getText());
        try {

            if (btnSave.getText().equals("Save")){
                boolean save = studentCRUDController.saveStudent(student);
                if (save){
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
                }
                loadAllStudent();
            }else{
                boolean update = studentCRUDController.updateStudent(student);
                if (update){
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }
                loadAllStudent();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
