package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDate;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Person {
    private final PersonName personName;
    private final LocalDate birthday;
    private final Contact contact;
    private final String id;

    public Person(PersonName personName, LocalDate birthday, Contact contact, String id) {
        this.personName = personName;
        this.birthday = birthday;
        this.contact = contact;
        this.id = id;
    }

    public PersonName name() {
        return this.personName;
    }

    public LocalDate birthday() {
        return this.birthday;
    }

    public Contact contact() {
        return this.contact;
    }

    public String id() {
        return this.id;
    }
}
