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
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.selectAllUsers();

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("id"));

        User user = userService.selectUser(idEdit);

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

        userService.updateUser(book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String country = request.getParameter("country");

        User newUser = new User(name, email, country);

        userService.insertUser(newUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        userService.deleteUser(id);

        response.sendRedirect("/users");
    }

//    Bài tập: 1. Tìm kiếm theo country
    private void findByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nameCountry = request.getParameter("countrySearch");

        List<User> listUser = userService.findByCountry(nameCountry);

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }

//     2. Sắp xếp theo tên
    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> listUser = userService.sortByName();

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        dispatcher.forward(request, response);
    }
}
