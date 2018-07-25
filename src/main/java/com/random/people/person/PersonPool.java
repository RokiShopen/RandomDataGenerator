package com.random.people.person;

import com.random.people.RandomDataException;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public interface PersonPool {
    Person next() throws RandomDataException;
}
