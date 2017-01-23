package com.spacewarfare;

import android.os.CountDownTimer;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;
import java.util.List;
import com.spacewarfare.Home.Planet;


public class userInfo {

    public String name;
    public String password;
    public int _id;
    public List<Planet> allPlanets;

    public final int START_MONEY = 1000000;

    public userInfo(String _name, String _password) {
        this.name = _name;
        this.password = _password;
        this._id = name.hashCode();
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

    public void firstPlanet(){
        Planet Earth = new Planet("Earth");
        allPlanets.add(Earth);
    }
}