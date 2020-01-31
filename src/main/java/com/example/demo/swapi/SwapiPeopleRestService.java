package com.example.demo.swapi;

public interface SwapiPeopleRestService {

    People getPersonById(long id) throws PeopleNotFoundException;

}
