package controller;

import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCRUDController {
    public ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        ArrayList <Student> students = new ArrayList<>();
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM Student");
        while (result.next()){
            students.add(
                    new Student(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5),
                            result.getString(6)
                    )
            );
        }
        return students;
    }

    public boolean saveStudent (Student s) throws SQLException, ClassNotFoundException {
        boolean b = CrudUtil.executeUpdate("INSERT INTO Student VALUES (?,?,?,?,?,?)",s.getId(),s.getName(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic());
        return b;
    }
}
