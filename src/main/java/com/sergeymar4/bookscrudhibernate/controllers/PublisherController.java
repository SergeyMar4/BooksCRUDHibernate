package com.sergeymar4.bookscrudhibernate.controllers;

import com.sergeymar4.bookscrudhibernate.models.Publisher;
import com.sergeymar4.bookscrudhibernate.repositories.PublisherRepository;
import org.hibernate.Session;

import java.util.List;

public class PublisherController {
    private PublisherRepository publisherRepository;

    public PublisherController() {
        this.publisherRepository = new PublisherRepository();
    }

    public Publisher getById(int id) {
        return publisherRepository.getById(id);
    }

    public List<Publisher> getByTitle(String title) {
        return publisherRepository.getByTitle(title);
    }

    public void save(String title, int foundationYear, String city) {
        Publisher publisher = new Publisher();
        publisher.setTitle(title);
        publisher.setFoundationYear(foundationYear);
        publisher.setCity(city);
        publisherRepository.create(publisher);
    }

    public void update(int id, String title, int foundationYear, String city) {
        Publisher publisher = publisherRepository.getById(id);
        publisher.setTitle(title);
        publisher.setFoundationYear(foundationYear);
        publisher.setCity(city);
        publisherRepository.update(publisher);
    }

    public void delete(int id) {
        publisherRepository.delete(publisherRepository.getById(id));
    }
}
