package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public final class Contact {
    private final Address address;
    private final String email;
    private final String landline;
    private final String mobile;

    public Contact(Address address, String email, String landline, String mobile) {
        this.address = address;
        this.email = email;
        this.landline = landline;
        this.mobile = mobile;
    }

    public Address address() {
        return address;
    }

    public String email() {
        return email;
    }

    public String landline() {
        return landline;
    }

    public String mobile() {
        return mobile;
    }
}
