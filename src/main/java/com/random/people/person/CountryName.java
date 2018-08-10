package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class CountryName {
    private String local;
    private String english;

    public CountryName(String local, String english) {
        this.local = local;
        this.english = english;
    }

    public String local() {
        return local;
    }

    public String english() {
        return english;
    }
}
