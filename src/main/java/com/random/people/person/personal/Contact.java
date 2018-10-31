package com.random.people.person;

import com.random.people.person.address.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@Getter
@AllArgsConstructor
public final class Contact {
    private final Address address;
    private final String email;
    private final String landline;
    private final String mobile;
    private final SocialMedia social;
}
