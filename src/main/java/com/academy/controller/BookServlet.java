package com.academy.controller;

import com.academy.model.Book;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BookServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        BookService bookService = new BookService();
        Book book = bookService.getBookId(id);


        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Book page</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println(book);
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
