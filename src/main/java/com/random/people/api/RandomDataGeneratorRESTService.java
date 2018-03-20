package com.random.people.api;

import com.random.people.RandomData;
import com.random.people.RandomDataException;
import com.random.people.sr_latn_rs.RandomDataRs;
import com.random.people.wrapper.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250_521;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/rest/v1")
public class RandomDataGeneratorRESTService {

    @GetMapping(value = "/generate/{countryCode}/person")
    public ResponseEntity generateNewPerson(@PathVariable String countryCode) throws RandomDataException {
        return ResponseEntity.ok().body(getPerson());
    }

    @GetMapping(value = "/generate/{countryCode}/person/{numberOfNewPeople}")
    public ResponseEntity generateMultipleNewPersons(@PathVariable String countryCode,
                                                     @PathVariable String numberOfNewPeople) throws RandomDataException {
        int number = 0;
        if (numberOfNewPeople != null && !numberOfNewPeople.isEmpty()) {
            number = Integer.valueOf(numberOfNewPeople);
        }
        if (number == 0 || number > 100) {
            return ResponseEntity.badRequest().body("Number of people must be between 1 and 100");
        }
        List<Person> persons = new LinkedList<>();
        for (int i = 0; i < number; i++){
            persons.add(getPerson());
        }

        return ResponseEntity.ok().body(persons);
    }

    private Person getPerson() throws RandomDataException {
        final PRNG.Smart rng = new R250_521.Smart(new R250_521());
        RandomData randomData = new RandomDataRs(rng);
        return randomData.person();
    }
}
