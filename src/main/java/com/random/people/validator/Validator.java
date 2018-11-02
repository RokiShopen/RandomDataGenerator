package com.random.people.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.security.InvalidParameterException;
import java.util.Arrays;

@Slf4j
public class Validator {

    @Value("${countryCodes}")
    private String[] supportedCountries;

    public void validateCountryCode(String countryCode){

        if ( Arrays.stream(supportedCountries).noneMatch(s -> s.equalsIgnoreCase(countryCode)) ){
            String message = "Country code:'"+countryCode.toUpperCase() + "' is not supported.";
            log.info(message);
            throw new InvalidParameterException(message);
        }
        log.info("Country code:'{}' is supported.", countryCode.toUpperCase());
    }
}
