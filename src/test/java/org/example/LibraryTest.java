package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testAjoutLivre(){
        Book book1 = new Book("Premier Livre", "Kenzo", 2024);
        Library lib = new Library();

        assertDoesNotThrow(()->{
            lib.addBook(book1);
        });
    }

    @Test
    void testEchecCreationLivre(){
        assertThrows(IllegalArgumentException.class, ()->{
            new Book("test", "test", 2050);
        });
    }

    @Test
    void testSuppressionLivre(){
        Book book1 = new Book("Premier Livre", "Kenzo", 2024);
        Library lib = new Library();

        assertDoesNotThrow(()->{
            lib.addBook(book1);
        });

        assertEquals(1, lib.librarySize());

        assertDoesNotThrow(()->{
            lib.removeBookByTitle("Premier Livre");
        });

        assertEquals(0, lib.librarySize());
    }

    @Test
    void testRechercheLivre(){
        Book book1 = new Book("Premier Livre", "Kenzo", 2024);
        Library lib = new Library();

        assertDoesNotThrow(()->{
            lib.addBook(book1);
        });

        Book bookSearch = lib.findBookByTitle("premier livre");
        assertEquals(book1, bookSearch);
    }

    @Test
    void testRechercheLivrePartiel(){
        Book book1 = new Book("Premier Livre", "Kenzo", 2024);
        Book book2 = new Book("Deuxieme Livre", "Kenzo", 2024);
        Book book3 = new Book("Troisieme Livre", "Kenzo", 2024);
        Library lib = new Library();
        List<Book> libExpected = List.of(book2);
        List<Book> libExpected2 = List.of(book1,book2,book3);

        assertDoesNotThrow(()->{
            lib.addBook(book1);
            lib.addBook(book2);
            lib.addBook(book3);
        });

        assertEquals(libExpected, lib.findBooksByPartialTitle("deuxieme"));
        assertEquals(libExpected2, lib.findBooksByPartialTitle("livre"));
    }

    @Test
    void testGetAllBooks(){
        Book book1 = new Book("Premier Livre", "Kenzo", 2024);
        Book book2 = new Book("Deuxieme Livre", "Autre", 2022);
        Library lib = new Library();
        List<Book> libExpected = List.of(book1, book2);

        assertDoesNotThrow(()->{
            lib.addBook(book1);
            lib.addBook(book2);
        });

        assertEquals(libExpected, lib.getAllBooks());
    }

    @Test
    void testGetAllBooksSort(){
        Book book1 = new Book("Premier Livre", "Kenzo", 2024);
        Book book2 = new Book("Deuxieme Livre", "Autre", 2022);
        Book book3 = new Book("Troisieme Livre", "Autre", 2021);
        Library lib = new Library();
        List<Book> libExpected = List.of(book2, book1, book3);

        assertDoesNotThrow(()->{
            lib.addBook(book1);
            lib.addBook(book2);
            lib.addBook(book3);
        });

        assertEquals(libExpected, lib.sortBooksByTitle());
    }




}