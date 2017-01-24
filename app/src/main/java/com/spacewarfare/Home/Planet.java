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

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Planet {
    String name;
    List<Resource> allResources;
    public Map<String, Building> mapOfBuildings;
    public Map<String,Research> mapOfResearches;
    public Map<String,Ship> mapOfShips;
    public Map<String,Defense> mapOfDefenses;

    public Planet(String name) {
        this.name = name;

        //Create Buildings
        this.mapOfBuildings = new LinkedHashMap<String, Building>();
        Building Hangar = new Building("Hangar", "MISS", true, 1000, R.drawable.building_hangar);
        Building ResearchLab = new Building("Research Lab", "MISS", false, 30000, R.drawable.building_researchlab);
        Building NaniteFactory = new Building("Nanite Factory", "MISS", false, 50000, R.drawable.building_nanite);
        Building RobotFactory = new Building("Robot Factory", "MISS", false, 100000, R.drawable.building_robot);
        Building TimeMachine = new Building("Time Machine", "MISS", false, 1000000, R.drawable.building_timemachine);
        mapOfBuildings.put("Hangar", Hangar);
        mapOfBuildings.put("ResearchLab", ResearchLab);
        mapOfBuildings.put("NaniteFactory", NaniteFactory);
        mapOfBuildings.put("RobotFactory", RobotFactory);
        mapOfBuildings.put("TimeMachine", TimeMachine);

        //Create Researches
        this.mapOfResearches = new LinkedHashMap<String, Research>();
        Research AsteroidPhysics = new Research("Asteroid Physics", "MISS", true, 1000, R.drawable.research_asteroidphysics);
        Research BenitoiteAttracters = new Research("Benitoite Attracters", "MISS", false, 1000, R.drawable.research_benitoiteattracters);
        Research BenitoiteGatheringSpeed = new Research("Benitoite Gathering Speed", "MISS", false, 1000, R.drawable.research_benitoitegatheringspeed);
        Research CombustionMotors = new Research("Combustion Motors", "MISS", false, 1000, R.drawable.research_combustionmotors);
        Research DarkMatterTech = new Research("Dark Matter Tech", "MISS", false, 1000, R.drawable.research_darkmattertech);
        Research DeuteriumGatheringSpeed = new Research("Deuterium Gathering Speed", "MISS", false, 1000, R.drawable.research_deuteuriumgatheringspeed);
        Research IronGatheringSpeed = new Research("Iron Gathering Speed", "MISS", false, 1000, R.drawable.research_irongatheringspeed);
        Research IronMiner = new Research("Iron Miner", "MISS", false, 1000, R.drawable.research_ironminer);
        Research PlasmaTech = new Research("Plasma Tech", "MISS", false, 1000, R.drawable.research_plasmatech);
        Research PropulsionMotors = new Research("Propulsion Motors", "MISS", false, 1000, R.drawable.research_propulsionmotors);
        Research SilverGatheringRobot = new Research("Silver Gathering Robot", "MISS", false, 1000, R.drawable.research_silver_gathererrobot);
        Research SuperSonicMotor = new Research("Super Sonic Motor", "MISS", false, 1000, R.drawable.research_supersonicmotor);
        Research WeaponTech = new Research("Weapon Tech", "MISS", false, 1000, R.drawable.research_weapontech);
        mapOfResearches.put("AsteroidPhysics", AsteroidPhysics);
        mapOfResearches.put("BenitoiteAttracters", BenitoiteAttracters);
        mapOfResearches.put("BenitoiteGatheringSpeed", BenitoiteGatheringSpeed);
        mapOfResearches.put("CombustionMotors", CombustionMotors);
        mapOfResearches.put("DarkMatterTech", DarkMatterTech);
        mapOfResearches.put("DeuteriumGatheringSpeed", DeuteriumGatheringSpeed);
        mapOfResearches.put("IronGatheringSpeed", IronGatheringSpeed);
        mapOfResearches.put("IronMiner", IronMiner);
        mapOfResearches.put("PlasmaTech", PlasmaTech);
        mapOfResearches.put("PropulsionMotors", PropulsionMotors);
        mapOfResearches.put("SilverGatheringRobot", SilverGatheringRobot);
        mapOfResearches.put("SuperSonicMotor", SuperSonicMotor);
        mapOfResearches.put("WeaponTech", WeaponTech);

        //Create Ships
        this.mapOfShips = new LinkedHashMap<String, Ship>();
        Ship Messier = new Ship("Messier", "MISS", 3, 1000, R.drawable.ship_messier);
        Ship Mayal = new Ship("Mayal", "MISS", 0, 1000, R.drawable.ship_mayal);
        Ship Spyer = new Ship("Spyer", "MISS", 0, 1000, R.drawable.ship_spyer);
        Ship Colonizer = new Ship("Colnizerr", "MISS", 0, 1000, R.drawable.ship_colonizer);
        Ship Leviathan = new Ship("Leviathan", "MISS", 0, 1000, R.drawable.ship_leviathan);
        Ship Deathstar = new Ship("Deathstar", "MISS", 0, 1000, R.drawable.ship_deathstar);
        mapOfShips.put("Messier", Messier);
        mapOfShips.put("Mayal", Mayal);
        mapOfShips.put("Spyer", Spyer);
        mapOfShips.put("Colonizer", Colonizer);
        mapOfShips.put("Leviathan", Leviathan);
        mapOfShips.put("Deathstar", Deathstar);

        //Create Defenses
        this.mapOfDefenses = new LinkedHashMap<String, Defense>();
        Defense MissileLauncher = new Defense("Missile Launcher", "MISS", 1, 1000, R.drawable.defense_missilelauncher);
        Defense ResourceBunker = new Defense("Resource Bunker", "MISS", 0, 1000, R.drawable.defense_resourcebunker);
        Defense PlasmaCannon = new Defense("Plasma Cannon", "MISS", 0, 1000, R.drawable.defense_plasmacannon);
        Defense AntiAirRobot = new Defense("Anti Air Robot", "MISS", 0, 1000, R.drawable.defense_antiairrobot);
        Defense HeavyLaser = new Defense("Heavy Laser", "MISS", 0, 1000, R.drawable.defense_heavylaser);
        mapOfDefenses.put("MissileLauncher", MissileLauncher);
        mapOfDefenses.put("ResourceBunker", ResourceBunker);
        mapOfDefenses.put("PlasmaCannon", PlasmaCannon);
        mapOfDefenses.put("AntiAirRobot", AntiAirRobot);
        mapOfDefenses.put("HeavyLaser", HeavyLaser);

        /*
        public List<Research> allResearch;
        this.allResearch = new ArrayList<>();
        allResearch.add(AsteroidPhysics);
        allResearch.add(BenitoiteAttracters);
        allResearch.add(BenitoiteGatheringSpeed);
        allResearch.add(CombustionMotors);
        allResearch.add(DarkMatterTech);
        allResearch.add(DeuteriumGatheringSpeed);
        allResearch.add(IronGatheringSpeed);
        allResearch.add(IronMiner);
        allResearch.add(PlasmaTech);
        allResearch.add(PropulsionMotors);
        allResearch.add(SilverGatheringRobot);
        allResearch.add(SuperSonicMotor);
        allResearch.add(WeaponTech);

        public List<Ship> allShips;
        this.allShips = new ArrayList<>();
        allShips.add(Messier);
        allShips.add(Mayal);
        allShips.add(Spyer);
        allShips.add(Colonizer);
        allShips.add(Leviathan);
        allShips.add(Deathstar);

        public List<Defense> allDefenses;
        this.allDefenses = new ArrayList<>();
        allDefenses.add(MissileLauncher);
        allDefenses.add(ResourceBunker);
        allDefenses.add(PlasmaCannon);
        allDefenses.add(AntiAirRobot);
        allDefenses.add(HeavyLaser);
        */
    }
}

