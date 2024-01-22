package com.sergeymar4.bookscrudhibernate.view;

import com.sergeymar4.bookscrudhibernate.controllers.AuthorController;
import com.sergeymar4.bookscrudhibernate.controllers.PublisherController;

import java.util.Scanner;

public class PublisherView {
    private String menuMessage;
    private PublisherController publisherController;
    private Scanner scanner;

    public PublisherView(Scanner scanner) {
        this.menuMessage = "Выбирите действие над классом =\n" +
                "1.Вывести по id\n" +
                "2.Вывести список изданий по имени\n" +
                "3.Создать\n" +
                "4.Обновить\n" +
                "5.Удалить\n" +
                "6.Выйти в главное меню";
        this.scanner = scanner;
        this.publisherController = new PublisherController();
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id издательства = ");
                int id = scanner.nextInt();
                System.out.println(publisherController.getById(id));
            } else if (s.equals("2")) {
                System.out.println("Введите название издательства = ");
                String title = scanner.next();
                System.out.println(publisherController.getByTitle(title));
            } else if (s.equals("3")) {
                System.out.println("Введите название издательства = ");
                String title = scanner.next();
                System.out.println("Введие год основания издательсвта = ");
                int foundationYear = scanner.nextInt();
                System.out.println("Введтите город издательства = ");
                String city = scanner.next();
                publisherController.save(title, foundationYear, city);
            } else if (s.equals("4")) {
                System.out.println("Введите id издательства = ");
                int id = scanner.nextInt();
                System.out.println("Введите название издательства = ");
                String title = scanner.next();
                System.out.println("Введие год основания издательсвта = ");
                int foundationYear = scanner.nextInt();
                System.out.println("Введтите город издательства = ");
                String city = scanner.next();
                publisherController.update(id, title, foundationYear, city);
            } else if (s.equals("5")) {
                System.out.println("Введите id издательства = ");
                int id = scanner.nextInt();
                publisherController.delete(id);
            } else {
                break;
            }
        }
    }
}
