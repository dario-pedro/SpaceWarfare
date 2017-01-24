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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Planet {
    String name;
    List<Resource> allResources;
    public List<Building> allBuildings;
    List<Research> allResearch;
    List<Ship> allShips;
    List<Defense> allDefenses;

    public Planet(String name) {
        this.name = name;
        this.allBuildings = new ArrayList<>();
        //Create Buildings to test
        Building Hangar = new Building("Hangar", "Cheap", true, 1000, R.drawable.building_hangar);
        Building ResearchLab = new Building("Research Lab", "Expensive", false, 30000, R.drawable.building_researchlab);
        Building Hangar2 = new Building("Hangar2", "Cheap", true, 1000, R.drawable.building_hangar);
        Building ResearchLab2 = new Building("Research Lab2", "Expensive", false, 30000, R.drawable.building_researchlab);
        Building Hangar3 = new Building("Hangar3", "Cheap", true, 1000, R.drawable.building_hangar);
        Building ResearchLab3 = new Building("Research Lab3", "Expensive", false, 30000, R.drawable.building_researchlab);
        allBuildings.add(Hangar);
        allBuildings.add(ResearchLab);
        allBuildings.add(Hangar2);
        allBuildings.add(ResearchLab2);
        allBuildings.add(Hangar3);
        allBuildings.add(ResearchLab3);
    }
}

