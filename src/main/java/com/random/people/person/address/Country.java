package com.random.people.person.address;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Currency;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@Getter
@AllArgsConstructor
public final class Country {
    private CountryName name;
    private Currency currency;
    private CountryCodes codes;
}
