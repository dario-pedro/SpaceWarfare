package com.spacewarfare.Defense;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.spacewarfare.Building.BuildingsAdapter;
import com.spacewarfare.MainContext;
import com.spacewarfare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefensesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);

        ListAdapter defensesAdapter = new DefensesAdapter(MainContext.INSTANCE.getMainActivity(), MainContext.INSTANCE.getUserI().allPlanets.get(0).allDefenses);
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
