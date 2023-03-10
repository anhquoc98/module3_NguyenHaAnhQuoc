import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCalcolator", value = "/ServletCalculator")
public class ServletCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        double second =Double.parseDouble(request.getParameter("second"));
        double first =Double.parseDouble(request.getParameter("first"));
        String calcul =request.getParameter("calcul");
        double calcul1= Calculator.calculator(first,second,calcul);
        writer.println("<h1>Result</h1>");
        writer.println();
        writer.println("<html>");
        writer.print("<h3>" +second+"+"+first+"="+ calcul1 + "</h3>");
        writer.println("</html>");

    }
}
