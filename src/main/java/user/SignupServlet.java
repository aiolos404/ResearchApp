package user;
 
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
 
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("useremf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle new attributes (if any):
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (firstname != null && lastname != null && email != null && username != null && password != null ) {
                em.getTransaction().begin();
                em.persist(new User(firstname,lastname,email,username,password));
                em.getTransaction().commit();
            }
 
            // Display the list of users:
            List<User> user =
                em.createQuery("SELECT g FROM User g", User.class).getResultList();
            request.setAttribute("users", user);
            request.getRequestDispatcher("login/signup.jsp").forward(request, response);
 
        } finally {
            // Close the PersistenceManager:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}