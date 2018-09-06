package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class Contact {
    private final Address address;
    private final String email;
    private final String landline;
    private final String mobile;
    private final SocialMedia social;

    public Contact(Address address, String email, String landline, String mobile, SocialMedia social) {
        this.address = address;
        this.email = email;
        this.landline = landline;
        this.mobile = mobile;
        this.social = social;
    }

    public Address address() {
        return this.address;
    }

    public String email() {
        return this.email;
    }

    public String landline() {
        return this.landline;
    }

    public String mobile() {
        return this.mobile;
    }
    
    public SocialMedia social() {
        return this.social;
    }
}
