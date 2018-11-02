package com.random.people.generators;

import com.random.people.RandomDataException;
import com.random.people.model.RDGErrorIds;
import com.random.people.model.RDGResponseBody;
import com.random.people.person.Person;
import com.random.people.person.RandomPersonPool;
import com.random.people.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PersonGenerator {

    @Autowired
    private Validator validator;

    public ResponseEntity generatePersons(String countryCode, int numberOfPeople) throws RandomDataException {
        if (numberOfPeople < 1 || numberOfPeople > 100) {
            return ResponseEntity.badRequest().body(new RDGResponseBody(RDGErrorIds.INVALID_RANGE,
                    "Number of people must be between 1 and 100"));
        }
        try {
            validator.validateCountryCode(countryCode);
        } catch (InvalidParameterException e){
            return ResponseEntity.badRequest().body(new RDGResponseBody(RDGErrorIds.INVALID_COUNTRY_CODE, e.getMessage()));
        }

        List<Person> persons = new LinkedList<>();
        for (int i = 0; i < numberOfPeople; i++){
            persons.add(getPerson(countryCode));
        }

        return ResponseEntity.ok().body(persons);
    }

    private Person getPerson(String countryCode) throws RandomDataException {
        if (countryCode.equalsIgnoreCase("sr")){
            return RandomPersonPool.forLocale(new Locale("sr", "RS", "Latn")).next();
        }
        return RandomPersonPool.forLocale(new Locale("us")).empty();
    }
}
