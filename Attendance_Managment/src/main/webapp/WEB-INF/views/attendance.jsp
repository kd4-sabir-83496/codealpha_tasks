<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<%
    List<Student> students = (List<Student>) request.getAttribute("student");
%>

<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Roll No</th>
            <th>Department</th>
        </tr>
        <%
            if (students != null) {
                for (Student student : students) {
        %>
        <tr>
            <td><%= student.getName() %></td>
            <td><%= student.getRollNo() %></td>
            <td><%= student.getDepartment() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
