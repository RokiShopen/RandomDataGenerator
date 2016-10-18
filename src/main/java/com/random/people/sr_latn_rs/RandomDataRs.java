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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
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
        final Locale locale = new Locale("sr", "RS", "Latn");
        System.out.println(
            String.format("Name of Locale: %s", locale.getDisplayName())
        );
        System.out.println(
            String.format(
                "Language Code: %s, Language Display Name: %s",
                locale.getLanguage(), locale.getDisplayLanguage()
            )
        );
        System.out.println(
            String.format(
                "Country Code: %s, Country Display Name: %s",
                locale.getCountry(), locale.getDisplayCountry()
            )
        );
        if (!locale.getScript().equals("")) {
            System.out.println(
                String.format(
                    "Script Code: %s, Script Display Name: %s",
                    locale.getScript(), locale.getDisplayScript()
                )
            );
        }
        if (!locale.getVariant().equals("")) {
            System.out.println(
                String.format(
                    "Variant Code: %s, Variant Display Name: %s",
                    locale.getVariant(), locale.getDisplayVariant()
                )
            );
        }
        final File file = new File(
            Thread.currentThread()
                .getContextClassLoader()
                .getResource("sr_Latn_RS/firstNameFemale.txt").getFile()
        );
        try (InputStream in = new FileInputStream(file);
            Reader rdr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(rdr)) {
            for (;;) {
                final String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        }
        System.out.println(new CachedDataFile(file, new R250()).randomLine());
    }

    @Override
    public String namePrefix() throws RandomDataException {
        return namePrefixes.randomLine();
    }

    @Override
    public String firstName() {
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
    public String gender() {
        return randomGenerator.nextInt(1) == 0 ? "muški" : "ženski";
    }

    @Override
    public Date dateOfBirth() {
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
        return "Srbija";
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
