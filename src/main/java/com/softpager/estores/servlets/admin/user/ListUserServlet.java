package main.java.com.softpager.estores.servlets.admin.user;

import main.java.com.softpager.estores.utils.PageDispatcher;
import main.java.com.softpager.estores.utils.UrlMapper;
import main.java.com.softpager.estores.utils.ViewMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlMapper.LIST_USERS)
public class ListUserServlet extends HttpServlet {
    public ListUserServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
    /*UserService userService = new UserService(request, response);
        userService.findAll();*/
       PageDispatcher.forwardToPage(ViewMapper.USERS_LIST,request,response);
    }
}
