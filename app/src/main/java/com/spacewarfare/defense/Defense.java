package com.spacewarfare.defense;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Defense {
    public int key;
    public String name;
    public String description;
    public int quantity;
    public int image;
    public int price;

    public Defense(int key, String name, String description, int quantity, int price, int image) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }
}
