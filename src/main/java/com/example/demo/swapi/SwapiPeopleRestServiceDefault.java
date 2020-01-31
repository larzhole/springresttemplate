package com.example.demo.swapi;

import com.example.demo.config.SwapiProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Log4j2
@Service
public class SwapiPeopleRestServiceDefault implements SwapiPeopleRestService {
    private final RestTemplate restTemplate;
    private final SwapiProperties swapiProperties;

    @Autowired
    public SwapiPeopleRestServiceDefault(RestTemplate restTemplate, SwapiProperties swapiProperties) {
        this.restTemplate = restTemplate;
        this.swapiProperties = swapiProperties;
    }

    @Override
    public People getPersonById(long id) throws PeopleNotFoundException {
        try {
            final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(
                    swapiProperties.getUrl() +
                    "/" +
                    swapiProperties.getPeople() +
                            id
            );

            return restTemplate.getForEntity(builder.toUriString(), People.class)
                    .getBody();
        } catch (RestClientException e) {
            final String message = "Unable to get people by id: " + id;
            log.error(message, e);
            throw new PeopleNotFoundException(message, e);
        }
    }
}
