package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
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

    public Blood(Type type, RhesusFactor rh) {
        this.type = type;
        this.rh = rh;
    }

    public Type type() {
        return type;
    }

    public RhesusFactor rh() {
        return rh;
    }
}
