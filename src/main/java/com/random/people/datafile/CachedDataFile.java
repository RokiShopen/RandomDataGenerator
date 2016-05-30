package com.random.people.datafile;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Milosavljevic imilosavljevic@novomaticls.com
 */
public class CachedDataFile implements DataFile {
    private final DataFile origin;
    private final List<String> lines;

    public CachedDataFile(DataFile origin) {
        this.origin = origin;
        this.lines = new ArrayList<>();
    }

    @Override
    public String randomLine() {
        if (lines.isEmpty()) {
            //TODO read all from file
        }
        //TODO return random line
        throw new NotImplementedException();
    }
}
