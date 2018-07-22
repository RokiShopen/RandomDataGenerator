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
package com.random.people.da_dk;

import com.random.people.Gender;
import com.random.people.RandomData;
import com.random.people.RandomDataException;
import com.random.people.person.City;
import com.random.people.person.Contact;
import com.random.people.person.Country;
import com.random.people.person.PersonName;
import com.random.people.person.Street;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

/**
 * Random data for Danish language.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomDataDk implements RandomData {
    @Override
    public PersonName personName() throws RandomDataException {
        return null;
    }

    @Override
    public String namePrefix(final Gender gender) {
        return null;
    }

    @Override
    public String firstName(final Gender gender) {
        return null;
    }

    @Override
    public List<String> firstNames(final Gender gender, final int count) throws RandomDataException {
        return null;
    }

    @Override
    public String lastName() {
        return null;
    }

    @Override
    public List<String> lastNames(final int count) throws RandomDataException {
        return null;
    }

    @Override
    public String id(final LocalDate birthday, final City city, final Gender gender) {
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
    public Contact contact() throws RandomDataException {
        return null;
    }

    @Override
    public Street street() {
        return null;
    }

    @Override
    public String city() {
        return null;
    }

    @Override
    public Country country() {
        return null;
    }

    @Override
    public String phoneNumber(final Country country, final City city) {
        return null;
    }

    @Override
    public String mobilePhoneNumber(final Country country) {
        return null;
    }

    @Override
    public Currency currency() {
        return null;
    }

    @Override
    public String email(final Country country) {
        return null;
    }
}
