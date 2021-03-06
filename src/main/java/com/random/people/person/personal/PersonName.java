package com.random.people.person.personal;

import com.random.people.person.biological.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class PersonName {
    private Gender gender;
    private String prefix;
    private List<String> given;
    private List<String> last;

    public PersonName(final Gender gender, final String prefix) {
        this.gender = gender;
        this.prefix = prefix;
        this.given = new ArrayList<>();
        this.last = new ArrayList<>();
    }

    public void addGivenName(final String name) {
        this.given.add(name);
    }

    public void addGivenNames(final String... given) {
        for (String name : given) {
            addGivenName(name);
        }
    }

    public void addGivenNames(final Iterable<String> given) {
        for (String name : given) {
            addGivenName(name);
        }
    }

    public void addLastName(final String name) {
        this.last.add(name);
    }

    public void addLastNames(final String... last) {
        for (String name : last) {
            addLastName(name);
        }
    }

    public void addLastNames(final Iterable<String> last) {
        for (String name : last) {
            addLastName(name);
        }
    }

    public Gender gender() {
        return gender;
    }

    public String prefix() {
        return prefix;
    }

    public List<String> givenNames() {
        return Collections.unmodifiableList(given);
    }

    public List<String> lastNames() {
        return Collections.unmodifiableList(last);
    }
}
