package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
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
