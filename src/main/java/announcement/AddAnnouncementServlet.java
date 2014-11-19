/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package announcement;

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
public class AddAnnouncementServlet extends HttpServlet {

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
            // Handle new announcement attributes (if any):
            String publisher = request.getParameter("publisher");
            String content = request.getParameter("content");
            String publish_time = request.getParameter("publish_time");

            //Check the attributes and create new announcement object
            if (publisher != null && content != null && publish_time != null) {
                em.getTransaction().begin();
                em.persist(new Announcement(publisher, content, publish_time));
                em.getTransaction().commit();
            }

            // Display the list of announcements:
            List<Announcement> announcement
                    = em.createQuery("SELECT g FROM Announcement g", Announcement.class).getResultList();
            request.setAttribute("announcements", announcement);
           
            request.getRequestDispatcher("announcement/viewAnnouncements.jsp").forward(request, response);

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
