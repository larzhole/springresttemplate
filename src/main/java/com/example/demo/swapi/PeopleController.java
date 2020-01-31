package com.example.demo.swapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/people")
public class PeopleController {
    private final SwapiPeopleRestService swapiPeopleRestService;

    @Autowired
    public PeopleController(SwapiPeopleRestService swapiPeopleRestService) {
        this.swapiPeopleRestService = swapiPeopleRestService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity getPeopleById(@PathVariable long id) throws PeopleNotFoundException {
        return ResponseEntity.ok(swapiPeopleRestService.getPersonById(id));
    }
}
