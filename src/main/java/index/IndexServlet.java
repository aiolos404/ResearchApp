/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import announcement.Announcement;
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

 
public class IndexServlet extends HttpServlet {
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
            String publisher = request.getParameter("publisher");
            String content = request.getParameter("content");
            String time = request.getParameter("publish_time");
//            String title = request.getParameter("title");
            if (publisher != null && content != null && time != null ) {
                em.getTransaction().begin();
                em.persist(new Announcement(publisher,content,time));
                em.getTransaction().commit();
            }
 
            // Display the list of guests:
            List<Announcement> announcement =
                em.createQuery("SELECT g FROM Announcement g", Announcement.class).getResultList();
            request.setAttribute("announcement", announcement);
//            request.getRequestDispatcher("research/search.jsp").forward(request, response);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
 
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