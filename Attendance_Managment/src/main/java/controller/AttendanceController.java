package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.Student;
import util.DbUtil;

public class AttendanceController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Connection conn = DbUtil.getConnection();
            StudentDao dao = new StudentDao(conn);
            List<Student> students = dao.getAllStudents();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/views/attendance.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
