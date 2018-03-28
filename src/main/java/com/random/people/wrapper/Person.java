package com.random.people.wrapper;

import com.random.people.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Currency;

@Data
@Builder
public class Person {

    String namePrefix;
    String firstName;
    String lastName;
    String ssn;
    Gender gender;
    LocalDate dateOfBirth;
    Address address;
    String phoneNumber;
    String nationality;
    Currency currency;
}
