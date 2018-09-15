package com.rozzer.spring.managers;

import com.rozzer.manager.Manager;
import com.rozzer.model.Book;

import java.math.BigInteger;
import java.util.List;

public class BookManager implements Manager<Book> {


    public List<Book> getAll() {
        return null;
    }

    public void save(Book book) {

    }

    public void delete(Book book) {

    }

    public Book getById(BigInteger id) {
        return null;
    }

    public Book create() {
        return null;
    }
}
