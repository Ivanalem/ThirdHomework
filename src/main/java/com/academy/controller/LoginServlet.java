package com.academy.controller;

import com.academy.model.User;
import com.academy.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        AuthService authService = new AuthService();

        if(authService.authenticate(login, password)) {
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>Login Servlet</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("Hello"+ login + " "+ password);
            printWriter.println("</body>");
            printWriter.println("</html>");
            User user = new User(login, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }else {
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>Login Servlet</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h1>Access denied</h1>");
            printWriter.println("</body>");
            printWriter.println("</html>");

        }

        printWriter.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "";

        BufferedReader reader = request.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            data += line;
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Login Servlet</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>Login Post page</h1>");
        printWriter.println(data);
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}


