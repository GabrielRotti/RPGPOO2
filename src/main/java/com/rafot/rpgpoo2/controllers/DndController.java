package com.rafot.rpgpoo2.controllers;

import com.rafot.rpgpoo2.dao.DndCharactersDAO;
import com.rafot.rpgpoo2.dao.RaceDAO;
import com.rafot.rpgpoo2.dao.UsersDAO;
import com.rafot.rpgpoo2.models.DndCharacters;
import com.rafot.rpgpoo2.models.Race;
import com.rafot.rpgpoo2.models.Users;
import com.rafot.rpgpoo2.utils.CharacterTitleGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "characterController", value = "/characters")
public class DndController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DndCharactersDAO characterDAO = new DndCharactersDAO();
    UsersDAO userDAO = new UsersDAO();
    RaceDAO raceDAO = new RaceDAO();

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
            case "delete":
                delete(request, response);
                break;
            case "erase":
                erase(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                findAll(request, response);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<DndCharacters> characters = characterDAO.getAll();

        request.setAttribute("characters", characters);
        request.getRequestDispatcher("characters/index.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Users> users = userDAO.getAll();
        List<Race> races = raceDAO.getAll();

        request.setAttribute("users", users);
        request.setAttribute("races", races);
        request.getRequestDispatcher("characters/create.jsp").forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        characterDAO.create(characterDAO.createEntityFromRequest(request));
        response.sendRedirect("characters");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DndCharacters character = characterDAO.getById(Integer.parseInt(request.getParameter("character_id")));
        if (character == null) {
            response.sendRedirect("characters");
            return;
        }

        request.setAttribute("character", character);
        request.getRequestDispatcher("characters/delete.jsp").forward(request, response);
    }

    private void erase(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DndCharacters character = characterDAO.getById(Integer.parseInt(request.getParameter("character_id")));
        if (character != null) characterDAO.delete(character);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DndCharacters character = characterDAO.getById(Integer.parseInt(request.getParameter("character_id")));
        if (character == null) {
            response.sendRedirect("characters");
            return;
        }

        List<Users> users = userDAO.getAll();
        List<Race> races = raceDAO.getAll();

        request.setAttribute("users", users);
        request.setAttribute("races", races);
        request.setAttribute("character", character);
        request.getRequestDispatcher("characters/edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DndCharacters character = characterDAO.getById(Integer.parseInt(request.getParameter("character_id")));
        if (character == null) {
            response.sendRedirect("characters");
            return;
        }

        characterDAO.update(characterDAO.createEntityFromRequest(request));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
