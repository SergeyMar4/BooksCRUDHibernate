package com.sergeymar4.bookscrudhibernate.repositories;

import com.sergeymar4.bookscrudhibernate.models.Book;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import java.util.ArrayList;
import org.hibernate.query.Query;

public class BookRepository {

    public Book getById(int id) {
        Book book = new Book();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            book = session.get(Book.class, id);
        }

        return book;
    }

    public List<Book> getByTitle(String title) {
        List<Book> books = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Book where title=:title");
            query.setParameter("title", title);
            books = query.list();
        }

        return books;
    }

    public void create(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    public void update(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        }
    }

    public void delete(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        }
    }
}
