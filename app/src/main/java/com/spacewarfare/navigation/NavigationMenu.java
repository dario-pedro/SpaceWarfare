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

import com.spacewarfare.Home.HomeFragment;
import com.spacewarfare.MainActivity;
import com.spacewarfare.R;


public enum NavigationMenu {
    HOME(R.drawable.icon_home, R.string.action_login, new FragmentItem(new HomeFragment()));
   /* LOGIN(R.drawable.ic_settings_grey_500_48dp, R.string.action_login, new ActivityItem(LoginActivity.class)),


    ACCESS_POINTS(R.drawable.ic_network_wifi_grey_500_48dp, R.string.action_access_points, true, new FragmentItem(new AccessPointsFragment())),
    GOOGLE_MAPS(R.drawable.ic_media_play, R.string.action_gmaps, new ActivityItem(MapsActivity.class)),
    CHANNEL_RATING(R.drawable.ic_wifi_tethering_grey_500_48dp, R.string.action_channel_rating, true, new FragmentItem(new ChannelRatingFragment())),
    CHANNEL_GRAPH(R.drawable.ic_insert_chart_grey_500_48dp, R.string.action_channel_graph, true, new FragmentItem(new ChannelGraphFragment())),
    TIME_GRAPH(R.drawable.ic_show_chart_grey_500_48dp, R.string.action_time_graph, true, new FragmentItem(new TimeGraphFragment())),

    EXPORT(R.drawable.ic_import_export_grey_500_48dp, R.string.action_export, new ExportItem()),
    CHANNEL_AVAILABLE(R.drawable.ic_location_on_grey_500_48dp, R.string.action_channel_available, new FragmentItem(new ChannelAvailableFragment())),
    VENDOR_LIST(R.drawable.ic_list_grey_500_48dp, R.string.action_vendors, new FragmentItem(new VendorFragment())),

    SETTINGS(R.drawable.ic_settings_grey_500_48dp, R.string.action_settings, new ActivityItem(SettingActivity.class)),
    CONTACTS(R.drawable.ic_info_outline_grey_500_48dp, R.string.action_contacts, new FragmentItem(new ContactsFragment()));
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
