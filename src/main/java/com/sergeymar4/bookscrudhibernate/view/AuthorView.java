package com.sergeymar4.bookscrudhibernate.view;

import com.sergeymar4.bookscrudhibernate.controllers.AuthorController;

import java.util.Scanner;

public class AuthorView {
    private String menuMessage;
    private AuthorController authorController;
    private Scanner scanner;

    public AuthorView(Scanner scanner) {
        this.menuMessage = "Выбирите действие над классом =\n" +
                            "1.Вывести по id\n" +
                            "2.Вывести список авторов по имени\n" +
                            "3.Создать\n" +
                            "4.Обновить\n" +
                            "5.Удалить\n" +
                            "6.Выйти в главное меню";
        this.scanner = scanner;
        this.authorController = new AuthorController();
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id автора = ");
                int id = scanner.nextInt();
                System.out.println(authorController.getById(id));
            } else if (s.equals("2")) {
                System.out.println("Введите имя автора = ");
                String firstName = scanner.next();
                System.out.println(authorController.getByFirstName(firstName));
            } else if (s.equals("3")) {
                System.out.println("Введите имя автора = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию автора = ");
                String lastName = scanner.next();
                System.out.println("Введите год рождения автора = ");
                int birthYear = scanner.nextInt();
                System.out.println("Введите страну автора = ");
                String state = scanner.next();
                authorController.save(firstName, lastName, birthYear, state);
            } else if (s.equals("4")) {
                System.out.println("Введите id автора = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя автора = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию автора = ");
                String lastName = scanner.next();
                System.out.println("Введите год рождения автора = ");
                int birthYear = scanner.nextInt();
                System.out.println("Введите страну автора = ");
                String state = scanner.next();
                authorController.update(id, firstName, lastName, birthYear, state);
            } else if (s.equals("5")) {
                System.out.println("Введите id автора = ");
                int id = scanner.nextInt();
                authorController.delete(id);
            } else {
                break;
            }
        }
    }
}
