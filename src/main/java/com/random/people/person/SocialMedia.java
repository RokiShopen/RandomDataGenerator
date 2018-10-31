package com.random.people.person;

import com.random.people.person.personal.Birthday;
import com.random.people.person.personal.PersonName;
import org.thejavaguy.prng.generators.PRNG;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
@JsonIgnoreProperties(value = {"birthday", "name", "rng"})
public class SocialMedia {
    private final Birthday birthday;
    private final PersonName name;
    private final PRNG.Smart rng;

    public SocialMedia(Birthday birthday, PersonName name, PRNG.Smart rng) {
        this.birthday = birthday;
        this.name = name;
        this.rng = rng;
    }

    @JsonGetter
    public String facebook() {
        final int MIN_LENGTH = 5;
        final int MAX_LENGTH = 50;
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0))
        .append(hasDot() ? '.' : "")
        .append(name.lastNames().get(0))
        .append(hasNumbers() ? birthYear() : "");
        return String.format("https://www.facebook.com/%s",
                shortened(username.toString(), MAX_LENGTH));
    }

    @JsonGetter
    public String twitter() {
        //small, caps, underscore, number
        final int MIN_LENGTH = 1;
        final int MAX_LENGTH = 15;
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0))
        .append(hasDot() ? '.' : "")
        .append(name.lastNames().get(0))
        .append(hasUnderscore() ? '_' : "")
        .append(hasNumbers() ? birthYear() : "");
        return String.format("https://twitter.com/%s",
                shortened(username.toString(), MAX_LENGTH));
    }

    @JsonGetter
    public String instagram() {
        //small, numbers, dot, underscore
        final int MIN_LENGTH = 1;
        final int MAX_LENGTH = 30;
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0).toLowerCase())
        .append(hasDot() ? '.' : "")
        .append(name.lastNames().get(0).toLowerCase())
        .append(hasUnderscore() ? '_' : "")
        .append(hasNumbers() ? birthYear() : "");
        return String.format("https://instagram.com/%s",
                shortened(username.toString(), MAX_LENGTH));
    }
    
    @JsonGetter
    public String pinterest() {
        //small, numbers
        final int MIX_LENGTH = 3;
        final int MAX_LENGTH = 30;
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0).toLowerCase())
        .append(name.lastNames().get(0).toLowerCase())
        .append(hasNumbers() ? birthYear() : "");
        return String.format("https://www.pinterest.com/%s",
                shortened(username.toString(), MAX_LENGTH));
    }

    @JsonGetter
    public String mastodon() {
        //small, caps, underscore, letter
        final int MIX_LENGTH = 2;
        final int MAX_LENGTH = 30;
        final String[] federations = {"mastodon.social", "route66.social",
                "todon.nl", "mastodon.cloud", "pawoo.net", "mastodon.xyz",
                "fosstodon.org"};
        final String federation = federations[this.rng.nextInt(federations.length - 1)];    
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0).toLowerCase())
        .append(hasUnderscore() ? '_' : "")
        .append(name.lastNames().get(0).toLowerCase());
        return String.format("https://%s/%s",
                federation,
                shortened(username.toString(), MAX_LENGTH));
    }

    @JsonGetter
    public String linkedin() {
        //letters, numbers
        final int MIX_LENGTH = 5;
        final int MAX_LENGTH = 30;
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0))
        .append(name.lastNames().get(0))
        .append(hasNumbers() ? birthYear() : "");
        return String.format("https://www.linkedin.com/in/%s",
                shortened(username.toString(), MAX_LENGTH));
    }

    @JsonGetter
    public String xing() {
        StringBuilder username = new StringBuilder();
        username
        .append(name.givenNames().get(0))
        .append('_')
        .append(name.lastNames().get(0))
        .append(hasNumbers() ? birthYear() : "");
        return "https://www.xing.com/profile/travolta_iz_borce_grede";
    }
    
    private boolean hasDot() {
        return this.rng.nextInt(1, 100) <= 2;
    }
    
    private boolean hasUnderscore() {
        return this.rng.nextInt(1, 100) <= 2;
    }
    
    private boolean hasNumbers() {
        return this.rng.nextInt(1, 100) <= 10;
    }
    
    private String birthYear() {
        return this.rng.nextBoolean() ? birthYear2() : birthYear4();
    }
    
    private String birthYear2() {
        return birthYear4().substring(2);
    }
    
    private String birthYear4() {
        return String.valueOf(this.birthday.getBirthDate().getYear());
    }
    
    private String shortened(final String origin, final int maxLength) {
        if (origin != null && origin.length() > maxLength) {
            return origin.substring(0, maxLength);
        } else {
            return origin;
        }
    }
}
