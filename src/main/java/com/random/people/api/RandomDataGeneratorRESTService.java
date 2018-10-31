package com.random.people.api;

import com.random.people.RandomDataException;
import com.random.people.generators.PersonGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/v1")
public class RandomDataGeneratorRESTService {

    private final PersonGenerator generator = new PersonGenerator();

    @GetMapping(value = "/{countryCode}/person")
    public ResponseEntity generatePerson(@PathVariable String countryCode) throws RandomDataException {
        return generator.generatePersons(countryCode, 1);
    }

    @GetMapping(value = "/{countryCode}/person/{numberOfPeople}")
    public ResponseEntity generateMultiplePersons(@PathVariable String countryCode,
                                                     @PathVariable Integer numberOfPeople) throws RandomDataException {
        return generator.generatePersons(countryCode, numberOfPeople);
    }
}
