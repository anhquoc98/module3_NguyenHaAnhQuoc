package com.example.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer =response.getWriter();
        response.setContentType("text/html");
        float listPrice =Float.parseFloat(request.getParameter("listPrice"));
        float percent =Float.parseFloat(request.getParameter("percent"));
        float result = (float) (listPrice*percent*0.01);
        writer.println("<html>");
        writer.println("<h1>List Price: " + listPrice + "</h1>");
        writer.println("<h1>Discount Percent: " + percent + "</h1>");
        writer.println("<h1>Discount Amount: " + result + "</h1>");
        writer.println("</html>");
    }

    public void destroy() {
    }
}