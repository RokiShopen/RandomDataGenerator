/**
 *
 */
package com.random.people;

import java.util.Currency;
import java.util.Date;

/**
 * @author Sasa - marinkovic.aleksandarr@gmail.com on 3/28/2016.
 * @version
 * @since
 */
public interface RandomData {
    /**
     *
     * @return
     */
    String namePrefix();

    /**
     *
     * @return
     */
    String firstName();

    /**
     *
     * @return
     */
    String lastName();

    /**
     *
     * @return
     */
    String ssn();

    /**
     *
     * @return
     */
    String gender();

    /**
     *
     * @return
     */
    Date dateOfBirth();

    /**
     *
     * @return
     */
    String address();

    /**
     *
     * @return
     */
    String city();

    /**
     *
     * @return
     */
    String state();

    /**
     *
     * @return
     */
    String country();

    /**
     *
     * @return
     */
    String phoneNumber();

    /**
     *
     * @return
     */
    String nationality();

    /**
     *
     * @return
     */
    Currency currency();
}
