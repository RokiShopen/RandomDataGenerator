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
package com.random.people.sr_latn_rs;

import com.random.people.RandomBirthday;
import com.random.people.RandomData;
import com.random.people.RandomDataException;
import com.random.people.datafile.CachedDataFile;
import com.random.people.datafile.DataFile;
import com.random.people.datafile.Name;
import com.random.people.person.Address;
import com.random.people.person.Birthday;
import com.random.people.person.Blood;
import com.random.people.person.City;
import com.random.people.person.CityCodes;
import com.random.people.person.Contact;
import com.random.people.person.Country;
import com.random.people.person.CountryCodes;
import com.random.people.person.CountryName;
import com.random.people.person.Gender;
import com.random.people.person.PersonName;
import com.random.people.person.Street;
import com.random.people.person.Traits;
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250_521;

import java.io.File;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Random data for Serbian language.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomDataRs implements RandomData {
    /**
     * Male names.
     */
    private final DataFile males;
    /**
     * Female names.
     */
    private final DataFile females;
    /**
     * Last names.
     */
    private final DataFile last;
    /**
     * PersonName prefixes.
     */
    private final DataFile prefixes;
    /**
     * Cities.
     */
    private final DataFile cities;
    /**
     * Streets.
     */
    private final DataFile streets;
    /**
     * Random number generator.
     */
    private final PRNG.Smart rng;
    /**
     * Random birthday generator.
     */
    private final RandomBirthday birthday;
    /**
     * Serbian locale.
     */
    private final Locale locale;

    /**
     * Primary constructor.
     * @param males Male names
     * @param females Female names
     * @param last Last names
     * @param prefixes PersonName prefixes
     * @param cities Cities
     * @param streets Streets
     * @param rng Random number generator
     * @param locale Locale
     */
    public RandomDataRs(final DataFile males, final DataFile females,
                        final DataFile last, final DataFile prefixes, final DataFile cities,
                        final DataFile streets, final PRNG.Smart rng, final Locale locale) {
        this.males = males;
        this.females = females;
        this.last = last;
        this.prefixes = prefixes;
        this.cities = cities;
        this.streets = streets;
        this.rng = rng;
        this.birthday = new RandomBirthday(this.rng);
        this.locale = locale;
    }

    @Override
    public PersonName personName() throws RandomDataException {
        final Gender gender = this.gender();
        final PersonName ret = new PersonName(gender, this.namePrefix(gender));
        final int givens = numberOfGivenNames();
        final int lasts = numberOfLastNames(gender);
        final List<String> givenList = this.firstNames(gender, givens);
        final List<String> lastList = this.lastNames(lasts);
        ret.addGivenNames(givenList);
        ret.addLastNames(lastList);
        return ret;
    }

    private int numberOfGivenNames() {
        int ret = 1;
        if (this.rng.nextInt(1, 1000) == 1) {
            ret = 2;
        }
        return ret;
    }

    private int numberOfLastNames(final Gender gender) {
        int ret = 1;
        if (gender == Gender.MALE && this.rng.nextInt(1, 1000) == 1) {
            ret = 2;
        } else if (gender == Gender.FEMALE && this.rng.nextInt(1, 1000) <= 10) {
            ret = 2;
        }
        return ret;
    }

    @Override
    public String namePrefix(final Gender gender) throws RandomDataException {
        final String ret;
        if (gender.equals(Gender.MALE)) {
            ret = this.prefixes.specificLine(0);
        } else {
            ret = this.prefixes.specificLine(this.rng.nextInt(1, 2));
        }
        return ret;
    }

    @Override
    public String firstName(final Gender gender) throws RandomDataException {
        final String ret;
        if (gender.equals(Gender.MALE)) {
            ret = this.males.randomLine();
        } else {
            ret = this.females.randomLine();
        }
        return ret;
    }

    @Override
    public List<String> firstNames(final Gender gender, final int count) throws RandomDataException {
        final List<String> ret = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            ret.add(this.firstName(gender));
        }
        return ret;
    }

    @Override
    public String lastName() throws RandomDataException {
        return this.last.randomLine();
    }

    @Override
    public List<String> lastNames(final int count) throws RandomDataException {
        final List<String> ret = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            ret.add(this.lastName());
        }
        return ret;
    }

    @Override
    public String id(final Birthday birthday, final City city, final Gender gender) {
        return "DUMMY_ID";
    }

    @Override
    public Gender gender() {
        final Gender ret;
        if (this.rng.nextBoolean()) {
            ret = Gender.MALE;
        } else {
            ret = Gender.FEMALE;
        }
        return ret;
    }

    @Override
    public Birthday birthday() {
        final int min = 18;
        final int max = 120;
        return new Birthday(this.birthday.birthday(min, max));
    }

    @Override
    public Contact contact(PersonName name) throws RandomDataException {
        final Address address = address();
        final Contact ret = new Contact(
                address,
                this.email(address.country(), name),
                this.phoneNumber(address.country(), address.city()),
                this.mobilePhoneNumber(address.country()));
        return ret;
    }

    private Address address() throws RandomDataException {
        final Street street = this.street();
        final City city = this.cityX();
        final Country country = this.country();
        final Address ret = new Address(street, city, country);
        return ret;
    }

    @Override
    public Street street() throws RandomDataException {
        final String name = this.streets.randomLine();
        final int number = this.rng.nextInt(1, 300);
        String snumber = String.valueOf(number);
        if (this.rng.nextInt(1, 1000) <= 5) {
            final char letter = (char) this.rng.nextInt('a', 'z');
            snumber += String.valueOf(letter);
        }
        return new Street(name, snumber);
    }

    private City cityX() throws RandomDataException {
        final String city = this.cities.randomLine();
        final String[] components = city.split(";");
        int phone = 1;
        if (components.length >= 2) {
            phone = Integer.parseInt(components[1]);
        }
        String postal = "A12345";
        if (components.length >= 3) {
            postal = components[2];
        }
        return new City(components[0], new CityCodes(phone, postal));
    }

    @Override
    public String city() throws RandomDataException {
        return this.cities.randomLine();
    }

    @Override
    public Country country() {
        final CountryName name = new CountryName("Srbija", "Serbia");
        final int[] mobiles = new int[]{62, 63, 64, 65, 66, 67, 68, 69};
        final CountryCodes codes = new CountryCodes(381, mobiles, "RS", "SRB");
        return new Country(name, this.currency(), codes);
    }

    @Override
    public String phoneNumber(final Country country, final City city) {
        final int minimum = 1000000;
        final int maximum = 9999999;
        final StringBuilder ret = new StringBuilder();
        ret
                .append("+")
                .append(country.codes().phone())
                .append(city.codes().phone())
                .append(this.rng.nextInt(minimum, maximum));
        return ret.toString();
    }

    @Override
    public String mobilePhoneNumber(final Country country) {
        final int minimum = 1000000;
        final int maximum = 9999999;
        final int[] mobile = country.codes().mobile();
        final StringBuilder ret = new StringBuilder();
        ret
                .append("+")
                .append(country.codes().phone())
                .append(mobile[this.rng.nextInt(mobile.length - 1)])
                .append(this.rng.nextInt(minimum, maximum));
        return ret.toString();
    }

    @Override
    public Currency currency() {
        return Currency.getInstance(this.locale);
    }

    @Override
    public String email(final Country country, final PersonName name) {
        return name.givenNames().get(0) + "." + name.lastNames().get(0) + "@" + country.name().english().toLowerCase() + "." + country.codes().isoAlpha2().toLowerCase();
    }

    /**
     * Temporary main method for spiking purposes.
     * @param args Program arguments
     * @throws Exception If there is a problem when reading data from resource
     *  file(s)
     */
    public static void main(final String[] args) throws Exception {
        final PRNG.Smart rng = new R250_521.Smart(new R250_521());
        final RandomDataRs serbian = new RandomDataRs(
                new CachedDataFile(resourceFile(named("firstNameMale.txt")), rng),
                new CachedDataFile(resourceFile(named("firstNameFemale.txt")), rng),
                new CachedDataFile(resourceFile(named("lastName.txt")), rng),
                new CachedDataFile(resourceFile(named("namePrefix.txt")), rng),
                new CachedDataFile(resourceFile(named("cities.txt")), rng),
                new CachedDataFile(resourceFile(named("streets.txt")), rng),
                rng,
                new Locale("sr", "RS", "Latn")
        );
    }

    /**
     * Syntactic sugar for obtaining name of resource file.
     * @param filename Resource file name
     * @return Properly formatted name of a resource file
     */
    private static String named(final String filename) {
        return new Name(new Locale("sr", "RS", "Latn"), filename).name();
    }

    /**
     * Returns a handle to a resource file.
     * @param name PersonName of the file
     * @return A handle to a resource file
     */
    private static File resourceFile(final String name) {
        return new File(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResource(name).getFile()
        );
    }

    @Override
    public Traits traits() {
        final int height = this.rng.nextInt(150, 210);
        final int weight = this.rng.nextInt(45, 130);
        final int hairColor = this.rng.nextInt(15);
        final int eyeColor = this.rng.nextInt(15);
        Blood.Type[] bloodTypes = Blood.Type.values();
        Blood.RhesusFactor[] rhesusFactors = Blood.RhesusFactor.values();
        final Blood blood = new Blood(
                bloodTypes[this.rng.nextInt(bloodTypes.length - 1)],
                rhesusFactors[this.rng.nextInt(rhesusFactors.length - 1)]
        );
        return new Traits(height, weight, hairColor, eyeColor, blood);
    }
}
