package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDao {

	private Connection conn;

    public StudentDao(Connection conn) {
        this.conn = conn;
    }

    public List getAllStudents() throws SQLException {
        List students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setRollNo(rs.getString("roll_no"));
            s.setDepartment(rs.getString("department"));
            students.add(s);
        }
        return students;
    }
}
