package main.java.com.softpager.estores.servlets.admin.user;

import main.java.com.softpager.estores.services.UserService;
import main.java.com.softpager.estores.utils.FeedBack;
import main.java.com.softpager.estores.utils.UrlMapping;
import main.java.com.softpager.estores.utils.Views;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet",
        urlPatterns = UrlMapping.DELETE_USER)
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        var userService  = new UserService(request, response);
        var id = Integer.parseInt(request.getParameter("userId"));
        var theUser = userService.findUser(id);

        if (theUser != null) {
            userService.delete(theUser.getUserId());
            userService.findAll("user "+FeedBack.DELETE_SUCCESS);
        }

        RequestDispatcher rd = request.getRequestDispatcher(Views.MESSAGE);
        request.setAttribute("message", FeedBack.USER_NOT_FOUND + id);
        rd.forward(request, response);
    }
}
