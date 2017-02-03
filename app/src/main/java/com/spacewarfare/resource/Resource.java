package com.spacewarfare.resource;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Resource {
    public int key;
    public String name;
    public String description;
    public int image;
    public int startPrice;
    public int level;
    public double startEfficiency;
    public int secondsTimer;
    public int priceLevel;

    public Resource(int key, String name, double startEfficiency, int startPrice, int level, int secondsTimer, int image, String description) {
        this.key = key;
        this.name = name;
        this.secondsTimer = secondsTimer;
        this.startEfficiency = startEfficiency;
        this.startPrice = startPrice;
        this.level = level;
        this.image = image;
        this.description = description;
        this.priceLevel = startPrice;
    }

    public void setLevelTransition(){
        this.priceLevel = (int) (this.startPrice * Math.pow(3, this.level));
        this.startEfficiency =+ 0.05;
    }
}
