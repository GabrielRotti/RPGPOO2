package com.rafot.rpgpoo2.controllers;

import com.rafot.rpgpoo2.dao.RaceDAO;
import com.rafot.rpgpoo2.models.Race;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "raceController", value = "/races")
public class RaceController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    RaceDAO dao = new RaceDAO();

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
        List<Race> races = dao.getAll();

        request.setAttribute("races", races);
        request.getRequestDispatcher("races/index.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("races/create.jsp").forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Race race = new Race();
        race.setName(request.getParameter("name"));
        dao.create(race);

        response.sendRedirect("races");
    }

}
