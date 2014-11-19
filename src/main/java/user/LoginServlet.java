package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Get the username and password and check which role should this be.
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username)&&"admin".equals(password)) {
            request.getRequestDispatcher("/admin/adminPanel.jsp").forward(request, response);
        } 
        else {
            request.getRequestDispatcher("/user/index.jsp").forward(request, response);
        }

    }

}
