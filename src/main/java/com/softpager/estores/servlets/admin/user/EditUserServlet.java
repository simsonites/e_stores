package main.java.com.softpager.estores.servlets.admin.user;

import main.java.com.softpager.estores.services.UserService;
import main.java.com.softpager.estores.utils.UrlMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", urlPatterns = UrlMapping.EDIT_USER)
public class EditUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        var userService = new UserService(request, response);
        userService.editUser();

    }
}
