package com.rozzer.spring.managers;

import com.rozzer.manager.CoreServices;
import com.rozzer.manager.EntityService;
import com.rozzer.model.Author;
import com.rozzer.spring.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements EntityService<Author> {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        CoreServices.getServiceFactory().register(Author.class, this);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(Author saved) {
        authorRepository.save(saved);
    }

    @Override
    public void delete(Author saved) {
        authorRepository.delete(saved);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public Author create() {
        Author author = new Author();
        return authorRepository.save(author);
    }
}
