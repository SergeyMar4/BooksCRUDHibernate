package com.sergeymar4.bookscrudhibernate.controllers;

import com.sergeymar4.bookscrudhibernate.models.Author;
import com.sergeymar4.bookscrudhibernate.models.Book;
import com.sergeymar4.bookscrudhibernate.repositories.AuthorRepository;
import com.sergeymar4.bookscrudhibernate.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController() {
        this.authorRepository = new AuthorRepository();
    }

    public Author getById(int id) {
        return authorRepository.getById(id);
    }

    public List<Author> getByFirstName(String firstName) {
        return authorRepository.getByFirstName(firstName);
    }

    public void save(String firstName, String lastName, int birthYear, String state) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBirthYear(birthYear);
        author.setState(state);
        authorRepository.create(author);
    }

    public void update(int id, String firstName, String lastName, int birthYear, String state) {
        Author author = authorRepository.getById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBirthYear(birthYear);
        author.setState(state);
        authorRepository.update(author);
    }

    public void delete(int id) {
        authorRepository.delete(authorRepository.getById(id));
    }
}
