package com.random.people.person;

public final class Traits {
    private final int height;
    private final int weight;
    private final int hairColor;
    private final int eyeColor;
    
    public Traits(int height, int weight, int hairColor, int eyeColor) {
        this.height = height;
        this.weight = weight;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
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
}
