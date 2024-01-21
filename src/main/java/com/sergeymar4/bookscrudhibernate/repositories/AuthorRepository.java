package com.sergeymar4.bookscrudhibernate.repositories;

import com.sergeymar4.bookscrudhibernate.models.Author;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import org.hibernate.query.Query;


public class AuthorRepository {

    public Author getById(int id) {
        Author author = new Author();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            author = session.get(Author.class, id);
        }

        return author;
    }

    public List<Author> getByFirstName(String firstName) {
        List<Author> authors = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Author where firstName=:firstName");
            query.setParameter("firstName", firstName);
            authors = query.list();
        }

        return authors;
    }

    public void create(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    public void update(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        }
    }

    public void delete(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
        }
    }
}
