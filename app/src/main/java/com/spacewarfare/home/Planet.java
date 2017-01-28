package com.spacewarfare.home;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

import com.spacewarfare.R;
import com.spacewarfare.resource.Resource;
import com.spacewarfare.building.Building;
import com.spacewarfare.research.Research;
import com.spacewarfare.ship.Ship;
import com.spacewarfare.defense.Defense;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Planet {
    String name;
    List<Resource> allResources;
    public Map<Integer, Building> mapOfBuildings;
    public Map<Integer, Research> mapOfResearches;
    public Map<Integer,Ship> mapOfShips;
    public Map<Integer,Defense> mapOfDefenses;

    public Planet(String name) {
        this.name = name;

        //Create Buildings
        this.mapOfBuildings = new LinkedHashMap<Integer, Building>();
        Building Hangar = new Building(R.string.key_Building_Hangar, "Hangar", "MISS", false, 1000, R.drawable.building_hangar);
        Building Hangar2 = new Building(R.string.key_Building_Hangar2, "Hangar2", "MISS", false, 2000, R.drawable.building_hangar);
        Building Hangar3 = new Building(R.string.key_Building_Hangar3, "Hangar3", "MISS", false, 3000, R.drawable.building_hangar);
        Building ResearchLab = new Building(R.string.key_Building_ResearchLab, "Research Lab", "MISS", false, 30000, R.drawable.building_researchlab);
        Building NaniteFactory = new Building(R.string.key_Building_NaniteFactory, "Nanite Factory", "MISS", false, 50000, R.drawable.building_nanite);
        Building RobotFactory = new Building(R.string.key_Building_RobotFactory, "Robot Factory", "MISS", false, 100000, R.drawable.building_robot);
        Building TimeMachine = new Building(R.string.key_Building_TimeMachine, "Time Machine", "MISS", false, 1000000, R.drawable.building_timemachine);
        mapOfBuildings.put(R.string.key_Building_Hangar, Hangar);
        mapOfBuildings.put(R.string.key_Building_Hangar2, Hangar2);
        mapOfBuildings.put(R.string.key_Building_Hangar3, Hangar3);
        mapOfBuildings.put(R.string.key_Building_ResearchLab, ResearchLab);
        mapOfBuildings.put(R.string.key_Building_NaniteFactory, NaniteFactory);
        mapOfBuildings.put(R.string.key_Building_RobotFactory, RobotFactory);
        mapOfBuildings.put(R.string.key_Building_TimeMachine, TimeMachine);

        //Create Researches
        this.mapOfResearches = new LinkedHashMap<Integer, Research>();
        Research AsteroidPhysics = new Research(R.string.key_Research_AsteroidPhysics, "Asteroid Physics", "MISS", false, 1000, R.drawable.research_asteroidphysics);
        Research BenitoiteAttracters = new Research(R.string.key_Research_BenitoiteAttracters, "Benitoite Attracters", "MISS", false, 1000, R.drawable.research_benitoiteattracters);
        Research BenitoiteGatheringSpeed = new Research(R.string.key_Research_BenitoiteGatheringSpeed, "Benitoite Gathering Speed", "MISS", false, 1000, R.drawable.research_benitoitegatheringspeed);
        Research CombustionMotors = new Research(R.string.key_Research_CombustionMotors, "Combustion Motors", "MISS", false, 1000, R.drawable.research_combustionmotors);
        Research DarkMatterTech = new Research(R.string.key_Research_DarkMatterTech, "Dark Matter Tech", "MISS", false, 1000, R.drawable.research_darkmattertech);
        Research DeuteriumGatheringSpeed = new Research(R.string.key_Research_DeuteriumGatheringSpeed, "Deuterium Gathering Speed", "MISS", false, 1000, R.drawable.research_deuteuriumgatheringspeed);
        Research IronGatheringSpeed = new Research(R.string.key_Research_IronGatheringSpeed, "Iron Gathering Speed", "MISS", false, 1000, R.drawable.research_irongatheringspeed);
        Research IronMiner = new Research(R.string.key_Research_IronMiner, "Iron Miner", "MISS", false, 1000, R.drawable.research_ironminer);
        Research PlasmaTech = new Research(R.string.key_Research_PlasmaTech, "Plasma Tech", "MISS", false, 1000, R.drawable.research_plasmatech);
        Research PropulsionMotors = new Research(R.string.key_Research_PropulsionMotors, "Propulsion Motors", "MISS", false, 1000, R.drawable.research_propulsionmotors);
        Research SilverGatheringRobot = new Research(R.string.key_Research_SilverGatheringRobot, "Silver Gathering Robot", "MISS", false, 1000, R.drawable.research_silver_gathererrobot);
        Research SuperSonicMotor = new Research(R.string.key_Research_SuperSonicMotor, "Super Sonic Motor", "MISS", false, 1000, R.drawable.research_supersonicmotor);
        Research WeaponTech = new Research(R.string.key_Research_WeaponTech, "Weapon Tech", "MISS", false, 1000, R.drawable.research_weapontech);
        mapOfResearches.put(R.string.key_Research_AsteroidPhysics, AsteroidPhysics);
        mapOfResearches.put(R.string.key_Research_BenitoiteAttracters, BenitoiteAttracters);
        mapOfResearches.put(R.string.key_Research_BenitoiteGatheringSpeed, BenitoiteGatheringSpeed);
        mapOfResearches.put(R.string.key_Research_CombustionMotors, CombustionMotors);
        mapOfResearches.put(R.string.key_Research_DarkMatterTech, DarkMatterTech);
        mapOfResearches.put(R.string.key_Research_DeuteriumGatheringSpeed, DeuteriumGatheringSpeed);
        mapOfResearches.put(R.string.key_Research_IronGatheringSpeed, IronGatheringSpeed);
        mapOfResearches.put(R.string.key_Research_IronMiner, IronMiner);
        mapOfResearches.put(R.string.key_Research_PlasmaTech, PlasmaTech);
        mapOfResearches.put(R.string.key_Research_PropulsionMotors, PropulsionMotors);
        mapOfResearches.put(R.string.key_Research_SilverGatheringRobot, SilverGatheringRobot);
        mapOfResearches.put(R.string.key_Research_SuperSonicMotor, SuperSonicMotor);
        mapOfResearches.put(R.string.key_Research_WeaponTech, WeaponTech);

        //Create Ships
        this.mapOfShips = new LinkedHashMap<Integer, Ship>();
        Ship Messier = new Ship("Messier", "MISS", 3, 1000, R.drawable.ship_messier);
        Ship Mayal = new Ship("Mayal", "MISS", 0, 1000, R.drawable.ship_mayal);
        Ship Spyer = new Ship("Spyer", "MISS", 0, 1000, R.drawable.ship_spyer);
        Ship Colonizer = new Ship("Colonizer", "MISS", 0, 1000, R.drawable.ship_colonizer);
        Ship Leviathan = new Ship("Leviathan", "MISS", 0, 1000, R.drawable.ship_leviathan);
        Ship Deathstar = new Ship("Deathstar", "MISS", 0, 1000, R.drawable.ship_deathstar);
        mapOfShips.put(R.string.key_Ship_Messier, Messier);
        mapOfShips.put(R.string.key_Ship_Mayal, Mayal);
        mapOfShips.put(R.string.key_Ship_Spyer, Spyer);
        mapOfShips.put(R.string.key_Ship_Colonizer, Colonizer);
        mapOfShips.put(R.string.key_Ship_Leviathan, Leviathan);
        mapOfShips.put(R.string.key_Ship_Deathstar, Deathstar);

        //Create Defenses
        this.mapOfDefenses = new LinkedHashMap<Integer, Defense>();
        Defense MissileLauncher = new Defense("Missile Launcher", "MISS", 1, 1000, R.drawable.defense_missilelauncher);
        Defense ResourceBunker = new Defense("Resource Bunker", "MISS", 0, 1000, R.drawable.defense_resourcebunker);
        Defense PlasmaCannon = new Defense("Plasma Cannon", "MISS", 0, 1000, R.drawable.defense_plasmacannon);
        Defense AntiAirRobot = new Defense("Anti Air Robot", "MISS", 0, 1000, R.drawable.defense_antiairrobot);
        Defense HeavyLaser = new Defense("Heavy Laser", "MISS", 0, 1000, R.drawable.defense_heavylaser);
        mapOfDefenses.put(R.string.key_Defense_MissileLauncher, MissileLauncher);
        mapOfDefenses.put(R.string.key_Defense_ResourceBunker, ResourceBunker);
        mapOfDefenses.put(R.string.key_Defense_PlasmaCannon, PlasmaCannon);
        mapOfDefenses.put(R.string.key_Defense_AntiAirRobot, AntiAirRobot);
        mapOfDefenses.put(R.string.key_Defense_HeavyLaser, HeavyLaser);

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

