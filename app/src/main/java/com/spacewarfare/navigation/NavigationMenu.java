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

package com.spacewarfare.navigation;

import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.spacewarfare.home.HomeFragment;
import com.spacewarfare.MainActivity;
import com.spacewarfare.R;
import com.spacewarfare.resource.ResourcesFragment;


public enum NavigationMenu {
    HOME(R.drawable.icon_home, R.string.action_login, new FragmentItem(new HomeFragment())),
    RESOURCES(R.drawable.icon_resources, R.string.action_resources, new FragmentItem(new ResourcesFragment()));
   /* LOGIN(R.drawable.ic_settings_grey_500_48dp, R.string.action_login, new ActivityItem(LoginActivity.class)),

*/
    private final int icon;
    private final int title;
    private final NavigationMenuItem item;


    NavigationMenu(int icon, int title, @NonNull NavigationMenuItem item) {
        this.icon = icon;
        this.title = title;
        this.item = item;
    }

        public static NavigationMenu find(int index) {
            if (index < 0 || index >= values().length) {
                return HOME;
            }
            return values()[index];
        }

    public int getTitle() {
        return title;
    }



    int getIcon() {
        return icon;
    }

    public void activateNavigationMenu(@NonNull MainActivity mainActivity, @NonNull MenuItem menuItem) {
        item.activate(mainActivity, menuItem, this);
    }

    NavigationMenuItem getItem() {
        return item;
    }
}
