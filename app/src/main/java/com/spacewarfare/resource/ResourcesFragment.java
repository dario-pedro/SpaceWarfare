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

package com.spacewarfare.resource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.spacewarfare.MainContext;
import com.spacewarfare.R;
import com.spacewarfare.building.Building;
import com.spacewarfare.building.BuildingsAdapter;

import java.util.ArrayList;
import java.util.List;


public class ResourcesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);

        List<Resource> resources = availableResources();
        ListAdapter resourcesAdapter = new ResourcesAdapter(MainContext.INSTANCE.getMainActivity(), resources);

        ListView resourcesListView = (ListView) v.findViewById(R.id.geralListView);
        resourcesListView.setAdapter(resourcesAdapter);

        return v;
    }

    private List<Resource> availableResources(){
        List<Resource> resources = new ArrayList<Resource>(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfResources.values());


        return resources;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Buildings");
    }



    @Override
    public void onResume() {
        super.onResume();
    }

}
