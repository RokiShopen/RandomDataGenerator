/**
 *
 */
package com.random.people.sr_Latn_RS;

import com.random.people.RandomData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * @author Sasa - marinkovic.aleksandarr@gmail.com on 3/28/2016.
 * @version
 * @since
 */
public final class RandomDataRS implements RandomData {
    /**
     * Temporary main method for spiking purposes
     * @param args Program arguments
     * @throws IOException If there is a problem with resource file
     */
    public static void main(final String[] args) throws IOException {
        final Locale locale = new Locale("sr", "RS", "Latn");
        System.out.println(String.format("Name of Locale: %s", locale.getDisplayName()));
        System.out.println(String.format("Language Code: %s, Language Display Name: %s", locale.getLanguage(), locale.getDisplayLanguage()));
        System.out.println(String.format("Country Code: %s, Country Display Name: %s", locale.getCountry(), locale.getDisplayCountry()));
        if (!locale.getScript().equals("")) {
            System.out.println(String.format("Script Code: %s, Script Display Name: %s", locale.getScript(), locale.getDisplayScript()));
        }
        if (!locale.getVariant().equals("")) {
            System.out.println(String.format("Variant Code: %s, Variant Display Name: %s", locale.getVariant(), locale.getDisplayVariant()));
        }
        final ClassLoader classloader = RandomDataRS.class.getClassLoader();
        final File file = new File(classloader.getResource("sr_Latn_RS/firstNameFemale.txt").getFile());
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        for (;;) {
            final String line = bufferedReader.readLine();
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
