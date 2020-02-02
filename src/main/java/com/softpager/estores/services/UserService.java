package main.java.com.softpager.estores.services;

import main.java.com.softpager.estores.daos.UsersDao;
import main.java.com.softpager.estores.entities.Users;
import main.java.com.softpager.estores.utils.Views;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserService {
    private EntityManagerFactory emf;
    private EntityManager em;
    private UsersDao usersDao;

    public UserService() {
        emf = Persistence.createEntityManagerFactory("EStores");
        em = emf.createEntityManager();
        usersDao = new UsersDao(em);
    }


    public void getAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getAll(request, response, null);
    }

    public void getAll(HttpServletRequest request,
                       HttpServletResponse response, String message)
            throws ServletException, IOException {

        List<Users> allUsers = usersDao.getAll();
        request.setAttribute("users", allUsers);
        if (message != null) {
            request.setAttribute("message", message);
        }

        String requestedPage = Views.USERS_LIST;
        RequestDispatcher dispatcher =request.getRequestDispatcher(requestedPage);
        dispatcher.forward(request, response);
    }


    public Users create(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException{

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        var theUser = new Users(firstName,lastName, email,password);
        return usersDao.create(theUser);
    }


}
