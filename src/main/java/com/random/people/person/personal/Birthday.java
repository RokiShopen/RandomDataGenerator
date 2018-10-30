package com.random.people.person.personal;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Birthday {
    private final LocalDate birthDate;

    @JsonGetter
    public ZodiacSign zodiacSign() {
        return ZodiacSign.from(birthDate);
    }
}
