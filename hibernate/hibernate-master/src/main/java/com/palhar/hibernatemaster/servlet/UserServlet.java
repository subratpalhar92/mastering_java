package com.palhar.hibernatemaster.servlet;

import com.palhar.hibernatemaster.entity.User;
import com.palhar.hibernatemaster.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/** Use @WebServlet annotation for automatic mapping (Servlet 3.0 feature) */
@WebServlet("/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Hibernate User Demo</title></head><body>");
        out.println("<h1>Hibernate User Operations</h1>");

        String action = request.getParameter("action");

        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            if ("add".equals(action)) {
                // Add a new user
                User newUser = new User("John Doe", "john.doe@example.com");
                session.save(newUser); // Save the new user
                out.println("<p style='color:green;'>Added new user: " + newUser.getName() + "</p>");
            } else if ("list".equals(action) || action == null) {
                // List all users
                List<User> users = session.createQuery("FROM User", User.class).list(); // HQL query
                out.println("<h2>Current Users:</h2>");
                if (users.isEmpty()) {
                    out.println("<p>No users found. <a href='users?action=add'>Add a user</a></p>");
                } else {
                    out.println("<table border='1'>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
                    for (User user : users) {
                        out.println("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getEmail() + "</td></tr>");
                    }
                    out.println("</table>");
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ServletException("Hibernate operation failed: " + e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        out.println("<p><a href='users?action=add'>Click to add another user</a></p>");
        out.println("<p><a href='users?action=list'>Click to list all users</a></p>");
        out.println("<p><a href='index.html'>Back to Home</a></p>");
        out.println("</body></html>");
    }
}

