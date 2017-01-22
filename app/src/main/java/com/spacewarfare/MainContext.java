/*
 * WiFi Analyzer
 * Copyright (C) 2016  VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.spacewarfare;


import android.content.res.Configuration;
import android.support.annotation.NonNull;


public enum MainContext {
    INSTANCE;

    private MainActivity mainActivity;
    //private Database database;
    private Configuration configuration;



  /*  public Database getDatabase() {
        return database;
    }

    void setDatabase(Database database) {
        this.database = database;
    }*/

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    void initialize(@NonNull MainActivity mainActivity) {
        //Handler handler = new Handler();

        Configuration configuration = new Configuration();

        setMainActivity(mainActivity);
        setConfiguration(configuration);
        //setDatabase(new Database(mainActivity));
    }
}
