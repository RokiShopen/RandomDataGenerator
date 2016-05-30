package com.random.people.datafile;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;

/**
 * @author Ivan Milosavljevic imilosavljevic@novomaticls.com
 */
public class DefaultDataFile implements DataFile {
    private final File origin;

    public DefaultDataFile(Name name) {
        this(
                new File(
                        Thread.currentThread()
                                .getContextClassLoader()
                                .getResource(name.name()).getFile()
                )
        );
    }

    public DefaultDataFile(File origin) {
        this.origin = origin;
    }

    @Override
    public String randomLine() {
        throw new NotImplementedException();
    }
}
