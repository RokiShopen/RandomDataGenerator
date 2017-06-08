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

import com.random.people.Gender;
import com.random.people.RandomBirthday;
import com.random.people.RandomData;
import com.random.people.RandomDataException;
import com.random.people.datafile.CachedDataFile;
import com.random.people.datafile.DataFile;
import com.random.people.datafile.Name;
import java.io.File;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250_521;

/**
 * Random data for Serbian language.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomDataRs implements RandomData {
    /**
     * Serbian locale.
     */
    private static final Locale LOCALE_SERBIAN = new Locale("sr", "RS", "Latn");
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
     * Name prefixes.
     */
    private final DataFile prefixes;
    /**
     * Cities.
     */
    private final DataFile cities;
    /**
     * Random number generator.
     */
    private final PRNG.Smart rng;
    /**
     * Random birthday generator.
     */
    private final RandomBirthday birthday;

    /**
     * Primary constructor.
     * @param males Male names
     * @param females Female names
     * @param last Last names
     * @param prefixes Name prefixes
     * @param cities Cities
     * @param rng Random number generator
     */
    public RandomDataRs(final DataFile males, final DataFile females,
        final DataFile last, final DataFile prefixes, final DataFile cities,
        final PRNG.Smart rng) {
        this.males = males;
        this.females = females;
        this.last = last;
        this.prefixes = prefixes;
        this.cities = cities;
        this.rng = rng;
        this.birthday = new RandomBirthday(this.rng);
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
    public String lastName() throws RandomDataException {
        return this.last.randomLine();
    }

    @Override
    public String ssn() {
        return null;
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
    public LocalDate dateOfBirth() {
        final int min = 18;
        final int max = 120;
        return this.birthday.birthday(min, max);
    }

    @Override
    public String address() {
        return null;
    }

    @Override
    public String city() throws RandomDataException {
        return this.cities.randomLine();
    }

    @Override
    public String state() {
        return "Srbija";
    }

    @Override
    public String country() {
        return "Srbija";
    }

    @Override
    public String phoneNumber() {
        final String prefix = "+381";
        final int minimum = 1000000;
        final int maximum = 9999999;
        final StringBuilder ret = new StringBuilder();
        ret
            .append(prefix)
            .append(this.rng.nextInt(minimum, maximum));
        return ret.toString();
    }

    @Override
    public String nationality() {
        return "Srpska";
    }

    @Override
    public Currency currency() {
        return Currency.getInstance(LOCALE_SERBIAN);
    }

    /**
     * String representation of this object.
     * @return String which describes this object
     * @throws RandomDataException if there were some errors obtaining data
     */
    public String stringify() throws RandomDataException {
        final StringBuilder ret = new StringBuilder();
        final String separator = ", ";
        final Gender gender = this.gender();
        ret
            .append(this.namePrefix(gender))
            .append(separator)
            .append(this.firstName(gender))
            .append(separator)
            .append(this.lastName())
            .append(separator)
            .append(this.dateOfBirth())
            .append(separator)
            .append(this.gender())
            .append(separator)
            .append(this.phoneNumber())
            .append(separator)
            .append(this.city())
            .append(separator)
            .append(this.country())
            .append(separator)
            .append(this.nationality())
            .append(separator)
            .append(this.currency());
        return ret.toString();
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
            rng
        );
        System.out.println(serbian.stringify());
    }

    /**
     * Syntactic sugar for obtaining name of resource file.
     * @param filename Resource file name
     * @return Properly formatted name of a resource file
     */
    private static String named(final String filename) {
        return new Name(LOCALE_SERBIAN, filename).name();
    }

    /**
     * Returns a handle to a resource file.
     * @param name Name of the file
     * @return A handle to a resource file
     */
    private static File resourceFile(final String name) {
        return new File(
            Thread.currentThread()
                .getContextClassLoader()
                .getResource(name).getFile()
        );
    }
}
