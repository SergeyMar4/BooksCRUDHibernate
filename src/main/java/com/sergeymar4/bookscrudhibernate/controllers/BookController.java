package com.sergeymar4.bookscrudhibernate.controllers;

import com.sergeymar4.bookscrudhibernate.models.Author;
import com.sergeymar4.bookscrudhibernate.models.Book;
import com.sergeymar4.bookscrudhibernate.repositories.AuthorRepository;
import com.sergeymar4.bookscrudhibernate.repositories.BookRepository;
import com.sergeymar4.bookscrudhibernate.repositories.PublisherRepository;

import java.util.List;

public class BookController {
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;

    public BookController() {
        this.bookRepository = new BookRepository();
        this.publisherRepository = new PublisherRepository();
        this.authorRepository = new AuthorRepository();
    }

    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    public List<Book> getByTitle(String title) {
        return bookRepository.getByTitle(title);
    }

    public void addAuthor(int book_id, int author_id) {
        bookRepository.addAuthor(bookRepository.getById(book_id), authorRepository.getById(author_id));
    }

    public void save(int publisher_id, String title, int pages, int year, String genre) {
        Book book = new Book();
        book.setTitle(title);
        book.setPages(pages);
        book.setYear(year);
        book.setGenre(genre);
        book.setPublisher(publisherRepository.getById(publisher_id));
        bookRepository.create(book);
    }

    public void update(int id, int publisher_id, String title, int pages, int year, String genre) {
        Book book = bookRepository.getById(id);
        book.setTitle(title);
        book.setPages(pages);
        book.setYear(year);
        book.setGenre(genre);
        book.setPublisher(publisherRepository.getById(publisher_id));
        bookRepository.update(book);
    }

    public void delete(int id) {
        bookRepository.delete(bookRepository.getById(id));
    }
}
