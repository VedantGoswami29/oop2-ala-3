import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Student";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pwd";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insert":
                insertStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "retrieve":
                retrieveStudents(response);
                break;
            default:
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String rollNo = request.getParameter("rollNo");
        String department = request.getParameter("department");
        try {
            Connection connection = getConnection();
            String insertQuery = "INSERT INTO Student (name, roll_no, department) VALUES (?,?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, name);
            insertStatement.setString(2, rollNo);
            insertStatement.setString(3, department);
            int rowsAffected = insertStatement.executeUpdate();
            connection.close();
            PrintWriter out = response.getWriter();
            out.println(rowsAffected + " row(s) inserted.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rollNo = request.getParameter("rollNo");
        String newName = request.getParameter("newName");
        try {
            Connection connection = getConnection();
            String updateQuery = "UPDATE Student SET name = ? WHERE roll_no = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, newName);
            updateStatement.setString(2, rollNo);
            int rowsAffected = updateStatement.executeUpdate();
            connection.close();
            PrintWriter out = response.getWriter();
            out.println(rowsAffected + " row(s) updated.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rollNo = request.getParameter("rollNo");
        try {
            Connection connection = getConnection();
            String deleteQuery = "DELETE FROM Student WHERE roll_no = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, rollNo);
            int rowsAffected = deleteStatement.executeUpdate();
            connection.close();
            PrintWriter out = response.getWriter();
            out.println(rowsAffected + " row(s) deleted.");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    private void retrieveStudents(HttpServletResponse response) throws IOException {
        try {
            Connection connection = getConnection();
            String selectQuery = "SELECT * FROM Student";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            PrintWriter out = response.getWriter();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String rollNo = resultSet.getString("roll_no");
                String department = resultSet.getString("department");
                out.println("Name:" + name + ", Roll No: " + rollNo + ", Department: " + department + "<br>");
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
