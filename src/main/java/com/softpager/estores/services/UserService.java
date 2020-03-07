package main.java.com.softpager.estores.services;


import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;
import main.java.com.softpager.estores.utils.FeedBackMessage;
import main.java.com.softpager.estores.utils.PageDispatcher;
import main.java.com.softpager.estores.utils.ViewMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserService {
    private UsersDao usersDao;
    private HttpServletRequest request;
    private HttpServletResponse response;

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.usersDao = new UsersDao();
    }

    public void create() throws ServletException, IOException {
        this.getUserAttributes();
        var userAlreadyExists = usersDao.findByEmail(email);
        if (userAlreadyExists != null) {
            String message = FeedBackMessage.UNSUCCESSFUL_CREATE + email + " already exists";
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE, request, response);
        } else {
            var newUser = new Users(firstName, lastName, email, password);
            usersDao.create(newUser);
            findAll("New user" + FeedBackMessage.CREATE_SUCCESS);
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
            PageDispatcher.forwardToPage(message, ViewMapper.USERS_LIST, request, response);
        }
    }

    public void editUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        var theUser = usersDao.findById(userId);
        if (theUser == null) {
            String errorMessage = FeedBackMessage.USER_NOT_FOUND + userId;
            request.setAttribute("message", errorMessage);
            PageDispatcher.forwardToPage(errorMessage, ViewMapper.BACKEND_MESSAGE, request, response);
        } else {
            request.setAttribute("user", theUser);
            PageDispatcher.forwardToPage(ViewMapper.USER_FORM, request, response);
        }
    }

    public void updateUser() throws ServletException, IOException {
        this.getUserAttributes();
        /******* CHECK TO ENSURE THAT THE EMAIL PROVIDED FOR THE UPDATE
         * IS UNIQUE ******/
        var userById = usersDao.findById(userId);
        var userByEmail = usersDao.findByEmail(email);
        if ((userByEmail != null) && (userByEmail.getUserId() != userById.getUserId())) {
            String message = FeedBackMessage.UNSUCCESSFUL_UPDATE + email + " already exist";
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE, request, response);
        }
        /***** CONTINUE WITH THE UPDATE******/
        else {
            var userToUpdate = new Users(userId, firstName, lastName, email, password);
            usersDao.update(userToUpdate);
            String message = "user " + FeedBackMessage.UPDATE_SUCCESS;
            findAll(message);
        }
    }

    public void delete() throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("userId"));
        var theUser = usersDao.findById(id);
        if (theUser == null) {
            String message = FeedBackMessage.USER_NOT_FOUND + id;
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE, request, response);
        }else {
            usersDao.delete(theUser.getUserId());
           findAll("user "+ FeedBackMessage.DELETE_SUCCESS);
        }
    }

    public Users findUser(int id) {
        return usersDao.findById(id);
    }

    private void getUserAttributes() {
        this.userId = Integer.parseInt(request.getParameter("userId"));
        this.firstName = request.getParameter("firstName").trim();
        this.lastName = request.getParameter("lastName").trim();
        this.email = request.getParameter("email").trim();
        this.password = request.getParameter("password").trim();
    }
}