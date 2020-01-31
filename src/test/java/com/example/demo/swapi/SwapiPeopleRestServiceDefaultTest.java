package com.example.demo.swapi;

import com.example.demo.config.SwapiProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SwapiPeopleRestServiceDefaultTest {

    private SwapiPeopleRestServiceDefault swapiPeopleRestServiceDefault;

    @Mock
    private RestTemplate restTemplate;

    private SwapiProperties swapiProperties;

    @Before
    public void setUp() {
        swapiProperties = new SwapiProperties();
        swapiProperties.setUrl("https://swapi.co/api/");
        swapiProperties.setPeople("people");
        swapiProperties.setPlanets("planets");
        swapiPeopleRestServiceDefault = new SwapiPeopleRestServiceDefault(restTemplate, swapiProperties);
    }

    @Test
    public void getPersonById() throws PeopleNotFoundException {
        final People person = new People();
        person.setHeight("170");
        person.setMass("221");
        person.setName("Luke");

        Mockito.when(restTemplate.getForEntity(
                Mockito.anyString(),
                Mockito.any(),
                ArgumentMatchers.any(Class.class)))
                .thenReturn(new ResponseEntity<>(person, HttpStatus.OK));

        Assert.assertNotNull(swapiPeopleRestServiceDefault.getPersonById(100L));
    }
}