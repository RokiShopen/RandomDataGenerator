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
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250;

import java.io.File;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Random data for Serbian language.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomDataRs implements RandomData {
    private final DataFile maleNames;
    private final DataFile femaleNames;
    private final DataFile lastNames;
    private final DataFile namePrefixes;
    private final DataFile cities;
    private final PRNG randomGenerator;

    public RandomDataRs(DataFile maleNames, DataFile femaleNames, DataFile lastNames, DataFile namePrefixes, DataFile cities, PRNG randomGenerator)
    {
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
     * @throws Exception If there is a problem with resource file
     */
    public static void main(final String[] args) throws Exception {
        RandomDataRs randomDataRs = new RandomDataRs(
          new CachedDataFile(file("sr_Latn_RS/firstNameMale.txt"), new R250()),
            new CachedDataFile(file("sr_Latn_RS/firstNameFemale.txt"), new R250()),
              new CachedDataFile(file("sr_Latn_RS/lastName.txt"), new R250()),
                new CachedDataFile(file("sr_Latn_RS/namePrefix.txt"), new R250()),
                  new CachedDataFile(file("sr_Latn_RS/cities.txt"), new R250()),
                   new R250());

        System.out.println(
          randomDataRs.namePrefix()+ ", " + randomDataRs.firstName() + ", " +
          randomDataRs.lastName()+ ", " + randomDataRs.dateOfBirth() + ", " +
          randomDataRs.gender()+ ", " + randomDataRs.phoneNumber() + ", " +
          randomDataRs.city()+ ", " + randomDataRs.country() + ", " +
          randomDataRs.nationality()+ ", " + randomDataRs.currency() + " "
        );
    }

    private static File file(String fileName) {
        return new File(
            Thread.currentThread()
                .getContextClassLoader()
                .getResource(fileName).getFile()
        );
    }

    @Override
    public String namePrefix() throws RandomDataException {
        return namePrefixes.specificLine(randomGenerator.nextInt(0, 2));
    }

    @Override
    public String firstName() {
        try
        {
            return randomGenerator.nextInt(1) == 0 ? maleNames.randomLine() : femaleNames.randomLine();
        } catch (RandomDataException e)
        {
            return null;
        }
    }

    @Override
    public String lastName() {
        try
        {
            return lastNames.randomLine();
        } catch (RandomDataException e)
        {
            return null;
        }
    }

    @Override
    public String ssn() {
        return null;
    }

    @Override
    public String gender() {
        return randomGenerator.nextInt(1) == 0 ? "muški" : "ženski";
    }

    @Override
    public Date dateOfBirth() {
        return new Date();
    }

    @Override
    public String address() {
        return null;
    }

    @Override
    public String city() {
        try
        {
            return cities.randomLine();
        } catch (RandomDataException e)
        {
            return null;
        }
    }

    @Override
    public String state() {
        return null;
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
        return Currency.getInstance(new Locale("sr", "RS", "Latn"));
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
