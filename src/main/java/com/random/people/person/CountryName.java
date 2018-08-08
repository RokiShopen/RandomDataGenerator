package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
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
