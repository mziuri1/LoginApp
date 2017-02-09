
package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.login(username, password);
            PrintWriter printWriter = response.getWriter();
            if (user == null) {
                printWriter.append("არასწორი სახელი ან პაროლი");
            } else {
                printWriter.append("ეგაა");
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
