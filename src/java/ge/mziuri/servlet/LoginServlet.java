
package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(403);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.login(username, String.valueOf(password.hashCode()));
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            if (user == null) {
                printWriter.append("არასწორი სახელი ან პაროლი");
            } else {
                Cookie[] cookies = request.getCookies();
                int count = 0;
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("countVisits")) {
                            count = Integer.parseInt(cookie.getValue());
                        }
                    }
                }
                count++;
                Cookie cookie = new Cookie("countVisits", String.valueOf(count));
                response.addCookie(cookie);
                printWriter.append("ეს არის " + count + " შემოსვლა");
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
