package com.random.people.person;

import com.random.people.LocalDateRange;

import java.time.LocalDate;
import java.time.Month;

public enum ZodiacSign {
    ARIES,
    TAURUS,
    GEMINI,
    CANCER,
    LEO,
    VIRGO,
    LIBRA,
    SCORPIO,
    SAGITTARIUS,
    CAPRICORN,
    AQUARIUS,
    PISCES;

    public static ZodiacSign from(final LocalDate birthDate) {
        if (isAries(birthDate)) {
            return ARIES;
        } else if (isTaurus(birthDate)) {
            return TAURUS;
        } else if (isGemini(birthDate)) {
            return GEMINI;
        } else if (isCancer(birthDate)) {
            return CANCER;
        } else if (isLeo(birthDate)) {
            return LEO;
        } else if (isVirgo(birthDate)) {
            return VIRGO;
        } else if (isLibra(birthDate)) {
            return LIBRA;
        } else if (isScorpio(birthDate)) {
            return SCORPIO;
        } else if (isSagittarius(birthDate)) {
            return SAGITTARIUS;
        } else if (isCapricorn(birthDate)) {
            return CAPRICORN;
        } else if (isAquarius(birthDate)) {
            return AQUARIUS;
        } else if (isPisces(birthDate)) {
            return PISCES;
        }
        throw new IllegalArgumentException(String.format(
                "BirthDate %s doesn't have zodiac sign", birthDate.toString())
        );
    }

    private static boolean isAries(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.MARCH, 21);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.APRIL, 20);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isTaurus(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.APRIL, 21);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.MAY, 21);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isGemini(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.MAY, 22);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.JUNE, 21);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isCancer(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.JUNE, 22);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.JULY, 22);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isLeo(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.JULY, 23);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.AUGUST, 22);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isVirgo(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.AUGUST, 23);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.SEPTEMBER, 23);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isLibra(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.SEPTEMBER, 24);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.OCTOBER, 23);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isScorpio(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.OCTOBER, 24);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.NOVEMBER, 22);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isSagittarius(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.NOVEMBER, 23);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.DECEMBER, 21);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isCapricorn(final LocalDate birthDate) {
        LocalDate eoyStart = LocalDate.of(birthDate.getYear(), Month.DECEMBER, 22);
        LocalDate eoyEnd = LocalDate.of(birthDate.getYear(), Month.DECEMBER, 31);
        LocalDate boyStart = LocalDate.of(birthDate.getYear(), Month.JANUARY, 1);
        LocalDate boyEnd = LocalDate.of(birthDate.getYear(), Month.JANUARY, 20);
        return new LocalDateRange(eoyStart, eoyEnd).contains(birthDate)
                || new LocalDateRange(boyStart, boyEnd).contains(birthDate);
    }

    private static boolean isAquarius(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.JANUARY, 21);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.FEBRUARY, 19);
        return new LocalDateRange(start, end).contains(birthDate);
    }

    private static boolean isPisces(final LocalDate birthDate) {
        LocalDate start = LocalDate.of(birthDate.getYear(), Month.FEBRUARY, 20);
        LocalDate end = LocalDate.of(birthDate.getYear(), Month.MARCH, 20);
        return new LocalDateRange(start, end).contains(birthDate);
    }
}
