package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;


/**
 *
 */
@Entity
public class Book extends AbstractSaved {

    public Book() {
    }

    public Book(String name) {
        super(name);
    }

    @Override
    public void save() {

    }
}
