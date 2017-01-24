package com.spacewarfare.Building;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Building {
    public String name;
    public String info;
    public boolean owned;
    public int image;
    public int price;

    public Building(String name, String info, boolean owned, int price, int image) {
        this.name = name;
        this.info= info;
        this.owned = owned;
        this.price = price;
        this.image = image;
    }
}
