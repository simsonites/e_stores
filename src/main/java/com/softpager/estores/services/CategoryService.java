package main.java.com.softpager.estores.services;

import main.java.com.softpager.estores.daos.CategoryDAO;
import main.java.com.softpager.estores.entities.Category;
import main.java.com.softpager.estores.utils.FeedBackMessage;
import main.java.com.softpager.estores.utils.PageDispatcher;
import main.java.com.softpager.estores.utils.ViewMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;
    private HttpServletResponse response;
    private HttpServletRequest request;

    public CategoryService(HttpServletRequest request,
                           HttpServletResponse response) {
        this.request = request;
        this.response = response;
        categoryDAO = new CategoryDAO();
    }

    public void listCategories() throws ServletException, IOException {
        listCategories(null);
    }

    public void listCategories(String message) throws ServletException, IOException {
        List<Category> allCategory = categoryDAO.findAll();
        request.setAttribute("categories", allCategory);
        PageDispatcher.forwardToPage(ViewMapper.LIST_CATEGORY, request, response);
    }

    public void create() throws ServletException, IOException {
        String name = request.getParameter("name");
        var existCategory = categoryDAO.findByName(name);
        if (existCategory != null) {
           String message = FeedBackMessage.UNSUCCESSFUL_CREATE + name + " already exists.";
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE, request, response);
        } else {
            var newCategory = new Category(name);
            categoryDAO.create(newCategory);
            String message = "New category " + FeedBackMessage.CREATE_SUCCESS;
            listCategories(message);
        }
    }

    public void editCategory() throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("categoryId"));
        var theCategory = categoryDAO.findById(cId);
        if (theCategory ==null){
            String message = FeedBackMessage.CATEGORY_NOT_FOUND;
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE,request,response);
        }
        request.setAttribute("category", theCategory);
        PageDispatcher.forwardToPage(ViewMapper.CATEGORY_FORM,request,response);
    }

    public void update() throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");

        var categoryById = categoryDAO.findById(cId);
        var categoryByName = categoryDAO.findByName(name);
        if ((categoryById != null) &&
                (categoryByName.getCategoryId() != categoryById.getCategoryId())) {
            String message = FeedBackMessage.UNSUCCESSFUL_UPDATE + name + " already exist";
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE, request, response);
        }else {
            var category = new Category(cId, name);
            categoryDAO.update(category);
            String message = "category "+ FeedBackMessage.UPDATE_SUCCESS;
            listCategories(message);
        }
    }

    public void delete() throws ServletException, IOException {
        int cId = Integer.parseInt(request.getParameter("categoryId"));
        var theCategoryToBeDeleted = categoryDAO.findById(cId);
        if (theCategoryToBeDeleted == null) {
            String message = FeedBackMessage.CATEGORY_NOT_FOUND + cId;
            request.setAttribute("message", message);
            PageDispatcher.forwardToPage(message, ViewMapper.BACKEND_MESSAGE, request, response);
        }else {
            categoryDAO.delete(cId);
            listCategories("category "+ FeedBackMessage.DELETE_SUCCESS);
        }
    }

    public Category findById(Object id) {
        return categoryDAO.findById(id);
    }

    public long count() {
        return categoryDAO.count();
    }

}
