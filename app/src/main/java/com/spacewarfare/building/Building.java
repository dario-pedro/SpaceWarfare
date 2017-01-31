package com.spacewarfare.building;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Building {
    public int key;
    public String name;
    public String description;
    public int image;
    public int price;
    public int level;

    public Building(int key, String name, String description, int level, int price, int image) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.level = level;
    }
}
