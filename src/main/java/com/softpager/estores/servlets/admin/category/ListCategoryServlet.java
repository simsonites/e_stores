package main.java.com.softpager.estores.servlets.admin.category;

import main.java.com.softpager.estores.services.CategoryService;
import main.java.com.softpager.estores.utils.UrlMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCategoryServlet",
        urlPatterns = UrlMapper.LIST_CATEGORY)
public class ListCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        var categoryService = new CategoryService(request, response);
        categoryService.listCategories();

    }
}
