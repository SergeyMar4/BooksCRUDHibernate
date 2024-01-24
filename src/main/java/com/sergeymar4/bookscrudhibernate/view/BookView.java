package com.sergeymar4.bookscrudhibernate.view;

import com.sergeymar4.bookscrudhibernate.controllers.AuthorController;
import com.sergeymar4.bookscrudhibernate.controllers.BookController;

import java.util.Scanner;

public class BookView {
    private String menuMessage;
    private BookController bookController;
    private Scanner scanner;

    public BookView(Scanner scanner) {
        this.menuMessage = "Выбирите действие над классом =\n" +
                "1.Вывести по id\n" +
                "2.Вывести список книг по имени\n" +
                "3.Создать\n" +
                "4.Обновить\n" +
                "5.Удалить\n" +
                "6.Добавить автора\n" +
                "7.Выйти в главное меню";
        this.scanner = scanner;
        this.bookController = new BookController();
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id книги = ");
                int id = scanner.nextInt();
                System.out.println(bookController.getById(id));
            } else if (s.equals("2")) {
                System.out.println("Введите название книги = ");
                String title = scanner.next();
                System.out.println(bookController.getByTitle(title));
            } else if (s.equals("3")) {
                System.out.println("Введите id издательства книги = ");
                int publisher_id = scanner.nextInt();
                System.out.println("Введите название книги = ");
                String title = scanner.next();
                System.out.println("Введие количество страниц = ");
                int pages = scanner.nextInt();
                System.out.println("Введтите год выпуска книги = ");
                int year = scanner.nextInt();
                System.out.println("Введите жанр книги = ");
                String genre = scanner.next();
                bookController.save(publisher_id, title, pages, year, genre);
            } else if (s.equals("4")) {
                System.out.println("Введите id издательства книги = ");
                int publisher_id = scanner.nextInt();
                System.out.println("Введите id книги = ");
                int id = scanner.nextInt();
                System.out.println("Введите название книги = ");
                String title = scanner.next();
                System.out.println("Введие количество страниц = ");
                int pages = scanner.nextInt();
                System.out.println("Введтите год выпуска книги = ");
                int year = scanner.nextInt();
                System.out.println("Введите жанр книги = ");
                String genre = scanner.next();
                bookController.update(id, publisher_id, title, pages, year, genre);
            } else if (s.equals("5")) {
                System.out.println("Введите id книги = ");
                int id = scanner.nextInt();
                bookController.delete(id);
            } else if (s.equals("6")) {
                System.out.println("Введите id книги = ");
                int book_id = scanner.nextInt();
                System.out.println("Введите id автора = ");
                int author_id = scanner.nextInt();
                bookController.addAuthor(book_id, author_id);
            } else {
                break;
            }
        }
    }
}
