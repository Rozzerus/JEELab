package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Author;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.service;

@RestController
@RequestMapping(value = "/author")
public class AuthorController implements Controller<Author> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Author> getAll() {
        return service(Author.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Author create() {
        return service(Author.class).create();
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Author read(@RequestParam(value = "id") String id) {
        return service(Author.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Author object) {
        service(Author.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Author object) {
        service(Author.class).delete(object);
    }
}
