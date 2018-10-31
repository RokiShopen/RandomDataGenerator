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
import java.util.List;

import com.random.people.person.Birthday;
import com.random.people.person.City;
import com.random.people.person.Contact;
import com.random.people.person.Country;
import com.random.people.person.Gender;
import com.random.people.person.MaritalStatus;
import com.random.people.person.PersonName;
import com.random.people.person.SocialMedia;
import com.random.people.person.Street;
import com.random.people.person.Traits;

/**
 * Rs class.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface RandomData {
    /**
     * Comment.
     * @return PersonName Name of a person
     * @throws RandomDataException When can't fetch some name related data
     */
    PersonName personName() throws RandomDataException;

    /**
     * Comment.
     * @param gender Gender for which we want prefix
     * @return String Name prefix
     * @throws RandomDataException When can't fetch prefix
     */
    String namePrefix(Gender gender) throws RandomDataException;

    /**
     * Comment.
     * @param gender Gender for which we want name
     * @return First name
     * @throws RandomDataException When can't fetch name
     */
    String firstName(Gender gender) throws RandomDataException;

    /**
     * Comment.
     * @param gender Gender for which we want name
     * @param count How many first names we want
     * @return First name
     * @throws RandomDataException When can't fetch name
     */
    List<String> firstNames(Gender gender, int count) throws RandomDataException;

    /**
     * Comment.
     * @return Last name
     * @throws RandomDataException When can't fetch name
     */
    String lastName() throws RandomDataException;

    /**
     * Comment.
     * @return Last name
     * @param count How many last names we want
     * @throws RandomDataException When can't fetch name
     */
    List<String> lastNames(int count) throws RandomDataException;

    /**
     * Comment.
     * @return Unique person's identificator
     */
    String id(Birthday birthday, City city, Gender gender);

    /**
     * Comment.
     * @return Gender
     */
    Gender gender();

    /**
     * Comment.
     * @return Person's birthday
     */
    Birthday birthday();

    /**
     * Comment.
     * @return Contact details
     * @param name
     */
    Contact contact(Birthday birthday, PersonName name) throws RandomDataException;

    /**
     * Comment.
     * @return Address
     * @throws RandomDataException When can't fetch address
     */
    Street street() throws RandomDataException;

    /**
     * Comment.
     * @return City
     * @throws RandomDataException When can't fetch city
     */
    String city() throws RandomDataException;

    /**
     * Comment.
     * @return Country
     */
    Country country();

    /**
     * Comment.
     * @param country Country
     * @param city City
     * @return Phone number
     */
    String phoneNumber(Country country, City city);

    /**
     * Comment.
     * @param country Country
     * @return Mobile phone number
     */
    String mobilePhoneNumber(Country country);

    SocialMedia socialMedia(Birthday birthday, PersonName name);

    /**
     * Comment.
     * @return Currency
     */
    Currency currency();

    /**
     * Comment.
     * @param country Country
     * @param name
     * @return Email address
     */
    String email(Country country, PersonName name);

    /**
     * @return Person's traits
     */
    Traits traits();

    /**
     *
     * @param birthday Person's birthday
     * @return Marital status
     */
    MaritalStatus status(Birthday birthday);
}
