package main.java.com.softpager.estores.servlets.admin;

import main.java.com.softpager.estores.services.UserService;
import main.java.com.softpager.estores.utils.UrlMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet",
              urlPatterns = UrlMapping.UPDATE_USER)
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        var userService = new UserService(request, response);
        userService.updateUser();
    }

}
