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
        this.allBuildings = new ArrayList<>();
        //Create Buildings to test
        Building Hangar = new Building("Hangar", "Cheap", true, 1000, R.drawable.building_hangar);
        Building ResearchLab = new Building("Research Lab", "Expensive", false, 30000, R.drawable.building_researchlab);
        Building NaniteFactory = new Building("Nanite Factory", "Cheap", false, 50000, R.drawable.building_nanite);
        Building RobotFactory = new Building("Robot Factory", "Expensive", false, 100000, R.drawable.building_robot);
        Building TimeMachine = new Building("Time Machine", "Cheap", false, 1000000, R.drawable.building_timemachine);
        allBuildings.add(Hangar);
        allBuildings.add(ResearchLab);
        allBuildings.add(NaniteFactory);
        allBuildings.add(RobotFactory);
        allBuildings.add(TimeMachine);
    }
}

