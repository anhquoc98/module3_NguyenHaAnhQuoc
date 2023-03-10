import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCustomer", value = "/customer")
public class ServletCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Anh Quốc", "10/11/1998", "đà nẵng", "https://thuthuatnhanh.com/wp-content/uploads/2018/07/anh-dai-dien-dep.jpg"));
        customerList.add(new Customer("Văn Chính", "10/11/1998", "Quảng trị", "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg"));
        customerList.add(new Customer("Như Quỳnh", "10/11/1998", "Hà Nội", "https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2022/04/Anh-avatar-dep-anh-dai-dien-FB-Tiktok-Zalo.jpg?ssl=1"));
        customerList.add(new Customer("Quốc Anh", "10/11/1998", "Hồ Chí Minh", "https://haycafe.vn/wp-content/uploads/2022/04/Anh-gau-trang.jpg"));
        customerList.add(new Customer("Thuận Kì", "10/11/1998", "Huế", "https://thuthuatnhanh.com/wp-content/uploads/2018/07/anh-dai-dien-dep.jpg"));
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("Customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
