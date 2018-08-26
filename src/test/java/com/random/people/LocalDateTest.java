package com.random.people;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LocalDateTest {
    @Test
    void test() {
        LocalDate date1 = LocalDate.of(2018, 1, 1);
        LocalDate date2 = LocalDate.of(2018, 1, 1);
        assertFalse(date1.isBefore(date2));
    }
}
