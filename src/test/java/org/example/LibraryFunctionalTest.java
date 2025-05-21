package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryFunctionalTest {

    public static void main(String[] args) {
        Library library = new Library();

        System.out.println(">>> Ajout de livres...");
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        library.addBook(new Book("Fahrenheit 451", "Ray Bradbury", 1953));

        System.out.println("\n>>> Bibliothèque après ajouts :");
        library.printBooks();

        System.out.println("\n>>> Suppression de 'le petit prince' (insensible à la casse)...");
        try{
            library.removeBookByTitle("le petit prince");
            System.out.println("Livre supprimé avec succès.");
        } catch (IllegalArgumentException e) {
            System.out.println("Livre non trouvé.");
        }

        System.out.println("\n>>> Bibliothèque finale :");
        library.printBooks();
    }
}
