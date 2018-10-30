package com.random.people.person;

import com.random.people.person.personal.Birthday;
import com.random.people.person.personal.Contact;
import com.random.people.person.personal.MaritalStatus;
import com.random.people.person.personal.PersonName;
import com.random.people.person.biological.Traits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class Person {
    private PersonName personName;
    private Birthday birthday;
    private Contact contact;
    private MaritalStatus status;
    private Traits traits;
    private String id;
}
