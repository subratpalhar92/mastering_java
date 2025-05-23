package com.palhar.hibernatemaster.servlet;

import com.palhar.hibernatemaster.entity.User;
import com.palhar.hibernatemaster.dao.UserDao; // Import the new DAO

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/usersDAO")
public class UserServletDao extends HttpServlet {

    // Instantiate the DAO (in a real app, you might use dependency injection)
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Hibernate User Demo</title></head><body>");
        out.println("<h1>Hibernate User Operations</h1>");

        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                // Delegate to DAO
                User newUser = new User("John Doe (DAO)", "john.doe@example.com (DAO)");
                userDao.saveUser(newUser);
                out.println("<p style='color:green;'>Added new user: " + newUser.getName() + "</p>");
            } else if ("list".equals(action) || action == null) {
                // Delegate to DAO
                List<User> users = userDao.getAllUsers();
                out.println("<h2>Current Users:</h2>");
                if (users.isEmpty()) {
                    out.println("<p>No users found. <a href='usersDAO?action=add'>Add a user</a></p>");
                } else {
                    out.println("<table border='1'>");
                    out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
                    for (User user : users) {
                        out.println("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getEmail() + "</td></tr>");
                    }
                    out.println("</table>");
                }
            }
        } catch (RuntimeException e) { // Catch the RuntimeException thrown by the DAO
            throw new ServletException("Operation failed: " + e.getMessage(), e);
        }

        out.println("<p><a href='usersDAO?action=add'>Click to add another user</a></p>");
        out.println("<p><a href='usersDAO?action=list'>Click to list all users</a></p>");
        out.println("<p><a href='index.html'>Back to Home</a></p>");
        out.println("</body></html>");
    }
}
