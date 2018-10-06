package com.rozzer.controller;

import com.rozzer.model.Genre;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/genre")
public class GenreController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Genre[] getAll() {
        return Genre.values();
    }
}
