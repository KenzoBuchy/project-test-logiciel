package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null){
            throw new IllegalArgumentException("Veuillez ajouter un livre");
        }
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Aucun livre trouvé.");
    }

    public Book findBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                return books.get(i);
            }
        }
        return null;
    }

    public List<Book> sortBooksByTitle() {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        return sorted;
    }

    public int librarySize(){
        return books.size();
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("La bibliothèque est vide.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
}
