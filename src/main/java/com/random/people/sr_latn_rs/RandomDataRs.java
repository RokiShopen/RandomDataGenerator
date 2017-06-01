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
    }

    @Override
    public String namePrefix() throws RandomDataException {
        return this.prefixes.randomLine();
    }

    @Override
    public String firstName() throws RandomDataException {
        String ret = "";
        if (this.rng.nextBoolean()) {
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
    public String gender() {
        String ret = "";
        if (this.rng.nextBoolean()) {
            ret = "muški";
        } else {
            ret = "ženski";
        }
        return ret;
    }

    @Override
    public LocalDate dateOfBirth() {
        return LocalDate.now();
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
        ret
            .append(this.namePrefix())
            .append(separator)
            .append(this.firstName())
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

    /**
     * Month number.
     * @return Month in range [1,12]
     */
    private int month() {
        final int lowest = 1;
        final int highest = 12;
        return this.rng.nextInt(lowest, highest);
    }

    /**
     * Day in month.
     * @return Day in range [1,31]
     */
    private int day() {
        final int lowest = 1;
        final int highest = 31;
        return this.rng.nextInt(lowest, highest);
    }

    /**
     * Year number.
     * @return Year in range [1900,2017]
     */
    private int year() {
        final int lowest = 1900;
        final int highest = 2017;
        return this.rng.nextInt(lowest, highest);
    }

    /**
     * Digit.
     * @return A single digit in range [0,9]
     */
    private int digit() {
        final int lowest = 0;
        final int highest = 9;
        return this.rng.nextInt(lowest, highest);
    }
}
