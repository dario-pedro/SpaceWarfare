package com.spacewarfare.Home;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

import com.spacewarfare.R;
import com.spacewarfare.Resource.Resource;
import com.spacewarfare.Building.Building;
import com.spacewarfare.Research.Research;
import com.spacewarfare.Ship.Ship;
import com.spacewarfare.Defense.Defense;

import java.util.HashMap;
import java.util.List;

public class Planet {
    String name;
    List<Resource> allResources;
    public List<Building> allBuildings;
    List<Research> allResearch;
    List<Ship> allShips;
    List<Defense> allDefenses;

    public Planet(String name) {
        this.name = name;

        //Create Buildings to test
        Building Hangar = new Building("Hangar", "Cheap", false, 1000, 0);
        Building SpatialStation = new Building("SpatialStation", "Expensive", false, 9999, 0);
        allBuildings.add(Hangar);
        allBuildings.add(SpatialStation);
    }
}

