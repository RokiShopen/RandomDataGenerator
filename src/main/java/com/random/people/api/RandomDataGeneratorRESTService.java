package com.random.people.api;

import com.random.people.RandomDataException;
import com.random.people.model.RDGErrorIds;
import com.random.people.model.RDGResponseBody;
import com.random.people.person.Person;
import com.random.people.person.PersonPool;
import com.random.people.person.RandomPersonPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/api/rest/v1")
public class RandomDataGeneratorRESTService {
    @Value("${countryCodes}")
    private String supportedCountries;

    @GetMapping(value = "/generate/{countryCode}/person")
    public ResponseEntity generateNewPerson(@PathVariable String countryCode) throws RandomDataException {
        return generatePersons(countryCode, 1);
    }

    @GetMapping(value = "/generate/{countryCode}/person/{numberOfNewPeople}")
    public ResponseEntity generateMultipleNewPersons(@PathVariable String countryCode,
                                                     @PathVariable Integer numberOfNewPeople) throws RandomDataException {
        return generatePersons(countryCode, numberOfNewPeople);
    }

    private ResponseEntity generatePersons(String countryCode, int numberOfNewPeople) throws RandomDataException {
        if (numberOfNewPeople < 1 || numberOfNewPeople > 100) {
            return ResponseEntity.badRequest().body(new RDGResponseBody(RDGErrorIds.INVALID_RANGE,
                    "Number of people must be between 1 and 100"));
        }
        try {
            validateCountryCode(countryCode);
        } catch (InvalidParameterException e){
            return ResponseEntity.badRequest().body(new RDGResponseBody(RDGErrorIds.INVALID_COUNTRY_CODE, e.getMessage()));
        }

        List<Person> persons = new LinkedList<>();
        for (int i = 0; i < numberOfNewPeople; i++){
            persons.add(getPerson(countryCode));
        }

        return ResponseEntity.ok().body(persons);
    }

    private Person getPerson(String countryCode) throws RandomDataException {
        final Locale SERBIAN = new Locale("sr", "RS", "Latn");
        PersonPool personPool = RandomPersonPool.forLocale(SERBIAN);
        return personPool.next();
    }

    private void validateCountryCode(String countryCode){
        if ( countryCode.length() < 2 || !supportedCountries.toUpperCase().contains(countryCode.toUpperCase()) ){
            String message = "Country code:'"+countryCode.toUpperCase()
                    +"' is not supported. Supported codes are:'"+supportedCountries.toUpperCase()+"'";
            log.info(message);
            throw new InvalidParameterException(message);
        }
        log.info("Country code:'{}' is supported.", countryCode.toUpperCase());
    }
}
