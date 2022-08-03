package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    findByCountry(request, response);
                    break;
                case "sort":
                    sortByName(request, response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":
                    testUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        List<User> listUser = userService.selectAllUsers();

//    [Bài tập_ss13] Gọi MySql Stored Procedures từ JDBC
        //    1. Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
        List<User> listUser = userService.selectAllUserStore();

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idEdit = Integer.parseInt(request.getParameter("id"));

//        User user = userService.selectUser(idEdit);

        User user = userService.getUserByIdStore(idEdit);

        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        //   userService.updateUser(book);

        //    [Bài tập_ss13] Gọi MySql Stored Procedures từ JDBC
        //    2.Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
        userService.updateUserStore(book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String country = request.getParameter("country");

        User newUser = new User(name, email, country);

//        userService.insertUser(newUser);
        userService.insertUserStore(newUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

       //  userService.deleteUser(id);

        //    [Bài tập_ss13] Gọi MySql Stored Procedures từ JDBC
        //    3. Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
        userService.deleteUserByIdStore(id);

        response.sendRedirect("/users");
    }

//    [Bài tập_ss12] 1: Cập nhật ứng dụng quản lý User
    private void findByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nameCountry = request.getParameter("countrySearch");

        List<User> listUser = userService.findByCountry(nameCountry);

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

//  [Bài tập_ss12] 2. Sắp xếp theo tên
    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> listUser = userService.sortByName();

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

//    [Thực hành_ss13] MySql JDBC Transaction
    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = new User("hung", "hung.nguyen@codegym.com", "Viet Nam");
        int[] permision = {1, 2, 4};
        userService.addUserTransaction(user, permision);
    }

//    [Thực hành_ss13] Thực thi SQL không sử dụng Transaction
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        userService.insertUpdateWithoutTransaction();
    }

//    [Thực hành_ss13] Thực thi SQL có sử dụng Transaction
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        userService.insertUpdateUseTransaction();
    }
}
