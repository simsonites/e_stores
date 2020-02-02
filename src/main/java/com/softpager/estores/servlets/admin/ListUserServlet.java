package main.java.com.softpager.estores.servlets.admin;

import main.java.com.softpager.estores.services.UserService;
import main.java.com.softpager.estores.utils.Views;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListUserServlet", urlPatterns = "/admin/list_users")
public class ListUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserService();
         userService.getAll(request, response);
    }
}
