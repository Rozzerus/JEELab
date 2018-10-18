package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.service;

@RestController
@RequestMapping(value = "/book")
public class BookController implements Controller<Book> {

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAll() {
        return service(Book.class).getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Book create() {
        return service(Book.class).create();
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Book read(@RequestParam(value = "id") String id) {
        return service(Book.class).getById(new Long(id));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Book object) {
        service(Book.class).save(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Book object) {
        service(Book.class).delete(object);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Book> showPage (@RequestParam(defaultValue = "0", value = "page") int page){
        return service(Book.class).getPage(page);
    }

}
