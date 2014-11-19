////This class create the research object persistence and set the entity factory

package research;
 
import research.*;
import javax.persistence.*;
import javax.servlet.*;
 
public class ResearchListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("research.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/research.odb");
        e.getServletContext().setAttribute("researchemf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("researchemf");
        emf.close();
    }
}