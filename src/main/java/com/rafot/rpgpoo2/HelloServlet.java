package com.rafot.rpgpoo2;

import java.io.*;

import com.rafot.rpgpoo2.dao.UsersDAO;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    UsersDAO dao = new UsersDAO();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + dao.getById(1).getName() + "</h1>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}