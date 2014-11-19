//This class create the user object persistence and set the entity factory

package user;
 
import javax.persistence.*;
import javax.servlet.*;
 
public class UserListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("user.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/user.odb");
        e.getServletContext().setAttribute("useremf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("useremf");
        emf.close();
    }
}