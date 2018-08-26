package com.random.people.person;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;

public final class Birthday {
    private final LocalDate birthDate;

    public Birthday(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    @JsonGetter
    public ZodiacSign zodiacSign() {
        return ZodiacSign.from(birthDate);
    }
}
