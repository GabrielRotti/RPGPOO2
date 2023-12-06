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

@WebServlet(urlPatterns = "/user")
public class UsersController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UsersDAO dao = new UsersDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String params = request.getParameter("params");

        if (params == null || params.equals("find-all")) {
            List<Users> users = dao.getAll();

            request.setAttribute("users", users);

            request.getRequestDispatcher("webapp/users/index.jsp").forward(request, response);

            return;
        }

        if (params.equals("create")) {
            request.getRequestDispatcher("users/create.jsp").forward(request, response);
        }

        if (params.equals("insert")) {
            Users user = new Users();
            user.setName(request.getParameter("name"));
            dao.create(user);

            response.sendRedirect("users");
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
