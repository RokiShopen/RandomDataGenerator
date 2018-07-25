package com.random.people.person;

import com.random.people.Gender;
import com.random.people.RandomData;
import com.random.people.RandomDataException;
import com.random.people.ca_es.RandomDataEs;
import com.random.people.da_dk.RandomDataDk;
import com.random.people.datafile.CachedDataFile;
import com.random.people.datafile.Name;
import com.random.people.en_us.RandomDataUs;
import com.random.people.sr_latn_rs.RandomDataRs;
import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250_521;

import java.io.File;
import java.time.LocalDate;
import java.util.Locale;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class RandomPersonPool implements PersonPool {
    private static final Locale SERBIAN = new Locale("sr", "RS", "Latn");
    private static final Locale CATALAN = new Locale("ca", "es");
    private static final Locale DANISH = new Locale("da", "dk");
    private static final Locale US = new Locale("en", "us");
    private final RandomData randomData;

    private RandomPersonPool(final RandomData randomData) {
        this.randomData = randomData;
    }

    public static PersonPool forLocale(final Locale locale) {
        final PRNG.Smart rng = new R250_521.Smart(new R250_521());
        if (locale.equals(SERBIAN)) {
            final RandomData randomData = new RandomDataRs(
                    new CachedDataFile(resourceFile(named(locale, "firstNameMale.txt")), rng),
                    new CachedDataFile(resourceFile(named(locale, "firstNameFemale.txt")), rng),
                    new CachedDataFile(resourceFile(named(locale, "lastName.txt")), rng),
                    new CachedDataFile(resourceFile(named(locale, "namePrefix.txt")), rng),
                    new CachedDataFile(resourceFile(named(locale, "cities.txt")), rng),
                    new CachedDataFile(resourceFile(named(locale, "streets.txt")), rng),
                    rng, SERBIAN);
            return new RandomPersonPool(randomData);
        } else if (locale.equals(CATALAN)) {
            final RandomData randomData = new RandomDataEs();
            return new RandomPersonPool(randomData);
        } else if (locale.equals(DANISH)) {
            final RandomData randomData = new RandomDataDk();
            return new RandomPersonPool(randomData);
        } else {
            final RandomData randomData = new RandomDataUs();
            return new RandomPersonPool(randomData);
        }
    }

    /**
     * Syntactic sugar for obtaining name of resource file.
     *
     * @param filename Resource file name
     * @return Properly formatted name of a resource file
     */
    private static String named(final Locale locale, final String filename) {
        return new Name(locale, filename).name();
    }

    /**
     * Returns a handle to a resource file.
     *
     * @param name Name of the file
     * @return A handle to a resource file
     */
    private static File resourceFile(final String name) {
        return new File(Thread.currentThread().getContextClassLoader().getResource(name).getFile());
    }

    @Override
    public Person next() throws RandomDataException {
        final PersonName name = personName();
        final LocalDate birthday = birthday();
        final Contact contact = contact();
        final String id = id(birthday, contact.address().city(), name.gender());
        return new Person(name, birthday, contact, id);
    }

    private PersonName personName() throws RandomDataException {
        return this.randomData.personName();
    }

    private LocalDate birthday() {
        return this.randomData.dateOfBirth();
    }

    private String id(final LocalDate birthday, final City city, final Gender gender) {
        return this.randomData.id(birthday, city, gender);
    }

    private Contact contact() throws RandomDataException {
        return this.randomData.contact();
    }
}
