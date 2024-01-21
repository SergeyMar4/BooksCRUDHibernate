package com.sergeymar4.bookscrudhibernate.controllers;

import com.sergeymar4.bookscrudhibernate.models.Book;
import com.sergeymar4.bookscrudhibernate.repositories.BookRepository;

import java.util.List;

public class BookController {
    private BookRepository bookRepository;

    public BookController() {
        this.bookRepository = new BookRepository();
    }

    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    public List<Book> getByTitle(String title) {
        return bookRepository.getByTitle(title);
    }

    public void save(String title, int pages, int year, String genre) {
        Book book = new Book();
        book.setTitle(title);
        book.setPages(pages);
        book.setYear(year);
        book.setGenre(genre);
        bookRepository.create(book);
    }

    public void update(int id, String title, int pages, int year, String genre) {
        Book book = bookRepository.getById(id);
        book.setTitle(title);
        book.setPages(pages);
        book.setYear(year);
        book.setGenre(genre);
        bookRepository.update(book);
    }

    public void delete(int id) {
        bookRepository.delete(bookRepository.getById(id));
    }
}
