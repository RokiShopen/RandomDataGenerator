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
package com.random.people.datafile;

import java.util.Locale;

/**
 * Name of the file.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class Name {
    /**
     * Locale part of the Name.
     */
    private final Locale locale;
    /**
     * Name part of the Name.
     */
    private final String name;

    /**
     * Primary constructor.
     * @param locale Locale part
     * @param name Name part
     */
    public Name(final Locale locale, final String name) {
        this.locale = locale;
        this.name = name;
    }

    /**
     * String representation of Name.
     * @return Name as String
     */
    public String name() {
        return suffixed(this.localePart(), '/') + this.name;
    }

    /**
     * Returns locale part of a name.
     * @return Locale part of a name
     */
    private String localePart() {
        final char separator = '_';
        String ret = "";
        if (this.locale.getVariant().isEmpty()) {
            ret = suffixed(this.locale.getLanguage(), separator)
                + this.locale.getCountry();
        } else {
            ret = suffixed(this.locale.getLanguage(), separator)
                + suffixed(this.locale.getVariant(), separator)
                + this.locale.getCountry();
        }
        return ret;
    }

    /**
     * Builds string suffixed with char.
     * @param origin String to suffix
     * @param suffix Suffix
     * @return Suffixed string
     */
    private static String suffixed(final String origin, final char suffix) {
        return origin + suffix;
    }
}
