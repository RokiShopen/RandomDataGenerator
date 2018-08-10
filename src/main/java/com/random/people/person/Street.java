package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class Street {
    private final String name;
    private final String number;

    public Street(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String name() {
        return name;
    }

    public String number() {
        return number;
    }
}
