package com.random.people.person;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class CountryCodes {
    private int phone;
    private int[] mobile;
    private String isoAlpha2;
    private String isoAlpha3;

    public CountryCodes(int phone, int[] mobile, String isoAlpha2, String isoAlpha3) {
        this.phone = phone;
        this.mobile = new int[mobile.length];
        System.arraycopy(mobile, 0, this.mobile, 0, mobile.length);
        this.isoAlpha2 = isoAlpha2;
        this.isoAlpha3 = isoAlpha3;
    }

    public int phone() {
        return this.phone;
    }

    public int[] mobile() {
        int[] ret = new int[this.mobile.length];
        System.arraycopy(this.mobile, 0, ret, 0, this.mobile.length);
        return ret;
    }

    public String isoAlpha2() {
        return this.isoAlpha2;
    }

    public String isoAlpha3() {
        return this.isoAlpha3;
    }
}
