package com.random.people.person;

import java.time.LocalDate;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class Person {
    private final PersonName personName;
    private final LocalDate birthday;
    private final Contact contact;
    private final Traits traits;
    private final String id;

    public Person(PersonName personName, LocalDate birthday, Contact contact, Traits traits, String id) {
        this.personName = personName;
        this.birthday = birthday;
        this.contact = contact;
        this.traits = traits;
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
    
    public Traits traits() {
        return this.traits;
    }

    public String id() {
        return this.id;
    }
}
