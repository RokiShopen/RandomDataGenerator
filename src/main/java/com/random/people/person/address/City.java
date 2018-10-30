package com.random.people.person.address;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@Getter
@AllArgsConstructor
public final class City {
    private String name;
    private CityCodes codes;
}
