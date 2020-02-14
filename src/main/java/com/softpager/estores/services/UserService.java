package main.java.com.softpager.estores.services;


import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserService {
    private UsersDao usersDao;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.usersDao = new UsersDao();
    }

    public void create() throws ServletException, IOException {
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

        boolean userAlreadyExists = usersDao.findByEmail(email);
        if (userAlreadyExists) {
            String message = "A user with email " + email + " already exists";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.html");
            dispatcher.forward(request, response);

        } else {
          var   newUser = new Users(firstName, lastName, email, password);
            usersDao.create(newUser);
        }
    }

    public List<Users> findAll(){
        return usersDao.findAll();
    }
}