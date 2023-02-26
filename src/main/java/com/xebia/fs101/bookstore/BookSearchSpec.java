package com.xebia.fs101.bookstore;

public class BookSearchSpec {
    private final String author;
    private final String title;
    private final Genre genre;
    private final Language language;

    public BookSearchSpec(String author, String title, Genre genre, Language language) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public Language getLanguage() {
        return language;
    }
}
