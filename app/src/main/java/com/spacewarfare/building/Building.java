package com.spacewarfare.building;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Building {
    public int key;
    public String name;
    public String description;
    public int image;
    public int startPrice;
    public int level;
    public int priceLevel;

    public Building(int key, String name, String description, int level, int price, int image) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.startPrice = price;
        this.image = image;
        this.level = level;
        this.priceLevel = price;
    }

    public void setLevelTransition(){
        this.level++;
        this.priceLevel = (int) (this.startPrice * Math.pow(3, this.level));
    }
}
