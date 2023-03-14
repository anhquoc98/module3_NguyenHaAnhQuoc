package controller;

import model.Product;
import model.service.IProductService;
import model.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerProductServlet", value = "/product")
public class ManagerProductServlet extends HttpServlet {
    IProductService productService = new ProductService();

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
            case "seach":
                seachPage(request, response);
                break;
            default:
                showListPage(request, response);
                break;
        }
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.list();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);

    }

    private void seachPage(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deletePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        dispatcher.forward(request,response);
    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product =this.productService.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("product/update.jsp").forward(request,response);

    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("productId"));
        String nameProduct =request.getParameter("productName");
        String color =request.getParameter("productColor");
        String price =request.getParameter("productPrice");
        productService.add(new Product(id,nameProduct,color,price));
        response.sendRedirect("/product");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "edit":
                showUpdatePage(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
            default:
                showListPage(request, response);
                break;
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/error.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.productService.remove(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Product newProduct ;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String price = request.getParameter("price");
        newProduct = new Product(id, name, color, price);
        productService.update(id, newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/update.jsp");
        dispatcher.forward(request,response);
    }
}
