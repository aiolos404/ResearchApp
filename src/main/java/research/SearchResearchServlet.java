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
                = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Research> cq = cb.createQuery(Research.class);
//        Root<Research> Research = cq.from(Research.class);
//        cq.select(Research);
//        TypedQuery<Research> q = em.createQuery(cq);
//        List<Research> allPets = q.getResultList();
        try {
            // Handle a new guest (if any):
            String number = request.getParameter("Number");
            String name = request.getParameter("Name");
            String type = request.getParameter("Type");
            String date = request.getParameter("Date");
            String author = request.getParameter("Author");
            String publisher = request.getParameter("Publisher");

            
            
            
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Research.class);
            Root<Research> research = cq.from(Research.class);
            cq.select(research);
//            ParameterExpression<String> p = cb.parameter(String.class);
//            ParameterExpression<String> a = cb.parameter(String.class);


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
            // Display the list of guests:
//            List<Research> guestList = em.createQuery("select g from Search g where name='" + name + "' order by name", Research.class).getResultList();
//            List<Research> guestList = em.createQuery("select g from Search g where name='" + name + "' or number='" + number + "' or type='" + type + "' or author='" + author + "' or date='" + date + "'or publisher='" + publisher+ "' order by name", Research.class).getResultList();
            request.setAttribute("researches", guestList);
//            request.getRequestDispatcher("research/searchResearch.jsp").forward(request, response);
            String nextJSP = "/research/viewSearch.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
//            request.getRequestDispatcher("research/addResearch.jsp").forward(request, response);
//            SELECT c FROM Country WHERE c.population > :p AND c.area < :a
//            CriteriaQuery temp = em.createQuery(Research.class);
//            Root<Research> c = temp.from(Research.class);
//            temp.select(c);
//            ParameterExpression<Integer> p = temp.parameter(Integer.class);
//            ParameterExpression<Integer> a = temp.parameter(Integer.class);
//            temp.where(
//                    em.gt(c.get("population"), p),
//                    em.lt(c.get("area"), a)
//            );

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
