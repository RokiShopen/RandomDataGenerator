package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class Person {
    private final PersonName personName;
    private final Birthday birthday;
    private final Contact contact;
    private final MaritalStatus status;
    private final Traits traits;
    private final String id;

    public Person(PersonName personName, Birthday birthday, Contact contact, MaritalStatus status, Traits traits, String id) {
        this.personName = personName;
        this.birthday = birthday;
        this.contact = contact;
        this.status = status;
        this.traits = traits;
        this.id = id;
    }

    public PersonName name() {
        return this.personName;
    }

    public Birthday birthday() {
        return this.birthday;
    }

    public Contact contact() {
        return this.contact;
    }
    
    public MaritalStatus status() {
        return this.status;
    }
    
    public Traits traits() {
        return this.traits;
    }

    public String id() {
        return this.id;
    }
}
