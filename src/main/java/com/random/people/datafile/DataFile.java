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

/**
 * Interface for DataFiles.
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface DataFile {
    /**
     * Returns random line from file.
     * @return Random line from file
     * @throws RandomDataException if there is some problem while working with
     *  file
     */
    String randomLine() throws RandomDataException;
    /**
     * Returns specific line from file.
     * @param index Index of line which should be read
     * @return Specific line from file
     * @throws RandomDataException if there is some problem while working with
     *  file
     */
    String specificLine(int index) throws RandomDataException;
}
