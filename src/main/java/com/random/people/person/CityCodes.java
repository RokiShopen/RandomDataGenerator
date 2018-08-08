package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class CityCodes {
    private int phone;
    private String postal;

    public CityCodes(int phone, String postal) {
        this.phone = phone;
        this.postal = postal;
    }

    public int phone() {
        return this.phone;
    }

    public String postal() {
        return this.postal;
    }
}
