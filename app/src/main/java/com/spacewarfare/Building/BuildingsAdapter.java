package com.spacewarfare.Building;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


import com.spacewarfare.MainContext;
import com.spacewarfare.R;
import com.spacewarfare.UserInfo;

import java.util.List;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class BuildingsAdapter extends ArrayAdapter<Building> {

    public BuildingsAdapter(Context context, List<Building> buildings) {
        super(context, R.layout.default_row, buildings);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.default_row, parent, false);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }
        else{
                holder = (ViewHolder) convertView.getTag();
            }

        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.default_info_row, null, false);
        //Building singleBuildingItem = getItem(position);
        holder.setParameters(position);
        parent.findViewById(R.id.moneyTextView);

        return convertView;
    }

    private class ViewHolder {
        private TextView buildingName;
        private Button buyBuilding;
        private TextView buildingPrice;
        private Button infoBuilding;
        private ImageView buildingPhoto;
        private ImageView buildingChecked;

        public Building building;
        public TextView currentMoney;

        private RelativeLayout buildingInfoLayout;
        public View infoView;
        Button infoLeftButton;
        Button infoRightButton;

        public ViewHolder(View convertView) {
            this.buildingName = (TextView) convertView.findViewById(R.id.TextView_Name);
            this.buyBuilding = (Button) convertView.findViewById(R.id.Button_Buy);
            this.buildingPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            this.infoBuilding = (Button) convertView.findViewById(R.id.Button_Info);
            this.infoBuilding.setOnClickListener(infoBuildingClick);
            this.buildingPhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.buildingChecked = (ImageView) convertView.findViewById(R.id.ImageView_Checked);
            this.buildingInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            this.currentMoney = (TextView) this.buildingInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position){
            this.building = getItem(position);

            this.currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            this.buildingName.setText(this.building.name);
            this.buildingPhoto.setImageResource(this.building.image);
            this.buildingPrice.setText("Price: " + this.building.price + " cr.");

            if(!this.building.owned){
                this.buyBuilding.setOnClickListener(buyBuildingClick);
                this.buyBuilding.setText("BUY");
                this.buildingChecked.setVisibility(View.GONE);
            }
            else{
                this.buildingChecked.setVisibility(View.VISIBLE);
                this.buildingChecked.setImageResource(R.drawable.checked);
                this.buyBuilding.setText("OWNED");
            }

            buildingInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);
        }

        private View.OnClickListener infoBuildingClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
                //Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener buyBuildingClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(building.owned)
                    Toast.makeText(getContext(), "You already have this building!", Toast.LENGTH_SHORT).show();
                else
                    if(!buyBuildingAction(ViewHolder.this, MainContext.INSTANCE.getUserI(), building))
                        Toast.makeText(getContext(), "Not enough money!", Toast.LENGTH_SHORT).show();
            }
        };

        private boolean buyBuildingAction(ViewHolder viewHolder, UserInfo userInfo, Building building){
            if(userInfo.money >= userInfo.allPlanets.get(0).mapOfBuildings.get(building.key).price){
                // Update Info
                userInfo.money -= userInfo.allPlanets.get(0).mapOfBuildings.get(building.key).price;
                userInfo.allPlanets.get(0).mapOfBuildings.get(building.key).owned = true;
                // Update Layout
                viewHolder.currentMoney.setText("" + userInfo.money);
                viewHolder.buildingChecked.setVisibility(View.VISIBLE);
                viewHolder.buildingChecked.setImageResource(R.drawable.checked);
                viewHolder.buyBuilding.setText("OWNED");
                return true;
            }
            else
                return false;
        }
    }



}
