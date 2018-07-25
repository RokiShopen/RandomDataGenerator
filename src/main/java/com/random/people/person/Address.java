package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class Address {
    private Street street;
    private City city;
    private Country country;

    public Address(final Street street, final City city, final Country country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Street street() {
        return this.street;
    }

    public City city() {
        return this.city;
    }

    public Country country() {
        return this.country;
    }
}