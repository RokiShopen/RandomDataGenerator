package com.random.people.person.biological;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.random.people.CustomDoubleSerializer;
import com.random.people.person.biological.Blood;

public final class Traits {
    private final int height;
    private final int weight;
    private final int hairColor;
    private final int eyeColor;
    private final Blood blood;

    public Traits(int height, int weight, int hairColor, int eyeColor, Blood blood) {
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.blood = blood;
    }

    public int height() {
        return this.height;
    }

    public int weight() {
        return this.weight;
    }

    public int hairColor() {
        return this.hairColor;
    }

    public int eyeColor() {
        return this.eyeColor;
    }

    @JsonSerialize(using = CustomDoubleSerializer.class)
    public double bmi() {
        return weight / ((height / 100.0) * (height / 100.0));
    }

    public Blood blood() {
        return this.blood;
    }
}
