package com.sergeymar4.bookscrudhibernate.view;

import java.util.Scanner;

public class MainView {
    private String menuMessage;
    private Scanner scanner;
    private AuthorView authorView;
    private BookView bookView;
    private PublisherView publisherView;

    public MainView() {
        this.menuMessage = "Выбирите класс для работы =\n" +
                            "1.Author\n" +
                            "2.Book\n" +
                            "3.Publisher\n" +
                            "4.Завершение программы";
        this.scanner = new Scanner(System.in);
        this.authorView = new AuthorView(scanner);
        this.bookView = new BookView(scanner);
        this.publisherView = new PublisherView(scanner);
    }

    public void run() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                authorView.show();
            } else if (s.equals("2")) {
                bookView.show();
            } else if (s.equals("3")) {
                publisherView.show();
            } else {
                break;
            }
        }
    }
}
