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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.thejavaguy.prng.generators.R250_521;

/**
 * Test for RandomBirthday.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomBirthdayTest {
    private RandomBirthday sut;
    private static final int REPS = 10000;

    @Before
    public void setUp() {
        this.sut = new RandomBirthday(new R250_521.Smart(new R250_521()));
    }

    @Test
    public void returnsBirthdayInTheSameYear() {
        testBirthdayForAge(0, 0);
    }

    @Test
    public void returnsBirthdayInTheSpecificYear() {
        testBirthdayForAge(6, 6);
    }

    @Test
    public void returnsBirthdayInTheSpecificRange() {
        testBirthdayForAge(6, 18);
    }

    private void testBirthdayForAge(int minAge, int maxAge) {
        final LocalDate now = LocalDate.now();
        final LocalDate upperBound = now.minusYears((long) minAge);
        final LocalDate lowerBound = now.minusYears((long) (maxAge + 1)).plusDays(1L);
        for (int i = 0; i < REPS; ++i) {
            final LocalDate actual = this.sut.birthday(minAge, maxAge);
            assertThat(actual.isEqual(lowerBound) || actual.isAfter(lowerBound), is(true));
            assertThat("actual = " + actual + ", min = " + lowerBound + ", max = " + upperBound, actual.isEqual(upperBound) || actual.isBefore(upperBound), is(true));
        }
    }
}
