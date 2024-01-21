package com.sergeymar4.bookscrudhibernate.repositories;

import com.sergeymar4.bookscrudhibernate.models.Author;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorRepository {

    public Author getByFirstName(String firstName) {
        Author author = new Author();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            author = session.get(Author.class, firstName);
        }

        return author;
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
