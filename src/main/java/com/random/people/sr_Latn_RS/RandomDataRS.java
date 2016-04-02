package com.random.people.sr_Latn_RS;

import com.random.people.RandomData;

import java.io.*;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * @author sasa - marinkovic.aleksandarr@gmail.com on 3/28/2016.
 */
public class RandomDataRS implements RandomData
{
  public static void main(String[] args) throws IOException
  {
    Locale aLocale = new Locale("sr", "RS", "Latn");
    System.out.println("Name of Locale: "+aLocale.getDisplayName());
    System.out.println("Language Code: "+aLocale.getLanguage()+", Language Display Name: "+aLocale.getDisplayLanguage());
    System.out.println("Country Code: "+aLocale.getCountry()+", Country Display Name: "+aLocale.getDisplayCountry());
    if(!aLocale.getScript().equals("")){
      System.out.println("Script Code: "+aLocale.getScript()+", Script Display Name: "+aLocale.getDisplayScript());
    }
    if(!aLocale.getVariant().equals("")){
      System.out.println("Variant Code: "+aLocale.getVariant()+", Variant Display Name: "+aLocale.getDisplayVariant());
    }

    ClassLoader classLoader = RandomDataRS.class.getClassLoader();
    File file = new File(classLoader.getResource("sr_Latn_RS/firstNameFemale.txt").getFile());
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    for (; ;)
    {
      String line = bufferedReader.readLine();
      if (line == null)
      {
        break;
      }
      System.out.println(line);
    }

  }

  public String namePrefix()
  {
    return null;
  }

  public String firstName()
  {
    return null;
  }

  public String lastName()
  {
    return null;
  }

  public String ssn()
  {
    return null;
  }

  public String gender()
  {
    return null;
  }

  public Date dateOfBirth()
  {
    return null;
  }

  public String address()
  {
    return null;
  }

  public String city()
  {
    return null;
  }

  public String state()
  {
    return null;
  }

  public String country()
  {
    return null;
  }

  public String phoneNumber()
  {
    return null;
  }

  public String nationality()
  {
    return null;
  }

  public Currency currency()
  {
    return null;
  }
}
