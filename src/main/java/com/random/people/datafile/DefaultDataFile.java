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

import java.io.File;

/**
 * Default implementation of DataFile with uncached content.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class DefaultDataFile implements DataFile {
    /**
     * Underlying file with data.
     */
    private final File origin;

    /**
     * Secondary constructor.
     * @param name Name of the file
     */
    public DefaultDataFile(final Name name) {
        this(
            new File(
                Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(name.name()).getFile()
                )
        );
    }

    /**
     * Primary constructor.
     * @param origin Wrapped file
     */
    public DefaultDataFile(final File origin) {
        this.origin = origin;
    }

    @Override
    public String randomLine() {
        throw new UnsupportedOperationException();
    }
}
