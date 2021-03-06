package com.spacewarfare.defense;


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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefensesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);

        List<Defense> defenses = new ArrayList<Defense>(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfDefenses.values());
        ListAdapter defensesAdapter = new DefensesAdapter(MainContext.INSTANCE.getMainActivity(), defenses);

        ListView defensesListView = (ListView) v.findViewById(R.id.geralListView);
        defensesListView.setAdapter(defensesAdapter);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Defenses");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
