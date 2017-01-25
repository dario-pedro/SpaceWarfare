package com.spacewarfare.Building;

import android.content.Context;
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
        Building singleBuildingItem = getItem(position);
        holder.setParameters(singleBuildingItem);

        return convertView;
    }

    private class ViewHolder {
        private TextView buildingName;
        private Button buyBuilding;
        private TextView buildingPrice;
        private Button infoBuilding;
        private ImageView building;
        private ImageView buildingChecked;

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
            this.building = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.buildingChecked = (ImageView) convertView.findViewById(R.id.ImageView_Checked);
            this.buildingInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
        }

        public void setParameters(Building singleBuildingItem){
            this.buildingName.setText(singleBuildingItem.name);
            this.building.setImageResource(singleBuildingItem.image);

            if(!singleBuildingItem.owned){
                this.buildingPrice.setText("Price: " + singleBuildingItem.price + " cr.");
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
    }

}
