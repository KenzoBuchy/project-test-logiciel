package org.example;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (year < 1800 || year > 2025) {
            throw new IllegalArgumentException("L'année doit être comprise entre 1800 et 2025.");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Affichage lisible
    @Override
    public String toString() {
        return "\"" + title + "\" par " + author + " (" + year + ")";
    }
}

