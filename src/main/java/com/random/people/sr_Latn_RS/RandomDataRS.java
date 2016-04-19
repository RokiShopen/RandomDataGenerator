/**
 * This file is part of Random data generator.
 *
 * Random data generator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Random data generator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Random data generator.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package com.random.people.sr_latn_rs;

import com.random.people.RandomData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Rs class.
 * @author Aleksandar Marinkovic (marinkovic.aleksandarr@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RandomDataRs implements RandomData {
    /**
     * Temporary main method for spiking purposes.
     * @param args Program arguments
     * @throws IOException If there is a problem with resource file
     */
    public static void main(final String[] args) throws IOException {
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
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        for (;;) {
            final String line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

    @Override
    public String namePrefix() {
        return null;
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
        return null;
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
        return null;
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
        return null;
    }
}
