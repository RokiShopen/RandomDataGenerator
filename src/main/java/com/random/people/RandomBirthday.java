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

import java.time.LocalDate;
import org.thejavaguy.prng.generators.PRNG;

/**
 * DataFile with cached content.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomBirthday {
    /**
     * Random number generator used for obtaining random dates.
     */
    private final PRNG.Smart rng;

    /**
     * Primary constructor.
     * @param rng Random number generator
     */
    public RandomBirthday(final PRNG.Smart rng) {
        this.rng = rng;
    }

    /**
     * Returns birthday which respects min and max age of a person.
     * @param min Minimum age of a person
     * @param max Maximum age of a person
     * @return Birthday which satisfies given constraints
     */
    public LocalDate birthday(final int min, final int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                String.format(
                "max must be greater than min, yet values are: min=%d, max=%d",
                min, max
                )
            );
        }
        final LocalDate now = LocalDate.now();
        final LocalDate upper = now.minusYears((long) min);
        final LocalDate lower = now.minusYears((long) (max + 1)).plusDays(1L);
        final long diff = upper.toEpochDay() - lower.toEpochDay();
        final int addendum = this.rng.nextInt((int) diff);
        return LocalDate.ofEpochDay(lower.toEpochDay() + (long) addendum);
    }
}
