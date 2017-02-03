package com.spacewarfare.defense;

import com.spacewarfare.others.Stats;

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
    public Stats stats;

    public Defense(int key, String name, Stats stats, int quantity, int price, int image, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.stats = stats;
    }
}
