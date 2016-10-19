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

import com.random.people.RandomDataException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.thejavaguy.prng.generators.PRNG;
import org.thejavaguy.prng.generators.R250;

/**
 * DataFile with cached content.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class CachedDataFile implements DataFile {
    /**
     * Initial number of lines for a file.
     */
    private static final int NUM_LINES = 10;
    /**
     * Underlying file with data.
     */
    private final File origin;
    /**
     * File content.
     */
    private final List<String> lines;
    /**
     * Random generator needed for obtaining random lines from file.
     */
    private final PRNG randomGenerator;

    /**
     * Primary constructor.
     * @param origin Wrapped DataFile
     */
    public CachedDataFile(final File origin, final PRNG randomGenerator) {
        this.origin = origin;
        this.lines = new ArrayList<>(NUM_LINES);
        this.randomGenerator = randomGenerator;
    }

    @Override
    public String randomLine() throws RandomDataException {
        if (this.lines.isEmpty()) {
            try (InputStream in = new FileInputStream(this.origin);
                Reader rdr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(rdr)) {
                for (;;) {
                    final String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    this.lines.add(line);
                }
            } catch (final IOException ex) {
                throw new RandomDataException(errorMessage(ex), ex);
            }
        }
        final int lineIndex = randomGenerator.nextInt(0, this.lines.size() - 1);
        return this.lines.get(lineIndex);
    }

    /**
     * Creates error message for given exception.
     * @param exc Exception to create error message for
     * @return Error message
     */
    private static String errorMessage(final Exception exc) {
        final StringBuilder ret = new StringBuilder();
        ret.append("Problem while opening or reading data file. ");
        ret.append("Underlying cause: ");
        ret.append(exc.getMessage());
        return ret.toString();
    }
}
