import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // Admin or User
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
            
            String query = "SELECT * FROM users WHERE username=? AND password=? AND role=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                if ("admin".equals(role)) {
                    response.sendRedirect("admin_dashboard.html");
                } else {
                    response.sendRedirect("user_dashboard.html");
                }
            } else {
                response.sendRedirect("login.html?error=Invalid Credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

// Database Schema (MySQL)
// CREATE DATABASE library;
// USE library;
// CREATE TABLE users (
//     id INT AUTO_INCREMENT PRIMARY KEY,
//     username VARCHAR(50) UNIQUE NOT NULL,
//     password VARCHAR(50) NOT NULL,
//     role ENUM('admin', 'user') NOT NULL
// );

// HTML for login (login.html)
// <form action="LoginServlet" method="post">
//     <input type="text" name="username" placeholder="Username" required>
//     <input type="password" name="password" placeholder="Password" required>
//     <select name="role">
//         <option value="admin">Admin</option>
//         <option value="user">User</option>
//     </select>
//     <button type="submit">Login</button>
// </form>

// CSS for styling (style.css)
// body { font-family: Arial, sans-serif; background: #f4f4f4; text-align: center; }
// form { background: #fff; padding: 20px; margin: auto; width: 300px; border-radius: 5px; }

// Admin Dashboard (admin_dashboard.html)
// <h1>Welcome Admin</h1>
// <a href="manage_books.html">Manage Books</a>
// <a href="logout">Logout</a>

// User Dashboard (user_dashboard.html)
// <h1>Welcome User</h1>
// <a href="view_books.html">View Books</a>
// <a href="logout">Logout</a>
