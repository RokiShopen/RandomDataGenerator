package com.random.people.person.address;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@Getter
@AllArgsConstructor
public final class Address {
    private Street street;
    private City city;
    private Country country;
}
