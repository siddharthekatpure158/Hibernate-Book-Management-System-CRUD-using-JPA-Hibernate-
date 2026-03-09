package com.siddharth.hibernate2;

import java.util.*;
import jakarta.persistence.*;

public class BookDAO {

    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private static EntityTransaction transaction;

    static Scanner sc = new Scanner(System.in);

    public static void openconnection() {
        factory = Persistence.createEntityManagerFactory("hibernate");
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
    }

    public static void closeconnection() {

        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }

        if (manager != null) {
            manager.close();
        }

        if (factory != null) {
            factory.close();
        }
    }


    public static void addbook() {

        openconnection();
        transaction.begin();

        System.out.println("Enter BookID");
        int bookid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Book Name");
        String name = sc.nextLine();

        System.out.println("Enter Book Author Name");
        String author = sc.nextLine();

        System.out.println("Enter price of the Book");
        double price = sc.nextDouble();

        BookDTO book = new BookDTO(bookid, name, author, price);

        manager.persist(book);

        transaction.commit();
        closeconnection();

        System.out.println("Book Added Successfully");
    }


    public static void findbookbyId() {

        openconnection();
        transaction.begin();

        System.out.println("Enter Book ID");
        int id = sc.nextInt();

        BookDTO book = manager.find(BookDTO.class, id);

        if (book != null) {
            System.out.println("Book Found");
            System.out.println(book.getBookid() + " | " + book.getName() + " | " + book.getAuthor() + " | " + book.getPrice());
        } else {
            System.out.println("Book Not Found");
        }

        transaction.commit();
        closeconnection();
    }

   

    public static void updatebook() {

        openconnection();
        transaction.begin();

        System.out.println("Enter BookID");
        int id = sc.nextInt();

        BookDTO book = manager.find(BookDTO.class, id);

        if (book != null) {

            System.out.println("1.Update Book Name");
            System.out.println("2.Update Book Author");
            System.out.println("3.Update Book Price");

            int ch = sc.nextInt();

            switch (ch) {

                case 1 -> {
                    sc.nextLine();
                    System.out.println("Enter New Book Name");
                    String name = sc.nextLine();
                    book.setName(name);
                }

                case 2 -> {
                    sc.nextLine();
                    System.out.println("Enter New Author Name");
                    String author = sc.nextLine();
                    book.setAuthor(author);
                }

                case 3 -> {
                    System.out.println("Enter New Price");
                    double price = sc.nextDouble();
                    book.setPrice(price);
                }

                default -> System.out.println("Invalid Choice");
            }

            transaction.commit();
            System.out.println("Book Updated Successfully");
        }

        else {
            System.out.println("Book Not Found");
        }

        closeconnection();
    }

    public static void deletebook() {

        openconnection();
        transaction.begin();

        System.out.println("Enter BookID");
        int id = sc.nextInt();

        BookDTO book = manager.find(BookDTO.class, id);

        if (book != null) {

            manager.remove(book);
            transaction.commit();
            System.out.println("Book Deleted Successfully");

        } else {
            System.out.println("Book Not Found");
        }

        closeconnection();
    }


    public static void main(String[] args) {

        boolean flag = true;

        while (flag) {

            System.out.println("\n====== Book Management ======");
            System.out.println("1.Add Book");
            System.out.println("2.Find Book By ID");
            System.out.println("3.Update Book");
            System.out.println("4.Delete Book");
            System.out.println("5.Exit");

            System.out.println("Enter Choice");

            int ch = sc.nextInt();

            switch (ch) {

                case 1 -> addbook();
                case 2 -> findbookbyId();
                case 3 -> updatebook();
                case 4 -> deletebook();
                case 5 -> {
                    flag = false;
                    System.out.println("Exited Successfully");
                }

                default -> System.out.println("Invalid Choice");
            }
        }
    }
}