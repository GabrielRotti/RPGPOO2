package com.rafot.rpgpoo2.controllers;

import com.rafot.rpgpoo2.dao.UsersDAO;
import com.rafot.rpgpoo2.models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "userController", value = "/users")
public class UsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UsersDAO dao = new UsersDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String params = request.getParameter("params");

        if (params == null) {
            findAll(request, response);
            return;
        }

        switch (params) {
            case "create":
                create(request, response);
                break;
            case "insert":
                insert(request, response);
                break;
            default:
                findAll(request, response);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Users> users = dao.getAll();

        request.setAttribute("users", users);
        request.getRequestDispatcher("users/index.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("users/create.jsp").forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Users user = new Users();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        dao.create(user);

        response.sendRedirect("users");
    }
}
