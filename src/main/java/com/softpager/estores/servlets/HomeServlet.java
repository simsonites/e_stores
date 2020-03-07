package main.java.com.softpager.estores.servlets;

import main.java.com.softpager.estores.utils.ServletDispatcher;
import main.java.com.softpager.estores.utils.UrlMapper;
import main.java.com.softpager.estores.utils.ViewMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HomeServlet", urlPatterns= UrlMapper.HOME)
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletDispatcher sd = new ServletDispatcher();
        sd.process(ViewMapper.HOME_PAGE,request,response);
    }
}
