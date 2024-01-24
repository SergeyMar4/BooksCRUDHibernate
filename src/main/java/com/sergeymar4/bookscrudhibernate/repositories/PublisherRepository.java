package com.sergeymar4.bookscrudhibernate.repositories;

import com.sergeymar4.bookscrudhibernate.models.Book;
import com.sergeymar4.bookscrudhibernate.models.Publisher;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

public class PublisherRepository {

    public Publisher getById(int id) {
        Publisher publisher = new Publisher();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            publisher = session.get(Publisher.class, id);
        }

        return publisher;
    }

    public List<Publisher> getByTitle(String title) {
        List<Publisher> publishers = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Publisher where title=:title");
            query.setParameter("title", title);
            publishers = query.list();
        }

        return publishers;
    }

    public void addBook(Publisher publisher, Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            publisher.getBooks().add(book);
            Transaction transaction = session.beginTransaction();
            session.update(publisher);
            transaction.commit();
        }
    }

    public void create(Publisher publisher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(publisher);
            transaction.commit();
        }
    }

    public void update(Publisher publisher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(publisher);
            transaction.commit();
        }
    }

    public void delete(Publisher publisher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(publisher);
            transaction.commit();
        }
    }
}
