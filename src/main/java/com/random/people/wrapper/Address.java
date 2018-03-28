package com.random.people.wrapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    String number;
    String street;
    String city;
    String state;
    String country;
    String postalCode;
}
