package com.spacewarfare.Building;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.spacewarfare.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class BuildingsAdapter extends ArrayAdapter<Building> {

    public BuildingsAdapter(Context context, List<Building> buildings) {
        super(context, R.layout.building_row, buildings);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buildingInflater = LayoutInflater.from(getContext());
        View buildingView = buildingInflater.inflate(R.layout.building_row, parent, false);

        Building singleBuildingItem = getItem(position);

        TextView buildingName = (TextView) buildingView.findViewById(R.id.TextView_BuildingName);
        Button buyBuilding = (Button) buildingView.findViewById(R.id.Button_BuyBuilding);
        TextView buildingPrice = (TextView) buildingView.findViewById(R.id.TextView_BuildingPrice);
        Button infoBuilding = (Button) buildingView.findViewById(R.id.Button_InfoBuilding);
        ImageView building = (ImageView) buildingView.findViewById(R.id.ImageView_Building);
        ImageView buildingChecked = (ImageView) buildingView.findViewById(R.id.ImageView_BuildingChecked);

        buildingName.setText(singleBuildingItem.name);
        buildingPrice.setText(singleBuildingItem.price);
        infoBuilding.setText(singleBuildingItem.infoBuilding);

        // FALTA IMAGEM E CHECKED
        building.setImageResource(R.drawable.ic_menu_camera);
        buildingChecked.setImageResource(R.drawable.ic_menu_gallery);
        //String img = singleBuildingItem.image;
        //building.setImageBitmap(singleBuildingItem.image);

        return buildingView;
    }
}
