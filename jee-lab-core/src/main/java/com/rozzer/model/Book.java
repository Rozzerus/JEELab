package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.manager.CoreServices;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 */
@Entity
@Table(name = "book")
public class Book extends AbstractSaved {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Genre genre;

    public Book() {
    }

    public Book(String name) {
        super(name);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public void save() {
        CoreServices.serviceFor(Book.class).save(this);
    }
}
