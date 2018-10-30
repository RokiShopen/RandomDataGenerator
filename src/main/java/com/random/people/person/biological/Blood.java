package com.random.people.person.biological;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@Getter
@AllArgsConstructor
public final class Blood {
    public enum Type {
        A,
        B,
        AB,
        O
    }

    public enum RhesusFactor {
        PLUS,
        MINUS
    }

    private Type type;
    private RhesusFactor rh;
}
