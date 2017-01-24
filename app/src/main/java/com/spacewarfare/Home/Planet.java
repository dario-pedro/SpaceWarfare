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
    public List<Research> allResearch;
    public List<Ship> allShips;
    public List<Defense> allDefenses;

    public Planet(String name) {
        this.name = name;

        this.allBuildings = new ArrayList<>();
        //Create Buildings to test
        Building Hangar = new Building("Hangar", "MISS", true, 1000, R.drawable.building_hangar);
        Building ResearchLab = new Building("Research Lab", "MISS", false, 30000, R.drawable.building_researchlab);
        Building NaniteFactory = new Building("Nanite Factory", "MISS", false, 50000, R.drawable.building_nanite);
        Building RobotFactory = new Building("Robot Factory", "MISS", false, 100000, R.drawable.building_robot);
        Building TimeMachine = new Building("Time Machine", "MISS", false, 1000000, R.drawable.building_timemachine);
        allBuildings.add(Hangar);
        allBuildings.add(ResearchLab);
        allBuildings.add(NaniteFactory);
        allBuildings.add(RobotFactory);
        allBuildings.add(TimeMachine);

        this.allResearch = new ArrayList<>();
        //Create Researches to test
        Research AsteroidPhysics = new Research("Asteroid Physics", "MISS", true, 1000, R.drawable.research_asteroidphysics);
        Research BenitoiteAttracters = new Research("Benitoite Attracters", "MISS", false, 1000, R.drawable.research_benitoiteattracters);
        Research BenitoiteGatheringSpeed = new Research("Benitoite Gathering Speed", "MISS", false, 1000, R.drawable.research_benitoitegatheringspeed);
        Research CombustionMotors = new Research("Combustion Motors", "MISS", false, 1000, R.drawable.research_combustionmotors);
        Research DarkMatterTech = new Research("Dark Matter Tech", "MISS", false, 1000, R.drawable.research_darkmattertech);
        Research DeuteriumGatheringSpeed = new Research("Deuterium Gathering Speed", "MISS", false, 1000, R.drawable.research_deuteuriumgatheringspeed);
        Research IronGatheringSpeed = new Research("Iron Gathering Speed", "MISS", false, 1000, R.drawable.research_irongatheringspeed);
        Research IronMiner = new Research("Iron Miner", "MISS", false, 1000, R.drawable.research_ironminer);
        allResearch.add(AsteroidPhysics);
        allResearch.add(BenitoiteAttracters);
        allResearch.add(BenitoiteGatheringSpeed);
        allResearch.add(CombustionMotors);
        allResearch.add(DarkMatterTech);
        allResearch.add(DeuteriumGatheringSpeed);
        allResearch.add(IronGatheringSpeed);
        allResearch.add(IronMiner);

        this.allDefenses = new ArrayList<>();
        //Create Defenses to test
        Defense MissileLauncher = new Defense("Missile Launcher", "MISS", 1, 1000, R.drawable.defense_missilelauncher);
        Defense ResourceBunker = new Defense("Resource Bunker", "MISS", 0, 1000, R.drawable.defense_resourcebunker);
        Defense PlasmaCannon = new Defense("Plasma Cannon", "MISS", 0, 1000, R.drawable.defense_plasmacannon);
        Defense AntiAirRobot = new Defense("Anti Air Robot", "MISS", 0, 1000, R.drawable.defense_antiairrobot);
        Defense HeavyLaser = new Defense("Heavy Laser", "MISS", 0, 1000, R.drawable.defense_heavylaser);
        allDefenses.add(MissileLauncher);
        allDefenses.add(ResourceBunker);
        allDefenses.add(PlasmaCannon);
        allDefenses.add(AntiAirRobot);
        allDefenses.add(HeavyLaser);

        this.allShips = new ArrayList<>();
        //Create Ships to test
        Ship Messier = new Ship("Messier", "MISS", 3, 1000, R.drawable.ship_messier);
        Ship Mayal = new Ship("Mayal", "MISS", 0, 1000, R.drawable.ship_mayal);
        Ship Spyer = new Ship("Spyer", "MISS", 0, 1000, R.drawable.ship_spyer);
        Ship Colonizer = new Ship("Colnizerr", "MISS", 0, 1000, R.drawable.ship_colonizer);
        Ship Leviathan = new Ship("Leviathan", "MISS", 0, 1000, R.drawable.ship_leviathan);
        Ship Deathstar = new Ship("Deathstar", "MISS", 0, 1000, R.drawable.ship_deathstar);
        allShips.add(Messier);
        allShips.add(Mayal);
        allShips.add(Spyer);
        allShips.add(Colonizer);
        allShips.add(Leviathan);
        allShips.add(Deathstar);
    }
}

