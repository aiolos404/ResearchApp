//This class create the metadata object persistence and set the entity factory

package metadata;
 

import announcement.*;
import javax.persistence.*;
import javax.servlet.*;
 
public class MetaListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("announcement.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/meta.odb");
        e.getServletContext().setAttribute("metaemf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("metaemf");
        emf.close();
    }
}