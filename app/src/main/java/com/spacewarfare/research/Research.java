package com.spacewarfare.Research;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class Research {
    public String name;
    public String info;
    public boolean owned;
    public int image;
    public int price;

    public Research(String name, String info, boolean owned, int price, int image) {
        this.name = name;
        this.info = info;
        this.owned = owned;
        this.price = price;
        this.image = image;
    }
}
