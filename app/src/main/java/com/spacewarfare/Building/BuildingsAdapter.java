package com.spacewarfare.Building;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.Toast;

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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            LayoutInflater fragmentInflater = LayoutInflater.from(getContext());
            convertView = fragmentInflater.inflate(R.layout.building_row, parent, false);

            holder = new ViewHolder();
            holder.buildingName = (TextView) convertView.findViewById(R.id.TextView_BuildingName);
            holder.buyBuilding = (Button) convertView.findViewById(R.id.Button_BuyBuilding);
            holder.buildingPrice = (TextView) convertView.findViewById(R.id.TextView_BuildingPrice);
            holder.infoBuilding = (Button) convertView.findViewById(R.id.Button_InfoBuilding);
            holder.building = (ImageView) convertView.findViewById(R.id.ImageView_Building);
            holder.buildingChecked = (ImageView) convertView.findViewById(R.id.ImageView_BuildingChecked);

            holder.infoView = fragmentInflater.inflate(R.layout.building_info_row, null, false);

            Building singleBuildingItem = getItem(position);

            holder.buildingName.setText(singleBuildingItem.name);
            holder.building.setImageResource(singleBuildingItem.image);

            if(!singleBuildingItem.owned){
                holder.buildingPrice.setText("Price: " + singleBuildingItem.price + " cr.");
                holder.buyBuilding.setText("BUY");
            }
            else{
                holder.buildingChecked.setImageResource(R.drawable.checked);
                holder.buyBuilding.setText("OWNED");
            }

            convertView.setTag(holder);
        }
        else{
                holder = (ViewHolder) convertView.getTag();
            }

        holder.infoBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //holder.infoView.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private class ViewHolder {
        public TextView buildingName;
        public Button buyBuilding;
        public TextView buildingPrice;
        public Button infoBuilding;
        public ImageView building;
        public ImageView buildingChecked;
        public View infoView;
    }

    /*
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buildingInflater = LayoutInflater.from(getContext());
        View buildingView = buildingInflater.inflate(R.layout.building_row, parent, false);

        //buildingInflater.inflate(R.layout.building_info_row, parent, false);

        Building singleBuildingItem = getItem(position);

        TextView buildingName = (TextView) buildingView.findViewById(R.id.TextView_BuildingName);
        Button buyBuilding = (Button) buildingView.findViewById(R.id.Button_BuyBuilding);
        TextView buildingPrice = (TextView) buildingView.findViewById(R.id.TextView_BuildingPrice);
        Button infoBuilding = (Button) buildingView.findViewById(R.id.Button_InfoBuilding);
        ImageView building = (ImageView) buildingView.findViewById(R.id.ImageView_Building);
        ImageView buildingChecked = (ImageView) buildingView.findViewById(R.id.ImageView_BuildingChecked);

        buildingName.setText(singleBuildingItem.name);
        building.setImageResource(singleBuildingItem.image);

        if(!singleBuildingItem.owned){
            buildingPrice.setText("Price: " + singleBuildingItem.price + " cr.");
            buyBuilding.setText("BUY");
        }
        else{
            buildingChecked.setImageResource(R.drawable.checked);
            buyBuilding.setText("OWNED");
        }

        return buildingView;
    }
*/

}
