package research;

import research.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;

public class SearchResearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf
                = (EntityManagerFactory) getServletContext().getAttribute("researchemf");
        EntityManager em = emf.createEntityManager();


        try {
            // Handle new attributes (if any):
            String number = request.getParameter("Number");
            String name = request.getParameter("Name");
            String type = request.getParameter("Type");
            String date = request.getParameter("Date");
            String author = request.getParameter("Author");
            String publisher = request.getParameter("Publisher");

            
            //I use criterial query in jpa, following query equals:
            //select * from Research.class where number = "number" or name = "name" or type = "type" or date = "date" or author = "author" or publisher = "publisher"
            
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Research.class);
            Root<Research> research = cq.from(Research.class);
            cq.select(research);
            cq.where(
                    cb.or(
                            cb.equal(research.get("number"), number),
                            cb.equal(research.get("name"), name),
                            cb.equal(research.get("type"), type),
                            cb.equal(research.get("date"), date),
                            cb.equal(research.get("author"), author),
                            cb.equal(research.get("publisher"), publisher)
                    )
            );
            TypedQuery<Research> q = em.createQuery(cq);
            List<Research> guestList = q.getResultList();
            
            // Display the list of researches:
            request.setAttribute("researches", guestList);

            String nextJSP = "/research/viewSearch.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);


        } finally {
            // Close the PersistenceManager:
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
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
