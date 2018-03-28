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

import com.random.people.wrapper.Address;
import com.random.people.wrapper.Person;

import java.time.LocalDate;
import java.util.Currency;

/**
 * Rs class.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface RandomData {
    /**
     * Comment.
     * @param gender Gender for which we want prefix
     * @return Name prefix
     * @throws RandomDataException When can't fetch prefix
     */
    String namePrefix() throws RandomDataException;

    /**
     * Comment.
     * @param gender Gender for which we want name
     * @return First name
     * @throws RandomDataException When can't fetch name
     */
    String firstName() throws RandomDataException;

    /**
     * Comment.
     * @return Last name
     * @throws RandomDataException When can't fetch name
     */
    String lastName() throws RandomDataException;

    /**
     * Comment.
     * @return Ssn
     */
    String ssn();

    /**
     * Comment.
     * @return Gender
     */
    Gender gender();

    /**
     * Comment.
     * @return Date of birth
     */
    LocalDate dateOfBirth();

    /**
     * Comment.
     * @return Address
     */
    Address address() throws RandomDataException;

    /**
     * Comment.
     * @return City
     * @throws RandomDataException When can't fetch city
     */
    String city() throws RandomDataException;

    /**
     * Comment.
     * @return State
     */
    String state();

    /**
     * Comment.
     * @return Country
     */
    String country();

    /**
     * Comment.
     * @return Phone number
     */
    String phoneNumber();

    /**
     * Comment.
     * @return Nationality
     */
    String nationality();

    /**
     * Comment.
     * @return Currency
     */
    Currency currency();

    /**
     * Comment.
     * @return Person
     */
    Person person() throws RandomDataException;
}
