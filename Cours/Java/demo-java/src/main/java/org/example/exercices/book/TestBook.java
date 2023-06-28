package org.example.exercices.book;

import java.math.BigDecimal;

public class TestBook {


    public static void main() {

        Book[] livres = new Book[]{
                new Book(1, "Book_1", new Author[]{new Author(1, "Jon", "Johnson")}, new Publisher(1, "Publisher_1"), 1990, 231, BigDecimal.valueOf(24.99), CoverType.PAPERBACK),
                new Book(2, "Book_2", new Author[]{new Author(1, "Jon", "Johnson"), new Author(2, "William", "Wilson")}, new Publisher(2, "Publisher_2 "), 2000, 120, BigDecimal.valueOf(14.99), CoverType.PAPERBACK),
                new Book(3, "Livre_3", new Author[]{new Author(3, "Walter", "Peterson")}, new Publisher(1, "Publisher_1"), 1997, 350, BigDecimal.valueOf(34.99), CoverType.HARDCOUVERTURE),
                new Book(4, "Book_4", new Author[]{new Author(4, "Craig", "Gregory")}, new Publisher(3, "Publisher_3"), 1992, 185, BigDecimal.valueOf(19.99), CoverType.PAPERBACK)};

        BookService service = new BookService();

        Author author = new Author(1, "Jon", "Johnson");
        Publisher publisher = new Publisher(3,"Publisher_3");
        int year = 1992;

        Book[] filterBooksByAuthor = service.filterBooksByAuthor(author, livres);
        Book[] filterBooksByPublisher = service.filterBooksByPublisher(publisher, livres);
        Book[] filterBooksByYear = service.filterBooksAfterSpecifiedYear(year, livres);

        System.out.println("Les livres rédigés par " + author);
        for (Book b : filterBooksByAuthor) {
            System.out.println(b);
        }

        System.out.println();

        System.out.println("Voici les livres publiés par " + publisher);
        for (Book b : filterBooksByPublisher) {
            System.out.println(b);
        }

        System.out.println();

        System.out.println("Voici les livres publiés en ou après " + year);
        for (Book b : filterBooksByYear) {
            System.out.println(b);
        }
    }






}
