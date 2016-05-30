package com.random.people.datafile;

import java.util.Locale;

/**
 * @author Ivan Milosavljevic imilosavljevic@novomaticls.com
 */
public class Name {
    private final Locale locale;
    private final String name;

    public Name(Locale locale, String name) {
        this.locale = locale;
        this.name = name;
    }

    public String name() {
        return suffixed(localePart(), '/') + name;
    }

    private String localePart() {
        final char separator = '_';
        if (locale.getVariant().isEmpty()) {
            return suffixed(locale.getLanguage(), separator) + locale.getCountry();
        } else {
            return suffixed(locale.getLanguage(), separator) + suffixed (locale.getVariant(), separator) + locale.getCountry();
        }
    }

    private String suffixed(String origin, char suffix) {
        return origin + suffix;
    }
}
