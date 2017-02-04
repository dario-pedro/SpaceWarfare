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
import com.spacewarfare.others.Stats;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Planet {
    public static final int min = 60;
    public static final int hour = 3600;
    String name;
    public Map<Integer, Resource> mapOfResources;
    public Map<Integer, Building> mapOfBuildings;
    public Map<Integer, Research> mapOfResearches;
    public Map<Integer,Ship> mapOfShips;
    public Map<Integer,Defense> mapOfDefenses;

    public Planet(String name) {
        this.name = name;

        this.mapOfResources = new LinkedHashMap<Integer, Resource>();
        //Create Resources
        Resource jeremejevite = new Resource(R.string.key_Resource_Jeremejevite, "Jeremejevite", 0.2, 1000, 0, 5, R.drawable.resource_jeremejevite, "Considered by ancients the Air Element. Also known as \"piece of sky\", due to its blue sky color. It is the easiest gem stones to catch via mining.");
        Resource fireOpal = new Resource(R.string.key_Resource_FireOpal, "Fire Opal", 0.25, 2000, 0, 10, R.drawable.resource_fireopal, "Considered by ancients the Fire Element. The mineralogy of opal allows it to diffract light, causing it to shimmer various colors.");
        Resource poudretteite = new Resource(R.string.key_Resource_Poudretteite, "Poudretteite", 0.3, 3000, 0, 30, R.drawable.resource_poudretteite, "According to some experts, they refer to it as the fifth element. The perfect element. The one who is responsible to create the stars. Its origin is still a mystery, since we still don’t know its composition. ");
        Resource benitoite = new Resource(R.string.key_Resource_Benitoite, "Benitoite", 0.35, 4000, 0, 1*min, R.drawable.resource_benitoite, "Considered by ancients the Water Element. Benitoite will give off strong fluorescence and shines a bright blue color.");
        Resource musgravite = new Resource(R.string.key_Resource_Musgravite, "Musgravite", 0.4, 5000, 0, 5*min, R.drawable.resource_musgravite, "Considered by ancients the Earth Element. It is an aluminum oxide with variable proportions of magnesium, iron, and zinc.");
        Resource redBeryl = new Resource(R.string.key_Resource_RedBeryl, "Red Beryl", 0.45, 6000, 0, 10*min, R.drawable.resource_redberyl, "In nature, pure beryl is colorless but acquires its coloration due to proximity with magma.");
        Resource alexandrite = new Resource(R.string.key_Resource_Alexandrite, "Alexandrite", 0.5, 7000, 0, 30*min, R.drawable.resource_alexandrite, "It appears to be emerald in light and ruby red in darkness. The rumors says that a physicist create it to sell this as Grandidierite by day and Taaffeite by night, increasing its price by more than 50%.");
        Resource diamond = new Resource(R.string.key_Resource_Diamond, "Diamond", 0.55, 8000, 0, 1*hour, R.drawable.resource_diamond, "It is pure carbon arranged in a diamond lattice, which accounts for its incredible strength and durability. It is found in cooled kimberlites that formed over the course of 1 to 3 billion years.");
        Resource serendibite = new Resource(R.string.key_Resource_Serendibite, "Serendibite", 0.6, 9000, 0, 3*hour, R.drawable.resource_serendibite, "It is an extremely rare gemstone. Also called \"Devil’s eye\" or even \"Black hole\". ");
        Resource grandidierite = new Resource(R.string.key_Resource_Grandidierite, "Grandidierite", 0.65, 10000, 0, 6*hour, R.drawable.resource_grandidierite, "And you always thought that your grandmother earing was cheap. This gem stone is so rare that when somebody sees it thinks that it is fake.");
        Resource taaffeite = new Resource(R.string.key_Resource_Taaffeite, "Taaffeite", 0.7, 11000, 0, 12*hour, R.drawable.resource_taaffeite, "After spending more than 10 years creating this stone. The Portuguese researcher who has created it yelled “Ta feite” and this mineral was baptized.");
        Resource redDiamond = new Resource(R.string.key_Resource_RedDiamond, "Red Diamond", 0.75, 12000, 0, 24*hour, R.drawable.resource_reddiamond, "1 in 10 million have the chance to see one in his lifetime. It is by far the most precious stone in the galaxy. Miners had to spend their whole life to found some in a 20 miles deep hole, near to the center of their planet. ");
        //Put resources in dictionary
        mapOfResources.put(R.string.key_Resource_Jeremejevite, jeremejevite);
        mapOfResources.put(R.string.key_Resource_FireOpal, fireOpal);
        mapOfResources.put(R.string.key_Resource_Poudretteite, poudretteite);
        mapOfResources.put(R.string.key_Resource_Benitoite, benitoite);
        mapOfResources.put(R.string.key_Resource_Musgravite, musgravite);
        mapOfResources.put(R.string.key_Resource_RedBeryl, redBeryl);
        mapOfResources.put(R.string.key_Resource_Alexandrite, alexandrite);
        mapOfResources.put(R.string.key_Resource_Diamond, diamond);
        mapOfResources.put(R.string.key_Resource_Serendibite, serendibite);
        mapOfResources.put(R.string.key_Resource_Grandidierite, grandidierite);
        mapOfResources.put(R.string.key_Resource_Taaffeite, taaffeite);
        mapOfResources.put(R.string.key_Resource_RedDiamond, redDiamond);


        //Create Buildings --> REDEFINE LATER!!
        this.mapOfBuildings = new LinkedHashMap<Integer, Building>();
        Building mine = new Building(R.string.key_Building_Mine, "Mine", "It is responsible for the extraction of valuable gem stones. Have you already met Red Diamond? If so you are doing it well.", 1, 500, R.drawable.building_mine);
        Building hangar = new Building(R.string.key_Building_Hangar, "Hangar", "It is a closed building structure to hold space craft in protective storage. Their space crafts only leave to attack, spy, conquer or defend their planet.", 0, 1000, R.drawable.building_hangar);
        Building defenseWall = new Building(R.string.key_Building_DefenseWall, "Defense Wall", "It is the first line the enemy sees when he wants to destroy, conquer or spy our planet. Believe me, they will wish their space crafts had never left.", 0, 1000, R.drawable.building_defensewall);
        Building researchLab = new Building(R.string.key_Building_ResearchLab, "Research Lab", "It is a facility that provides controlled conditions in which scientific or technological research, experiments, and measurement may be performed.", 0, 1000, R.drawable.building_researchlab);
        mapOfBuildings.put(R.string.key_Building_Mine, mine);
        mapOfBuildings.put(R.string.key_Building_Hangar, hangar);
        mapOfBuildings.put(R.string.key_Building_DefenseWall, defenseWall);
        mapOfBuildings.put(R.string.key_Building_ResearchLab, researchLab);

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

        this.mapOfShips = new LinkedHashMap<Integer, Ship>();
        //Set original stats
        Stats statMessier83 = new Stats(4000, 500, 1000, 2000);
        Stats statMayalls = new Stats(1000, 8000, 10000, 3000);
        Stats statSpyer = new Stats(100, 200, 1000, 10000);
        Stats statLeviathan = new Stats(7000, 7000, 5000, 2000);
        Stats statBattlestarPegasus = new Stats(10000, 9000, 7000, 5000);
        Stats statCylonBasestar= new Stats(15000, 3000, 5000, 3000);
        Stats statGiantMayalls = new Stats(3000, 12000, 12000, 2000);
        Stats statColonizer = new Stats(500, 500, 10000, 1000);
        Stats statDeathStar = new Stats(20000, 15000, 10000, 6000);
        //Create spacecraft
        Ship Messier = new Ship(R.string.key_Ship_Messier, "Messier 83", statMessier83, 0, 3000, R.drawable.ship_messier, "A very fast and destructive ship. The Messier  burns away infantary units in a suicide mission.");
        Ship Mayalls = new Ship(R.string.key_Ship_Mayalls, "Mayall's", statMayalls, 0, 6000, R.drawable.ship_mayal, "An eficient transportation ship for resource units. It can carry up to 5000 units.");
        Ship Spyer = new Ship(R.string.key_Ship_Spyer, "SPY-ER", statSpyer, 0, 8000, R.drawable.ship_spyer, "Ever wonder what your neighbor looks like? This stealth ship is equipped with one of the best clocking devices, so you can see both resources and ships of an enemy planet.");
        Ship Leviathan = new Ship(R.string.key_Ship_Leviathan, "Leviathan", statLeviathan, 0, 9000, R.drawable.ship_leviathan, "This robot-ship is all-rounder unit, it is designed for all-purpose combat. The Leviathan has the same amount off attack and defense, so it should be your standard unit against other colonies.");
        Ship BattlestarPegasus = new Ship(R.string.key_Ship_BattlestarPegasus, "Battlestar Pegasus", statBattlestarPegasus, 0, 15000, R.drawable.ship_batlestarpegasus, "More seeker missiles and lazer beams, simply a Leviathan filled with better weapons and a faster engine (it no longer runs on space carrots). Making the Battlestar Pegasus an expensive but powerful unit.");
        Ship CylonBasestar = new Ship(R.string.key_Ship_CylonBasestar, "Cylon Basestar", statCylonBasestar, 0, 20000, R.drawable.ship_cylonbasestar, "Cylon Basestar is expensive and lacks defense weapons, but is possibly the best offensive unit that can disintegrate several ships with a single blast of his massive cannons. Why bother with defense anyway?");
        Ship GiantMayalls = new Ship(R.string.key_Ship_GiantMayalls, "Giant Mayall's", statGiantMayalls, 0, 15000, R.drawable.ship_giantmayal, "An Large transportation ship for resource units. It can carry up to 10000 units.");
        Ship Colonizer = new Ship(R.string.key_Ship_Colonizer, "Colonizer", statColonizer, 0, 10000, R.drawable.ship_colonizer, "A ship with planet size, it is the ultimate death machine with a huge potential to conquer galaxies or simply turn it into space dust.");
        Ship Deathstar = new Ship(R.string.key_Ship_Deathstar, "Deathstar", statDeathStar, 0, 40000, R.drawable.ship_deathstar, "The Colonizers are used to conquer new planets, they are shuttles who carry fat engineers and precious materials to build a new portion of the empire. ");
        //Put spacecrafts in dictionary
        mapOfShips.put(R.string.key_Ship_Messier, Messier);
        mapOfShips.put(R.string.key_Ship_Mayalls, Mayalls);
        mapOfShips.put(R.string.key_Ship_Spyer, Spyer);
        mapOfShips.put(R.string.key_Ship_Leviathan, Leviathan);
        mapOfShips.put(R.string.key_Ship_BattlestarPegasus, BattlestarPegasus);
        mapOfShips.put(R.string.key_Ship_CylonBasestar, CylonBasestar);
        mapOfShips.put(R.string.key_Ship_GiantMayalls, GiantMayalls);
        mapOfShips.put(R.string.key_Ship_Colonizer, Colonizer);
        mapOfShips.put(R.string.key_Ship_Deathstar, Deathstar);

        this.mapOfDefenses = new LinkedHashMap<Integer, Defense>();
        //Set original stats
        Stats statMissileLauncher = new Stats(3000, 2000, 2000, 0);
        Stats statResourceBunker = new Stats(0, 20000, 10000, 0);
        Stats statPlasmaCannon = new Stats(6000, 1000, 4000, 0);
        Stats statAntiAirRobot = new Stats(7000, 5000, 8000, 0);
        Stats statHeavyLaser = new Stats(10000, 4000, 1000, 0);
        Stats statIonCannon = new Stats(12000, 500, 3000, 0);
        Stats statPlanetShield = new Stats(0, 30000, 15000, 0);
        Stats statAsteroidManipulator = new Stats(15000, 5000, 2000, 0);
        Stats statDarkMatterBeam = new Stats(30000, 9000, 8000, 0);
        //Create defenses
        Defense MissileLauncher = new Defense(R.string.key_Defense_MissileLauncher, "Missile Launcher", statMissileLauncher, 0, 7000, R.drawable.defense_missilelauncher, "Shoots 10 missiles at once that follows the space craft that has the bigger size. ");
        Defense ResourceBunker = new Defense(R.string.key_Defense_ResourceBunker, "Resource Bunker", statResourceBunker, 0, 11000, R.drawable.defense_resourcebunker, "There is a myth about this bunker that says that it had even survived to an attack of 10 death stars. How could it not be safe? ");
        Defense PlasmaCannon = new Defense(R.string.key_Defense_PlasmaCannon, "Plasma Cannon", statPlasmaCannon, 0, 8000, R.drawable.defense_plasmacannon, "This type of technology allows the Cannon to shoot 5 times faster than missiles, and it isn't 5 times weaker trust me I'm engineer. ");
        Defense AntiAirRobot = new Defense(R.string.key_Defense_AntiAirRobot, "Anti Air Robot", statAntiAirRobot, 0, 10000, R.drawable.defense_antiairrobot, "Its name describe itself. It doesn't like to see anything above the ground, that's why you should keep your spacecrafts in the hangar. ");
        Defense HeavyLaser = new Defense(R.string.key_Defense_HeavyLaser, "Heavy Laser", statHeavyLaser, 0, 12000, R.drawable.defense_heavylaser, "Massive destruction weapon. It can be used on top of the best spacecraft, however, it would only shoot once due to the high amount of energy necessary. ");
        Defense IonCannon = new Defense(R.string.key_Defense_IonCannon, "Ion Cannon", statIonCannon, 0, 15000, R.drawable.defense_ioncannon, "And we thought that plasma was fast hein? You should try this one. If you don't see the tail don't panic because it's impossible to see at nude eyes. ");
        Defense PlanetShield = new Defense(R.string.key_Defense_planetShield, "Planet Shield", statPlanetShield, 0, 23000, R.drawable.defense_planetshield, "A powerful magnetic field capable of sustaining a massive attack during long periods of time. As advantage, usually, your defenses won't be stopped in it. ");
        Defense AsteroidManipulator = new Defense(R.string.key_Defense_AsteroidManipulator, "AsteroidManipulate", statAsteroidManipulator, 0, 20000, R.drawable.defense_asteroidmanipulator, "Do you remember pluton? (considered a big asteroid instead of a planet) Now, imagine it moving toward you in flames. Yep, that's why this manipulator is capable of. ");
        Defense DarkMatterBeam = new Defense(R.string.key_Defense_DarkMatterBeam, "Dark Matter Beam", statDarkMatterBeam, 0, 30000, R.drawable.defense_darkmatterbeam, "No one ever survived to tells how it hit.");
        //Put defenses in dictionary
        mapOfDefenses.put(R.string.key_Defense_MissileLauncher, MissileLauncher);
        mapOfDefenses.put(R.string.key_Defense_ResourceBunker, ResourceBunker);
        mapOfDefenses.put(R.string.key_Defense_PlasmaCannon, PlasmaCannon);
        mapOfDefenses.put(R.string.key_Defense_AntiAirRobot, AntiAirRobot);
        mapOfDefenses.put(R.string.key_Defense_HeavyLaser, HeavyLaser);
        mapOfDefenses.put(R.string.key_Defense_IonCannon, IonCannon);
        mapOfDefenses.put(R.string.key_Defense_PlasmaCannon, PlanetShield);
        mapOfDefenses.put(R.string.key_Defense_AntiAirRobot, AsteroidManipulator);
        mapOfDefenses.put(R.string.key_Defense_HeavyLaser, DarkMatterBeam);
    }
}

