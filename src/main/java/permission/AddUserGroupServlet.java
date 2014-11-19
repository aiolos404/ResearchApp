/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permission;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import research.Research;

/**
 *
 * @author aiolos404
 */
public class AddUserGroupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("userpermissionemf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle new attributes of group and permission (if any):
            String group = request.getParameter("group");
            String create = request.getParameter("create");
            String read =request.getParameter("read");
            String update = request.getParameter("update");
            String delete = request.getParameter("delete");

            //Check the attributes and create new group object
            if (group != null && create != null && read != null && update != null && delete != null) {
                em.getTransaction().begin();
                em.persist(new UserPermission(group,create,read,update,delete));
                em.getTransaction().commit();
            }
 
            // Display the list of groups:
            List<UserPermission> userPermission =
                em.createQuery("SELECT g FROM UserPermission g", UserPermission.class).getResultList();
            request.setAttribute("userPermissions", userPermission);
//            request.getRequestDispatcher("research/search.jsp").forward(request, response);
            request.getRequestDispatcher("userpermission/viewUserPermission.jsp").forward(request, response);
 
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