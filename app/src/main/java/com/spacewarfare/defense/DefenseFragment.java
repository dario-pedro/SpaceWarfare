package com.spacewarfare.Defense;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spacewarfare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefenseFragment extends Fragment {


    public DefenseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_defense, container, false);
    }

}
