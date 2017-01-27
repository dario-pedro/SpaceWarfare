package com.spacewarfare.ship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spacewarfare.MainContext;
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.default_row, parent, false);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }
        else{
                holder = (ViewHolder) convertView.getTag();
            }

        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.default_info_row, null, false);
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

        private RelativeLayout shipInfoLayout;
        public View infoView;
        Button infoLeftButton;
        Button infoRightButton;

        public ViewHolder(View convertView) {
            this.shipName = (TextView) convertView.findViewById(R.id.TextView_Name);
            this.buyShip = (Button) convertView.findViewById(R.id.Button_Buy);
            this.shipPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            this.infoShip = (Button) convertView.findViewById(R.id.Button_Info);
            this.infoShip.setOnClickListener(infoShipClick);
            this.ship = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.shipQuantity = (TextView) convertView.findViewById(R.id.TextView_Quantity);
            this.shipInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
        }

        public void setParameters(Ship singleShipItem){
            this.shipName.setText(singleShipItem.name);
            this.ship.setImageResource(singleShipItem.image);
            this.shipPrice.setText("Price: " + singleShipItem.price + " cr.");
            this.buyShip.setText("BUY");
            if(singleShipItem.quantity>0){
                this.shipQuantity.setVisibility(View.VISIBLE);
                this.shipQuantity.setText("Quantity: " + singleShipItem.quantity);
            }
            else
                this.shipQuantity.setVisibility(View.GONE);

            shipInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);
        }

        private View.OnClickListener infoShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
                //Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
