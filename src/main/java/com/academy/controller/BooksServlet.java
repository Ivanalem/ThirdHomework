package com.academy.controller;

import com.academy.model.Book;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        BookService bookService = new BookService();

        List<Book> bookList = bookService.getBookList();

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Books page</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");

        for (Book book : bookList) {
            printWriter.println(book.getTitle() + " <br>");
        }
        printWriter.println("Book1 <br>");
        printWriter.println("Book2 <br>");
        printWriter.println("Book3 <br>");
        printWriter.println("Book4 <br>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}

