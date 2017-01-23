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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.spacewarfare.Building.BuildingsFragment;
import com.spacewarfare.Building.BuildingsAdapter;
import com.spacewarfare.Defense.DefenseFragment;
import com.spacewarfare.Navigation.NavigationMenu;
import com.spacewarfare.Navigation.NavigationMenuView;

import java.util.Arrays;
import java.util.List;

import com.spacewarfare.userInfo;
import com.spacewarfare.Home.Planet;
import com.spacewarfare.Building.Building;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationMenuView navigationMenuView;
    private NavigationMenu startNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

///////////////////////////////////////////RENDERER CODE - TEST//////////////////
      /*  final RajawaliSurfaceView surface = new RajawaliSurfaceView(this);
        surface.setFrameRate(60.0);
        surface.setRenderMode(IRajawaliSurface.RENDERMODE_WHEN_DIRTY);

        // Add mSurface to your root view
        addContentView(surface, new android.app.ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT));

        renderer = new Renderer(this);
        surface.setSurfaceRenderer(renderer);
        surface.setOnTouchListener(renderer);*/
////////////////////////////////////////////////////////////////////////////////////



        MainContext mainContext = MainContext.INSTANCE;
        mainContext.initialize(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide(); //Hide action bar

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationMenuView.getCurrentMenuItem());*/

        startNavigationMenu = NavigationMenu.HOME;
        navigationMenuView = new NavigationMenuView(this, startNavigationMenu);
        onNavigationItemSelected(navigationMenuView.getCurrentMenuItem());

        /*DefenseFragment fragment = new DefenseFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, "FragmentDefense");
        fragmentTransaction.commit();*/

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
            //NavigationMenu.RESOURCES.activateNavigationMenu(this,item);
        } else if (id == R.id.nav_buildings) {

            setTitle("FragmentBuildings");
            BuildingsFragment fragment = new BuildingsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentBuildings");
            fragmentTransaction.commit();

            //TEST
            userInfo userInfo = new userInfo("DD", "DD");
            userInfo.firstPlanet();

            //List<Building> allBuildings = Arrays.asList(Hangar, SpatialStation);
            //ListAdapter buildingsAdapter = new BuildingsAdapter(this, allBuildings);

            //System.out.println(userInfo.allPlanets.get(0).allBuildings.get(0).name);
            //System.out.println(userInfo.allPlanets.get(0).allBuildings.get(1).name);

            // get(0) stands for initial planet -> Earth
            ListAdapter buildingsAdapter = new BuildingsAdapter(this, userInfo.allPlanets.get(0).allBuildings);
            ListView buildingsListView = (ListView) findViewById(R.id.geralListView);
            buildingsListView.setAdapter(buildingsAdapter);

            buildingsListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Building b = (Building) parent.getItemAtPosition(position);
                            Toast.makeText(MainActivity.this, b.name, Toast.LENGTH_LONG).show();
                        }
                    }
            );


        } else if (id == R.id.nav_research) {

        } else if (id == R.id.nav_ships) {

        } else if (id == R.id.nav_defense) {

            setTitle("FragmentDefense");
            DefenseFragment fragment = new DefenseFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "FragmentDefense");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_attack) {

        } else if (id == R.id.nav_outerspace) {

        } else if (id == R.id.nav_conquers) {

        } else if (id == R.id.nav_rankings) {

        }
        NavigationMenu.find(item.getItemId()).activateNavigationMenu(this, item);
        closeDrawer();

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
