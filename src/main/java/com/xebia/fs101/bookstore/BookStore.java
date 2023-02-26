package com.xebia.fs101.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookStore {

    private List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> search(BookSearchSpec toSearch) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (isNotCaseInsensitiveEquals(toSearch.getAuthor(), book.getAuthor())) {
                continue;
            }
            if (toSearch.getGenre() != null
                    && book.getGenre() != toSearch.getGenre()) {
                continue;
            }
            if (isNotCaseInsensitiveEquals(toSearch.getTitle(), book.getTitle())) {
                continue;
            }
            if (toSearch.getLanguage() != null
                    && book.getLanguage() != toSearch.getLanguage()) {
                continue;
            }
            results.add(book);
        }
        return results;
    }



    private  boolean isNotCaseInsensitiveEquals(String s1,String s2) {

        return s1 != null
                && !Objects.equals(s2.toLowerCase(),s1.toLowerCase());
    }
 }