package com.spacewarfare.Building;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Building {
    public String name;
    public String infoBuilding;
    public boolean owned;
    public int image;
    public int price;

    public Building(String name, String infoBuilding, boolean owned, int price, int image) {
        this.name = name;
        this.infoBuilding = infoBuilding;
        this.owned = owned;
        this.price = price;
        this.image = image;
    }
}
