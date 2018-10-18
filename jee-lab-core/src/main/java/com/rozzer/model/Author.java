package com.rozzer.model;

import com.rozzer.common.AbstractSaved;
import com.rozzer.manager.CoreServices;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author extends AbstractSaved {

    @Override
    public void save() {
        CoreServices.serviceFor(Author.class).save(this);
    }
}
