import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer", "/"})
public class CustomerServlet extends HttpServlet {
    static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://anhdep123.com/wp-content/uploads/2020/05/anh-dai-dien-731x1024.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://cdb.boxhoidap.com/cdbjp/cach-de-anh-dai-dien-dep--af23e966b7b4a6b1fc15c0aaca8cf14d.wepb"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://ephoto360.com/uploads/worigin/2020/05/21/taoanhdaidienfacebookcodautichxanh5ec5f3ddd0c11_1e7656c5bc025b122ec2c77ab62d70c3.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://how-yolo.net/wp-content/uploads/2021/12/3-3.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://hinhgaixinh.com/wp-content/uploads/2022/02/image-gai-xinh-lam-avatar-hoan-hao-nhat.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
