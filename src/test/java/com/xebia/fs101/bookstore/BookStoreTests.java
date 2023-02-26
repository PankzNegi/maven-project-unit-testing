package com.xebia.fs101.bookstore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookStoreTests {

    @Test
    public void should_be_able_to_search_a_book_present_in_bookstore_inventory() {
        BookStore bookStore = initializeBookstore();
       List<Book> foundBook = bookStore.search(
                new BookSearchSpec(
                        null,
                        null,

                        Genre.TECHNOLOGY,

                        Language.ENGLISH
                ));

        assertThat(foundBook).hasSize(2);
        assertThat(foundBook.get(0).getTitle()).isEqualTo("Effective Java");
        assertThat(foundBook.get(1).getTitle()).isEqualTo("Clean Code");
    }
    @Test
    public void should_not_find_book_in_bookstore_when_search_criteria_doesnot_meet()
    {
        BookStore bookStore = initializeBookstore();

        List<Book> foundBook = bookStore.search(
                new BookSearchSpec(
                        null,
                        null,


                        Genre.TECHNOLOGY,

                        Language.FRENCH
                ));

        assertThat(foundBook).isEmpty();

    }

    private  BookStore initializeBookstore() {
        BookStore bookStore = new BookStore();
        bookStore.addBook(new Book("Joshua Bloch", "Effective Java", LocalDate.of(2018, Month.JANUARY, 6), 412, Genre.TECHNOLOGY, "9780134685991", Language.ENGLISH));
        bookStore.addBook(new Book("Robert C. Martin", "Clean Code", LocalDate.of(2008, Month.AUGUST, 1), 464, Genre.TECHNOLOGY, "9780132350884", Language.ENGLISH));
        bookStore.addBook(new Book("Daniel Kahneman", "Thinking, Fast and Slow", LocalDate.of(2011, Month.OCTOBER, 25), 512, Genre.PSYCHOLOGY, "9780374275631", Language.ENGLISH));
        bookStore.addBook(new Book("Antoine de Saint-Exupéry", "The Little Prince", LocalDate.of(2000, Month.MAY, 15), 96, Genre.FICTION, "9780156012195", Language.FRENCH));
        bookStore.addBook(new Book("Günter Grass", "Die Blechtrommel", LocalDate.of(1993, Month.OCTOBER, 1), 778, Genre.FICTION, "978-3423118217", Language.GERMAN));
        return bookStore;
    }
}
