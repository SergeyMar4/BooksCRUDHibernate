package com.sergeymar4.bookscrudhibernate.repositories;

import com.sergeymar4.bookscrudhibernate.models.Publisher;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PublisherRepository {

    public Publisher getByTitle(String title) {
        Publisher publisher = new Publisher();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            publisher = session.get(Publisher.class, title);
        }

        return publisher;
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
