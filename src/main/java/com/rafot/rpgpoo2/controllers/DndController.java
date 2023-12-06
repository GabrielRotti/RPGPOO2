package com.rafot.rpgpoo2.controllers;

import com.rafot.rpgpoo2.dao.DndCharactersDAO;
import com.rafot.rpgpoo2.models.DndCharacters;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/DnD")
public class DndController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DndCharactersDAO dao = new DndCharactersDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String params = request.getParameter("params");

        if (params == null || params.equals("find-all")) {
            List<DndCharacters> dndCharacters = dao.getAll();

            request.setAttribute("dndCharacters", dndCharacters);

            request.getRequestDispatcher("dndCharacters/index.jsp").forward(request, response);

            return;
        }

        if (params.equals("create")) {
            request.getRequestDispatcher("dndcharacters/create.jsp").forward(request, response);
        }


    }
}
