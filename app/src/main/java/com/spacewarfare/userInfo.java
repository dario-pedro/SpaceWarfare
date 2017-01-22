package com.spacewarfare;

import android.os.CountDownTimer;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;

public class userInfo {

    public String name;
    public String password;
    public int _id;

    public final int START_MONEY = 1000000;

    public userInfo(String _name, String _password) {
        this.name = _name;
        this.password = _password;
        this._id = name.hashCode();
    }

    private String FirstPlanetRandomName() {
        Random rand = new Random();
        int n = rand.nextInt(17); // Gives n such that 0 <= n < 16
        switch (n) {
            case 0:
                return "Cygni";
            case 1:
                return "Herculis";
            case 2:
                return "Gliese";
            case 3:
                return "Andromedae";
            case 4:
                return "Pegasi";
            case 5:
                return "Piscium";
            case 6:
                return "Kepleror";
            case 7:
                return "Oglerium";
            case 8:
                return "Welwitschia";
            case 9:
                return "Valahar";
            case 10:
                return "Rumplerdor";
            case 11:
                return "Breakeish";
            case 12:
                return "Martorm";
            case 13:
                return "Largathj";
            case 14:
                return "Youblerc";
            case 15:
                return "Farglir";
            case 16:
                return "Enckeim";
            default:
                return "Default";
        }
    }

    public String get_password() {
        return password;
    }

    public void set_password(String _password) {
        this.password = _password;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this.name = _name;
    }

    public String get_name() {
        return name;
    }
}