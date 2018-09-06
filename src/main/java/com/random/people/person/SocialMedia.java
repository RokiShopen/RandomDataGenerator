package com.random.people.person;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public class SocialMedia {
    private String facebook;
    
    @JsonGetter
    public String facebook() {
        return "http://facebook.com/travoltaizborcegrede";
    }
}
