package com.spacewarfare.Defense;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Defense {
    public String name;
    public String info;
    public int quantity;
    public int image;
    public int price;

    public Defense(String name, String info, int quantity, int price, int image) {
        this.name = name;
        this.info= info;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }
}
