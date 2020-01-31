package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swapi")
@Getter
@Setter
public class SwapiProperties {
    private String url;
    private String people;
    private String planets;
}
