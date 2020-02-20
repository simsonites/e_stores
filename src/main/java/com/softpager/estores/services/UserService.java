package main.java.com.softpager.estores.services;


import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;
import main.java.com.softpager.estores.utils.FeedBack;
import main.java.com.softpager.estores.utils.Views;

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

        var userAlreadyExists = usersDao.findByEmail(email);
        if (userAlreadyExists !=null) {
            String message = "A user with email " + email + " already exists";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher(Views.MESSAGE);
            dispatcher.forward(request, response);
        } else {
          var   newUser = new Users(firstName, lastName, email, password);
            usersDao.create(newUser);
            findAll("New user" + FeedBack.CREATE_SUCCESS);
        }
    }

    public void findAll() throws ServletException, IOException {
        findAll(null);
    }

    public void findAll(String message) throws ServletException, IOException {
        var allUsers = usersDao.findAll();
        request.setAttribute("users", allUsers);
        if (message != null) {
            request.setAttribute("message", message);
        }
        String gotoPage = Views.USERS_LIST;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(gotoPage);
        requestDispatcher.forward(request, response);
    }

    public void editUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        var theUser = usersDao.find(userId);
        String gotoPage = Views.USER_FORM;
        if (theUser == null) {
            String errorMessage = "Could not find user with ID : " + userId;
            request.setAttribute("message", errorMessage);
            gotoPage = Views.MESSAGE;
        } else {
            request.setAttribute("user", theUser);
        }
        RequestDispatcher rd = request.getRequestDispatcher(gotoPage);
        rd.forward(request, response);
    }


    public void updateUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

        var userById = usersDao.find(userId);
        var userByEmail = usersDao.findByEmail(email);

        if (userByEmail != null && userByEmail.getUserId()
                != userById.getUserId()) {
            String message = "Could not update because another" +
                    " user with email " + email + " already exist";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher(Views.MESSAGE);
            requestDispatcher.forward(request, response);
        } else {
            var userToUpdate = new Users(userId, firstName, lastName, email, password);
            usersDao.update(userToUpdate);
            String message = "user " + FeedBack.UPDATE_SUCCESS;
            findAll(message);
        }
    }
}