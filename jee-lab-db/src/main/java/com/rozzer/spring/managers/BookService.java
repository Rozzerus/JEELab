package com.rozzer.spring.managers;

import com.google.common.collect.Lists;
import com.rozzer.manager.CoreServices;
import com.rozzer.manager.EntityService;
import com.rozzer.model.Book;
import com.rozzer.spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements EntityService<Book> {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        CoreServices.getServiceFactory().register(Book.class, this);
    }

    public List<Book> getAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    public void save(Book saved) {
        bookRepository.save(saved);
    }

    public void delete(Book saved) {
        bookRepository.delete(saved);
    }

    public Book getById(Long id) {
        return bookRepository.getOne(id);
    }

    public Book create() {
        Book book = new Book();
        return bookRepository.save(book);
    }
}
