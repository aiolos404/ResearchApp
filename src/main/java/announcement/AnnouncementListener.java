package announcement;
 

import javax.persistence.*;
import javax.servlet.*;
 
public class AnnouncementListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("announcement.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/announcement.odb");
        e.getServletContext().setAttribute("emf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
}