package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Currency;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Country {
    private CountryName name;
    private Currency currency;
    private CountryCodes codes;

    public Country(CountryName name, Currency currency, CountryCodes codes) {
        this.name = name;
        this.currency = currency;
        this.codes = codes;
    }

    public CountryName name() {
        return this.name;
    }

    public Currency currency() {
        return this.currency;
    }

    public CountryCodes codes() {
        return this.codes;
    }
}
