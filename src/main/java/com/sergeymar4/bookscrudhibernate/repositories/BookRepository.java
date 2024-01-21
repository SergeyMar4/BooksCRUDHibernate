package com.sergeymar4.bookscrudhibernate.repositories;

import com.sergeymar4.bookscrudhibernate.models.Book;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookRepository {

    public Book getByTitle(String title) {
        Book book = new Book();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            book = session.get(Book.class, title);
        }

        return book;
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
