package com.spacewarfare.Ship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spacewarfare.R;

import java.util.List;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class ShipsAdapter extends ArrayAdapter<Ship> {

    public ShipsAdapter(Context context, List<Ship> ships) {
        super(context, R.layout.default_row, ships);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            LayoutInflater fragmentInflater = LayoutInflater.from(getContext());
            convertView = fragmentInflater.inflate(R.layout.default_row, parent, false);

            holder = new ViewHolder(convertView);
            holder.infoView = fragmentInflater.inflate(R.layout.default_info_row, null, false);

            //holder.geralRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.geralRelativeLayout);
            //holder.geralRelativeLayout.addView(holder.infoView);
            //holder.infoView.setVisibility(View.GONE);

            convertView.setTag(holder);
        }
        else{
                holder = (ViewHolder) convertView.getTag();
            }

        Ship singleShipItem = getItem(position);
        holder.setParameters(singleShipItem);

        return convertView;
    }

    private class ViewHolder {
        private TextView shipName;
        private Button buyShip;
        private TextView shipPrice;
        private Button infoShip;
        private ImageView ship;
        private TextView shipQuantity;
        //private ImageView buildingChecked;

        public View infoView;
        //private RelativeLayout geralRelativeLayout;


        public ViewHolder(View convertView) {
            this.shipName = (TextView) convertView.findViewById(R.id.TextView_Name);
            this.buyShip = (Button) convertView.findViewById(R.id.Button_Buy);
            this.shipPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            this.infoShip = (Button) convertView.findViewById(R.id.Button_Info);
            this.infoShip.setOnClickListener(infoShipClick);
            this.ship = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.shipQuantity = (TextView) convertView.findViewById(R.id.TextView_Quantity);
        }

        public void setParameters(Ship singleShipItem){
            this.shipName.setText(singleShipItem.name);
            this.ship.setImageResource(singleShipItem.image);
            this.shipPrice.setText("Price: " + singleShipItem.price + " cr.");
            this.buyShip.setText("BUY");
            if(singleShipItem.quantity>0)
                this.shipQuantity.setText("Quantity: " + singleShipItem.quantity);
        }

        private View.OnClickListener infoShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //infoView.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
