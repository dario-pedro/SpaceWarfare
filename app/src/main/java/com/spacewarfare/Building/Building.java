package com.spacewarfare.Building;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Building {
    public int key;
    public String name;
    public String info;
    public boolean owned;
    public int image;
    public int price;

    public Building(int key, String name, String info, boolean owned, int price, int image) {
        this.key = key;
        this.name = name;
        this.info= info;
        this.owned = owned;
        this.price = price;
        this.image = image;
    }
}
