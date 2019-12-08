package com.example.demo.repo;

import com.example.services.booksvc.Book;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 07.12.2019.
 */

@Component
public class BookRepository {

    private static final List<Book> books = new ArrayList<>();

    @PostConstruct
    private void initData(){
        Book book1 = new Book();
        book1.setName("Преступление и наказание");
        book1.setAuthor("Достоевский Федор Михайлович");
        book1.setPrice("500 р");

        books.add(book1);

        Book book2 = new Book();
        book2.setName("Чехов рассказы");
        book2.setAuthor("Антон Павлович Чехов");
        book2.setPrice("400 р");

        books.add(book2);
    }

    public Book findBook(String name) {
        Assert.notNull(name);

        Book result = null;

        for (Book book : books) {
            if (name.equals(book.getName())) {
                result = book;
            }
        }

        return result;
    }

    public void addBook(Book book){
        books.add(book);
    }
}
