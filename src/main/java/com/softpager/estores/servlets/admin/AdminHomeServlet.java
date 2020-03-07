package main.java.com.softpager.estores.servlets.admin;

import main.java.com.softpager.estores.utils.PageDispatcher;
import main.java.com.softpager.estores.utils.UrlMapper;
import main.java.com.softpager.estores.utils.ViewMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlMapper.ADMIN_HOME)
public class AdminHomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
       PageDispatcher.forwardToPage(ViewMapper.ADMIN_HOME_PAGE, request, response);
    }
}
