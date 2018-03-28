package com.random.people.api;

import com.random.people.RandomData;
import com.random.people.RandomDataException;
import com.random.people.sr_latn_rs.RandomDataRs;
import com.random.people.wrapper.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250_521;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/rest/v1")
public class RandomDataGeneratorRESTService {

    @Value("${countryCodes}")
    private String supportedCountries;

    @GetMapping(value = "/generate/{countryCode}/person")
    public ResponseEntity generateNewPerson(@PathVariable String countryCode) throws RandomDataException {
        try {
            validateCountryCode(countryCode);
        } catch (UnsupportedOperationException e){
            return ResponseEntity.badRequest().body("Invalid country code");
        }

        return ResponseEntity.ok().body(getPerson(countryCode));
    }

    @GetMapping(value = "/generate/{countryCode}/person/{numberOfNewPeople}")
    public ResponseEntity generateMultipleNewPersons(@PathVariable String countryCode,
                                                     @PathVariable String numberOfNewPeople) throws RandomDataException {
        try {
            validateCountryCode(countryCode);
        } catch (UnsupportedOperationException e){
            return ResponseEntity.badRequest().body("Invalid country code");
        }

        int number = 0;
        if (numberOfNewPeople != null && !numberOfNewPeople.isEmpty()) {
            number = Integer.valueOf(numberOfNewPeople);
        }
        if (number == 0 || number > 100) {
            return ResponseEntity.badRequest().body("Number of people must be between 1 and 100");
        }
        List<Person> persons = new LinkedList<>();
        for (int i = 0; i < number; i++){
            persons.add(getPerson(countryCode));
        }

        return ResponseEntity.ok().body(persons);
    }

    private Person getPerson(String countryCode) throws RandomDataException {
        final PRNG.Smart rng = new R250_521.Smart(new R250_521());
        RandomData randomData = new RandomDataRs(rng);
        return randomData.person();
    }

    private void validateCountryCode(String countryCode){
        if ( !supportedCountries.toUpperCase().contains(countryCode.toUpperCase()) ){
            log.info("Country code:'{}' is not supported. Supported codes are:'{}'",
                    countryCode.toUpperCase(),
                    supportedCountries.toUpperCase());
            throw new UnsupportedOperationException();
        }
        log.info("Country code:'{}' is supported.", countryCode.toUpperCase());
    }
}
