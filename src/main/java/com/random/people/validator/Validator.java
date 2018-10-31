package com.random.people.validator;

import lombok.extern.slf4j.Slf4j;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Validator {

    public void validateCountryCode(String countryCode){
        List<String> supportedCountries = new ArrayList<>();
        supportedCountries.add("sr");
        supportedCountries.add("dk");
        supportedCountries.add("us");
        supportedCountries.add("es");

        if ( supportedCountries.stream().noneMatch(s -> s.equalsIgnoreCase(countryCode)) ){
            String message = "Country code:'"+countryCode.toUpperCase() + "' is not supported.";
            log.info(message);
            throw new InvalidParameterException(message);
        }
        log.info("Country code:'{}' is supported.", countryCode.toUpperCase());
    }
}
