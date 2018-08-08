package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class City {
    private String name;
    private CityCodes codes;

    public City(String name, CityCodes codes) {
        this.name = name;
        this.codes = codes;
    }

    public String name() {
        return name;
    }

    public CityCodes codes() {
        return codes;
    }
}
