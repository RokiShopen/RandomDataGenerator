package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
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
