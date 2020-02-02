package main.java.com.softpager.estores.servlets.admin;

import main.java.com.softpager.estores.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;

@WebServlet(name = "CreateUserServlet", urlPatterns = "/admin/create_user")
public class CreateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        var userService = new UserService();
        userService.create(request, response);
        userService.getAll(request, response,"new created successfully");
    }
}
