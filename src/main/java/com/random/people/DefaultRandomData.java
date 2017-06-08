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
import java.util.Currency;

/**
 * Random data for undefined language.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class DefaultRandomData implements RandomData {
    @Override
    public String namePrefix(Gender gender) {
        return null;
    }

    @Override
    public String firstName(Gender gender) {
        return null;
    }

    @Override
    public String lastName() {
        return null;
    }

    @Override
    public String ssn() {
        return null;
    }

    @Override
    public Gender gender() {
        return null;
    }

    @Override
    public LocalDate dateOfBirth() {
        return null;
    }

    @Override
    public String address() {
        return null;
    }

    @Override
    public String city() {
        return null;
    }

    @Override
    public String state() {
        return null;
    }

    @Override
    public String country() {
        return null;
    }

    @Override
    public String phoneNumber() {
        return null;
    }

    @Override
    public String nationality() {
        return null;
    }

    @Override
    public Currency currency() {
        return null;
    }
}
