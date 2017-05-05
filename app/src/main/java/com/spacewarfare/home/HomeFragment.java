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

package com.spacewarfare.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.spacewarfare.MainContext;
import com.spacewarfare.R;
import com.spacewarfare.resource.Resource;
import com.spacewarfare.resource.ResourcesAdapter;

import org.rajawali3d.surface.IRajawaliSurface;
import org.rajawali3d.surface.RajawaliSurfaceView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    Renderer renderer;
    ViewGroup curr_container;
    RajawaliSurfaceView surface;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View homeView =  inflater.inflate(R.layout.empty_fragment, container, false);
        renderer = new Renderer(MainContext.INSTANCE.getMainActivity());

        surface = new RajawaliSurfaceView(MainContext.INSTANCE.getMainActivity());
        surface.setFrameRate(60.0);
        surface.setRenderMode(IRajawaliSurface.RENDERMODE_WHEN_DIRTY);

        surface.setOnTouchListener(renderer);
        surface.setTransparent(true);

        surface.setSurfaceRenderer(renderer);

        // Add mSurface to your root view
        container.addView(surface, new android.app.ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT));



        curr_container = container;

        return homeView;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");
    }



    @Override
    public void onDestroyView() {
        destroySurface();
        super.onDestroyView();
    }


    private void destroySurface(){
        curr_container.removeView(surface);
        surface.destroyDrawingCache();
        surface = null;
        renderer = null;
    }
}
