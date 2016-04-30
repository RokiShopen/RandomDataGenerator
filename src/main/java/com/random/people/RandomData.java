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

import java.util.Currency;
import java.util.Date;

/**
 * Rs class.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface RandomData {
    /**
     * Comment.
     * @return Name prefix
     */
    String namePrefix();

    /**
     * Comment.
     * @return First name
     */
    String firstName();

    /**
     * Comment.
     * @return Last name
     */
    String lastName();

    /**
     * Comment.
     * @return Ssn
     */
    String ssn();

    /**
     * Comment.
     * @return Gender
     */
    String gender();

    /**
     * Comment.
     * @return Date of birth
     */
    Date dateOfBirth();

    /**
     * Comment.
     * @return Address
     */
    String address();

    /**
     * Comment.
     * @return City
     */
    String city();

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
}
