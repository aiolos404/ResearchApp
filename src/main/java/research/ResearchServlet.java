package research;
 
import research.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
 
public class ResearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle a new guest (if any):
            String number = request.getParameter("Number");
            String name = request.getParameter("Name");
            String type = request.getParameter("Type");
            String date = request.getParameter("Date");
            String author = request.getParameter("Author");
            String publisher = request.getParameter("Publisher");
//            String title = request.getParameter("title");
            if (number != null && name != null && type != null && date != null && author != null && publisher != null) {
                em.getTransaction().begin();
                em.persist(new Search(number,name,type,date,author,publisher));
                em.getTransaction().commit();
            }
 
            // Display the list of guests:
            List<Search> guestList =
                em.createQuery("SELECT g FROM Search g", Search.class).getResultList();
            request.setAttribute("researches", guestList);
            request.getRequestDispatcher("research/searchResearch.jsp").forward(request, response);
//            request.getRequestDispatcher("research/addResearch.jsp").forward(request, response);
 
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