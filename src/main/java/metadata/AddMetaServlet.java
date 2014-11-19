/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadata;
 

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;

/**
 *
 * @author aiolos404
 */

 
public class AddMetaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("metaemf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle new metadata attributes (if any):
            String isbn = request.getParameter("isbn");
            String topic = request.getParameter("topic");
            String content = request.getParameter("content");


            //Check the attributes and create new metadata object
            if (isbn != null && topic != null && content != null) {
                em.getTransaction().begin();
                em.persist(new Meta(isbn,topic,content));
                em.getTransaction().commit();
            }
 
            // Display the list of metadata:
            List<Meta> meta =
                em.createQuery("SELECT g FROM Meta g", Meta.class).getResultList();
            request.setAttribute("metas", meta);
            request.getRequestDispatcher("metadata/viewMetaData.jsp").forward(request, response);
 
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