/**
 * This file is part of Random data generator.
 * <p>
 * Random data generator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Random data generator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p>
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
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250_521;

import java.io.File;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

/**
 * Random data for Serbian language.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomDataRs implements RandomData {
    private static final Locale locale = new Locale("sr", "RS", "Latn");
    private static final String MALE = "muski";
    private final String gender;
    private final DataFile maleNames;
    private final DataFile femaleNames;
    private final DataFile lastNames;
    private final DataFile namePrefixes;
    private final DataFile cities;
    private final PRNG.Smart randomGenerator;

    public RandomDataRs(String gender, DataFile maleNames, DataFile femaleNames, DataFile lastNames, DataFile namePrefixes, DataFile cities, PRNG.Smart randomGenerator) {
        this.gender = gender;
        this.maleNames = maleNames;
        this.femaleNames = femaleNames;
        this.lastNames = lastNames;
        this.namePrefixes = namePrefixes;
        this.cities = cities;
        this.randomGenerator = randomGenerator;
    }

    /**
     * Temporary main method for spiking purposes.
     * @param args Program arguments
     * @throws Exception If there is a problem when reading data from resource file(s)
     */
    public static void main(final String[] args) throws Exception {
        final PRNG.Smart rng = new R250_521.Smart(new R250_521());
        RandomDataRs randomDataRs = new RandomDataRs(
        "muski",
                new CachedDataFile(resourceFile(new Name(locale, "firstNameMale.txt").name()), rng),
                new CachedDataFile(resourceFile(new Name(locale, "firstNameFemale.txt").name()), rng),
                new CachedDataFile(resourceFile(new Name(locale, "lastName.txt").name()), rng),
                new CachedDataFile(resourceFile(new Name(locale, "namePrefix.txt").name()), rng),
                new CachedDataFile(resourceFile(new Name(locale, "cities.txt").name()), rng),
                rng);

        System.out.println(
                randomDataRs.namePrefix() + ", " + randomDataRs.firstName() + ", " +
                        randomDataRs.lastName() + ", " + randomDataRs.dateOfBirth() + ", " +
                        randomDataRs.gender() + ", " + randomDataRs.phoneNumber() + ", " +
                        randomDataRs.city() + ", " + randomDataRs.country() + ", " +
                        randomDataRs.nationality() + ", " + randomDataRs.currency() + " "
        );
    }

    private static File resourceFile(String fileName) {
        return new File(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResource(fileName).getFile()
        );
    }

    private static boolean checkGender(String gender) {
        return gender.equals(MALE);
    }

    @Override
    public String namePrefix() throws RandomDataException {
        String namePrefix;
        if (checkGender(gender)) {
            namePrefix = namePrefixes.specificLine(0);
        } else {
            namePrefix = namePrefixes.specificLine(randomGenerator.nextInt(1, 2));
        }
        return namePrefix;
    }

    @Override
    public String firstName() throws RandomDataException {
        String firstName;
        if (checkGender(gender)) {
            firstName = maleNames.randomLine();
        } else {
            firstName = femaleNames.randomLine();
        }
        return firstName;
    }

    @Override
    public String lastName() throws RandomDataException {
        return lastNames.randomLine();
    }

    @Override
    public String ssn() {
        return null;
    }

    @Override
    public String gender() {
        return gender;
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
        return cities.randomLine();
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
        return "+381" + randomGenerator.nextInt(1000000, 9999999);
    }

    @Override
    public String nationality() {
        return "Srpska";
    }

    @Override
    public Currency currency() {
        return Currency.getInstance(locale);
    }

    private int month() {
        return randomGenerator.nextInt(1, 12);
    }

    private int day() {
        return randomGenerator.nextInt(1, 31);
    }

    private int year() {
        return randomGenerator.nextInt(1000, 3000);
    }

    private int digit() {
        return randomGenerator.nextInt(0, 9);
    }
}
