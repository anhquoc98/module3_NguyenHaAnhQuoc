package controller;

import model.Model;
import model.service.ModelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletModel", value = "/model")
public class ServletModel extends HttpServlet {
    ModelService modelService= new ModelService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showCreatePage(request, response);
                break;
            case "update":
                showUpdatePage(request, response);
                break;
            case "delete":
                deletePage(request, response);
                break;
            default:
                showListPage(request, response);
                break;
        }
    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deletePage(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) {
        List<Model> modelList = modelService.list();
        request.setAttribute("modelList", modelList);
        try {
            request.getRequestDispatcher("/model/view.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
