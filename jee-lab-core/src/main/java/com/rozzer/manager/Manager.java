package com.rozzer.manager;

import com.rozzer.model.Book;

import java.math.BigInteger;

public interface Manager<T extends Book> {
    void save(Book book);
    void delete(Book book);
    Book getById(BigInteger id);
    Book create();
}
