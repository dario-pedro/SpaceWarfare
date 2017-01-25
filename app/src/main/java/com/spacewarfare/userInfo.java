package com.spacewarfare;

import android.os.CountDownTimer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.List;
import com.spacewarfare.Home.Planet;


public class UserInfo {

    public String name;
    public String password;
    public int _id;
    public List<Planet> allPlanets;
    public int money;

    public UserInfo(String _name, String _password) {
        this.name = _name;
        this.password = _password;
        this._id = name.hashCode();
        this.allPlanets = new ArrayList<>();
        this.money = 1000000;
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
        this.allPlanets.add(Earth);
    }
}