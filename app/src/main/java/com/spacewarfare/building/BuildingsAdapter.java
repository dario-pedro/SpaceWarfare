package com.spacewarfare.building;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;


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

        parent.findViewById(R.id.moneyTextView);
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.building_research_info_row, null, false);
        holder.setParameters(position);

        return convertView;
    }

    private class ViewHolder {
        private TextView buildingName;
        private Button buyBuilding;
        private TextView buildingPrice;
        private Button infoBuilding;
        private ImageView buildingPhoto;
        private TextView buildingLevel;
        //private ImageView buildingChecked;

        private RelativeLayout buildingInfoLayout;
        public Building building;
        public TextView currentMoney;

        public View infoView;
        private Button infoBuyBuilding;
        private Button infoCancelBuilding;

        public ViewHolder(View convertView) {
            buildingName = (TextView) convertView.findViewById(R.id.TextView_Name);
            buyBuilding = (Button) convertView.findViewById(R.id.Button_Buy);
            buildingPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            infoBuilding = (Button) convertView.findViewById(R.id.Button_Info);
            infoBuilding.setOnClickListener(infoBuildingClick);
            buildingPhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            //buildingChecked = (ImageView) convertView.findViewById(R.id.ImageView_Checked);
            buildingInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) buildingInfoLayout.findViewById(R.id.moneyTextView);
            buildingLevel = (TextView) convertView.findViewById(R.id.TextView_QuantityLevel);
        }

        public void setParameters(int position){
            building = getItem(position);

            // Setup Building row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            buildingName.setText(building.name);
            buildingPhoto.setImageResource(building.image);
            buildingPrice.setText("" + (int) (building.price * Math.pow(3.0, (double) building.level)));
            buyBuilding.setOnClickListener(buyBuildingClick);
            buildingLevel.setText("" + building.level);
            //buildingChecked.setImageResource(R.drawable.checked);

            // Setup Building info
            TextView TextView_infoName = (TextView) infoView.findViewById(R.id.TextView_infoName);
            TextView_infoName.setText(building.name);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            ImageView_infoPhoto.setImageResource(building.image);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            TextView_infoDescription.setText(building.description);
            infoBuyBuilding = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoBuyBuilding.setOnClickListener(infoBuyBuildingClick);
            infoCancelBuilding = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelBuilding.setOnClickListener(infoCancelBuildingClick);
            buildingInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);

            if(building.level > 0){
                buildingLevel.setVisibility(View.VISIBLE);
                infoBuyBuilding.setText("UPGRADE");
                buyBuilding.setText("UPGRADE");
            }
            else{
                buildingLevel.setVisibility(View.GONE);
                buyBuilding.setText("BUY");
            }
        }

        private View.OnClickListener infoBuildingClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
            }
        };

        private View.OnClickListener buyBuildingClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!buyBuildingAction(ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener infoBuyBuildingClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!buyBuildingAction(ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                infoView.setVisibility(View.GONE);
            }
        };

        private View.OnClickListener infoCancelBuildingClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };
    }

    private boolean buyBuildingAction(ViewHolder viewHolder){
        UserInfo userInfo = MainContext.INSTANCE.getUserI();


        if(viewHolder.building.level == 0 && userInfo.money >= viewHolder.building.price){
            userInfo.money -= viewHolder.building.price;
            userInfo.allPlanets.get(0).mapOfBuildings.get(viewHolder.building.key).level++;
            viewHolder.buyBuilding.setText("UPGRADE");
            viewHolder.infoBuyBuilding.setText("UPGRADE");
            viewHolder.buildingLevel.setText("1");
            viewHolder.buildingLevel.setVisibility(View.VISIBLE);
            viewHolder.buildingPrice.setText("" + (int) (viewHolder.building.price * Math.pow(3.0, (double) viewHolder.building.level)));
            viewHolder.currentMoney.setText("" + userInfo.money);
            return true;
        }
        else
            if(viewHolder.building.level > 0 && userInfo.money >=(int) (viewHolder.building.price * Math.pow(3.0, (double) viewHolder.building.level))){
                // Update Info
                userInfo.money -= (int) (viewHolder.building.price * Math.pow(3.0, (double) (viewHolder.building.level)));
                userInfo.allPlanets.get(0).mapOfBuildings.get(viewHolder.building.key).level++;
                // Update Layout
                viewHolder.currentMoney.setText("" + userInfo.money);
                viewHolder.buildingLevel.setText(""  + (viewHolder.building.level));
                viewHolder.buildingPrice.setText("" + (int) (viewHolder.building.price * Math.pow(3.0, (double) (viewHolder.building.level))));
                return true;
            }

        return false;
    }



}
