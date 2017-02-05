package com.spacewarfare.resource;

import static java.lang.Math.round;

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
    public double efficiencyLevel;
    public int secondsTimer;
    public long priceLevel;
    public int crystalsLevel;

    public Resource(int key, String name, double efficiencyLevel, int startPrice, int level, int secondsTimer, int image, String description) {
        this.key = key;
        this.name = name;
        this.secondsTimer = secondsTimer;
        this.efficiencyLevel = efficiencyLevel;
        this.startPrice = startPrice;
        this.level = level;
        this.image = image;
        this.description = description;
        this.priceLevel = startPrice;
        this.crystalsLevel = (int) (10*secondsTimer*efficiencyLevel);
    }

    public void setLevelTransition(){
        this.level++;
        this.priceLevel = (long) (this.priceLevel * Math.pow(2, this.level));
        this.efficiencyLevel += 0.05;
        this.crystalsLevel = (int) Math.round(10*secondsTimer*efficiencyLevel);
    }
}
