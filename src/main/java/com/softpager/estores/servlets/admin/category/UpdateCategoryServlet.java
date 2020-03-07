package main.java.com.softpager.estores.servlets.admin.category;

import main.java.com.softpager.estores.services.CategoryService;
import main.java.com.softpager.estores.utils.UrlMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet",
        urlPatterns = UrlMapper.UPDATE_CATEGORY)
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        var categoryService = new CategoryService(request, response);
        categoryService.update();
    }
}
