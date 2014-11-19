//This class create the group permission object persistence and set the entity factory

package permission;
 
import javax.persistence.*;
import javax.servlet.*;
 
public class UserPermissionListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("user.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/userpermission.odb");
        e.getServletContext().setAttribute("userpermissionemf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("userpermissionemf");
        emf.close();
    }
}