package controller;

import model.Users;
import model.service.UsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {
    UsersService usersService = new UsersService();

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
            case "sort":
                sortByName(request, response);
                break;
            default:
                sortByName(request, response);
                break;
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        List<Users> usersList = this.usersService.sortByNameUser();
        request.setAttribute("usersList", usersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("users/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users =this.usersService.selectById(id);
        RequestDispatcher dispatcher =request.getRequestDispatcher("users/update.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void deletePage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = usersService.selectById(id);
        RequestDispatcher dispatcher;
        if (users != null) {
            request.setAttribute("users", users);
            dispatcher = request.getRequestDispatcher("users/delete.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) {
        List<Users> usersList = usersService.list();
        request.setAttribute("usersList", usersList);
        try {
            request.getRequestDispatcher("/users/view.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        usersService.save(new Users(id, name, email, country));
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                UpdatePage(request, response);
                break;
            case "delete":
                deleteUsers(request, response);
                break;
            case "search":
                seachByCountry(request, response);
                break;
            default:
                showListPage(request,response);
        }
    }

    private void UpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Users users = new Users(id,name,email,country);
        RequestDispatcher dispatcher;
        if (users != null) {
            this.usersService.updateUser(id, users);
            request.setAttribute("users", users);
            request.setAttribute("message", "Users Information was updated");
            dispatcher = request.getRequestDispatcher("user/edit.jsp");
            dispatcher.forward(request,response);
        }

    }

    private void seachByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("search");
        List<Users> usersList = this.usersService.searchByCountry(country);
        request.setAttribute("usersList", usersList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("users/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUsers(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = this.usersService.selectById(id);
        RequestDispatcher dispatcher;
        if (users != null) {
            this.usersService.deleteUser(id, users);
            try {
                response.sendRedirect("/users");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
