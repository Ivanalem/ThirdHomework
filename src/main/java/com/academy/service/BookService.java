package com.academy.service;

import com.academy.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<Book>();

        Book book = new Book("ShonPerchinelli", 2015, 1);
        Book book1 = new Book("Shishkin dom", 2000, 2);
        Book book2 = new Book("NyPogodi", 2014, 3);
        Book book3 = new Book("ShopenNaPrikole", 2016, 4);

        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
    }
    public List<Book> getBookList() {
        return bookList;
    }
    public Book getBookId(Integer id){
        for(Book book : bookList){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
}
