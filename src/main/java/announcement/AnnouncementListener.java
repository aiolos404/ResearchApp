//This class create the announcement object persistence and set the entity factory
package announcement;
 

import javax.persistence.*;
import javax.servlet.*;
 
public class AnnouncementListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("announcement.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/announcement.odb");
        e.getServletContext().setAttribute("announcementemf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("announcementemf");
        emf.close();
    }
}