/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;
 
import research.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;

/**
 *
 * @author aiolos404
 */

 
public class AddResearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("researchemf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle new research attributes  (if any):
            String number = request.getParameter("Number");
            String name = request.getParameter("Name");
            String type = request.getParameter("Type");
            String date = request.getParameter("Date");
            String author = request.getParameter("Author");
            String publisher = request.getParameter("Publisher");
            //Check the attributes and create new research object
            if (number != null && name != null && type != null && date != null && author != null && publisher != null) {
                em.getTransaction().begin();
                em.persist(new Research(number,name,type,date,author,publisher));
                em.getTransaction().commit();
            }
 
            // Display the list of researches:
            List<Research> researchProject =
                em.createQuery("SELECT g FROM Research g", Research.class).getResultList();
            request.setAttribute("researches", researchProject);
//            request.getRequestDispatcher("research/search.jsp").forward(request, response);
            request.getRequestDispatcher("research/addResearch.jsp").forward(request, response);
 
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