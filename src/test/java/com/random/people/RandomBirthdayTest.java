/**
 * This file is part of Random data generator.
 *
 * Random data generator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Random data generator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Random data generator.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package com.random.people;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.thejavaguy.prng.generators.R250_521;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for RandomBirthday.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
final class RandomBirthdayTest {
    private RandomBirthday sut;
    private static final int REPS = 10000;

    @BeforeAll
    void setUp() {
        this.sut = new RandomBirthday(new R250_521.Smart(new R250_521()));
    }

    @Test
    void returnsBirthdayInTheSameYear() {
        testBirthdayForAge(0, 0);
    }

    @Test
    void returnsBirthdayInTheSpecificYear() {
        testBirthdayForAge(6, 6);
    }

    @Test
    void returnsBirthdayInTheSpecificRange() {
        testBirthdayForAge(6, 18);
    }

    private void testBirthdayForAge(int minAge, int maxAge) {
        final LocalDate now = LocalDate.now();
        final LocalDate upperBound = now.minusYears((long) minAge);
        final LocalDate lowerBound = now.minusYears((long) (maxAge + 1)).plusDays(1L);
        for (int i = 0; i < REPS; ++i) {
            final LocalDate actual = this.sut.birthday(minAge, maxAge);
            assertTrue(actual.isEqual(lowerBound) || actual.isAfter(lowerBound));
            assertTrue(actual.isEqual(upperBound) || actual.isBefore(upperBound));
        }
    }
}
