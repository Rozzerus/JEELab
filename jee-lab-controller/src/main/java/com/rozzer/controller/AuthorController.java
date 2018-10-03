package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Author;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/author")
public class AuthorController implements Controller<Author> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Author> getAll() {
        return manager(Author.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Author create() {
        return manager(Author.class).create();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Author read(@RequestParam(value = "id") String id) {
        return manager(Author.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Author object) {
        manager(Author.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Author object) {
        manager(Author.class).delete(object);
    }
}
