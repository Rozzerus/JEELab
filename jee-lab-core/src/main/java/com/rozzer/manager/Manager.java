package com.rozzer.manager;

import com.rozzer.model.Book;

import java.math.BigInteger;
import java.util.List;

public interface Manager<T extends Book> {
    List<Book> getAll();
    void save(Book book);
    void delete(Book book);
    Book getById(BigInteger id);
    Book create();
}
