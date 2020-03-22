package main.java.com.softpager.estores.servlets.admin.user;

import main.java.com.softpager.estores.utils.UrlMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlMapper.CREATE_USER)
public class CreateUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

       /* UserService userService = new UserService(request, response);
         userService.create();*/
      //  PageDispatcher.forwardToPage(ViewMapper.USER_FORM, request, response);
    }
}
