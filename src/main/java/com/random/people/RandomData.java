package com.random.people;

import java.util.Currency;
import java.util.Date;

/**
 * @author sasa - marinkovic.aleksandarr@gmail.com on 3/28/2016.
 */
public interface RandomData
{
  String namePrefix();
  String firstName();
  String lastName();
  String ssn();
  String gender();
  Date dateOfBirth();
  String address();
  String city();
  String state();
  String country();
  String phoneNumber();
  String nationality();
  Currency currency();
}
