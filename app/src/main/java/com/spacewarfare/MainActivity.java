package com.spacewarfare;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.spacewarfare.building.BuildingsFragment;
import com.spacewarfare.defense.DefensesFragment;
import com.spacewarfare.navigation.*;
import com.spacewarfare.research.ResearchesFragment;
import com.spacewarfare.resource.ResourcesFragment;
import com.spacewarfare.ship.ShipsFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationMenuView navigationMenuView;
    private NavigationMenu startNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainContext mainContext = MainContext.INSTANCE;
        mainContext.initialize(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide(); //Hide action bar

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationMenuView.getCurrentMenuItem());*/

        startNavigationMenu = NavigationMenu.HOME;
        navigationMenuView = new NavigationMenuView(this, startNavigationMenu);

        onNavigationItemSelected(navigationMenuView.getCurrentMenuItem());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.nav_home) {
            //NavigationMenu.HOME.activateNavigationMenu(this,item);
        } else if (id == R.id.nav_resources) {

            setTitle("FragmentResources");
            ResourcesFragment fragment = new ResourcesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentResources");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_buildings) {

            setTitle("FragmentBuildings");
            BuildingsFragment fragment = new BuildingsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentBuildings");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_research) {

            setTitle("FragmentResearch");
            ResearchesFragment fragment = new ResearchesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentResearches");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_ships) {

            setTitle("FragmentShip");
            ShipsFragment fragment = new ShipsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentDefense");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_defense) {

            setTitle("FragmentDefense");
            DefensesFragment fragment = new DefensesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentDefense");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_attack) {

        } else if (id == R.id.nav_outerspace) {

        } else if (id == R.id.nav_conquers) {

        } else if (id == R.id.nav_rankings) {

        }

        closeDrawer();
        item.setCheckable(true);
        item.setChecked(true);

        return true;
    }


    private boolean closeDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }

    public NavigationMenuView getNavigationMenuView() {
        return navigationMenuView;
    }


}
