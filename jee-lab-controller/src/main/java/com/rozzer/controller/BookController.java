package com.rozzer.controller;

import com.rozzer.controller.common.Controller;
import com.rozzer.model.Film;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/book")
public class BookController implements Controller<Film> {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Film> getAll() {
        return manager(Film.class).getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Film create() {
        return manager(Film.class).create();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Film read(@RequestParam(value = "id") String id) {
        return manager(Film.class).getById(new BigInteger(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Film object) {
        manager(Film.class).save(object);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Film object) {
        manager(Film.class).delete(object);
    }

}
