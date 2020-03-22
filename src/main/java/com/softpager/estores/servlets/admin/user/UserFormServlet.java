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

@WebServlet(UrlMapper.USER_FORM)
public class UserFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "Yea, we are here");
        PageDispatcher.forwardToPage(ViewMapper.USER_FORM, request, response);

    }
}
