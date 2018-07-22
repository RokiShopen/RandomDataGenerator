package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
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
