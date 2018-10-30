package com.random.people.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.security.InvalidParameterException;

@Slf4j
public class Validator {

    @Value("${countryCodes}")
    private String supportedCountries;

    public void validateCountryCode(String countryCode){
        if ( countryCode.length() < 2 || !supportedCountries.toUpperCase().contains(countryCode.toUpperCase()) ){
            String message = "Country code:'"+countryCode.toUpperCase()
                    +"' is not supported. Supported codes are:'"+supportedCountries.toUpperCase()+"'";
            log.info(message);
            throw new InvalidParameterException(message);
        }
        log.info("Country code:'{}' is supported.", countryCode.toUpperCase());
    }
}
