package com.spacewarfare.ship;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.text.SpannableString;
import android.text.style.StyleSpan;
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
import com.spacewarfare.UserInfo;
import com.spacewarfare.defense.Defense;
import com.spacewarfare.defense.DefensesAdapter;

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

        parent.findViewById(R.id.moneyTextView);
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.default_info_row, null, false);
        holder.setParameters(position);

        return convertView;
    }

    private class ViewHolder {
        private TextView shipName;
        private Button buyShip;
        private TextView shipPrice;
        private Button infoShip;
        private ImageView shipPhoto;
        private TextView shipQuantity;

        private RelativeLayout shipInfoLayout;
        public Ship ship;
        public TextView currentMoney;

        public View infoView;
        private Button infoBuyShip;
        private Button infoCancelShip;

        public ViewHolder(View convertView) {
            shipName = (TextView) convertView.findViewById(R.id.TextView_Name);
            buyShip = (Button) convertView.findViewById(R.id.Button_Buy);
            shipPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            infoShip = (Button) convertView.findViewById(R.id.Button_Info);
            infoShip.setOnClickListener(infoShipClick);
            shipPhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            shipQuantity = (TextView) convertView.findViewById(R.id.TextView_Quantity);
            shipInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) shipInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position){
            ship = getItem(position);

            // Setup Ship row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            shipName.setText(ship.name);
            shipPhoto.setImageResource(ship.image);
            SpannableString spannableString =  new SpannableString("Price: ");
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), 0);
            shipPrice.setText(spannableString);
            shipPrice.append(ship.price + " cr.");
            buyShip.setOnClickListener(buyShipClick);
            shipQuantity.setVisibility(View.VISIBLE);
            //SpannableString spannableString2 =  new SpannableString("Quantity: ");
            //spannableString2.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString2.length(), 0);
            //shipQuantity.setText(spannableString2);
            //shipQuantity.append(String.valueOf(ship.quantity));
            shipQuantity.setText("" + ship.quantity);

            // Setup Ship info
            TextView TextView_infoName = (TextView) infoView.findViewById(R.id.TextView_infoName);
            TextView_infoName.setText(ship.name);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            ImageView_infoPhoto.setImageResource(ship.image);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            TextView_infoDescription.setText(ship.description);
            infoBuyShip = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoBuyShip.setOnClickListener(infoBuyShipClick);
            infoCancelShip = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelShip.setOnClickListener(infoCancelShipClick);
            shipInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);

        }

        private View.OnClickListener infoShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
            }
        };

        private View.OnClickListener buyShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!buyShipAction(ShipsAdapter.ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener infoBuyShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!buyShipAction(ShipsAdapter.ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                infoView.setVisibility(View.GONE);
            }
        };

        private View.OnClickListener infoCancelShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };
    }

    private boolean buyShipAction(ShipsAdapter.ViewHolder viewHolder){
        UserInfo userInfo = MainContext.INSTANCE.getUserI();
        Ship ship = viewHolder.ship;

        if(userInfo.money >= userInfo.allPlanets.get(0).mapOfShips.get(ship.key).price){
            // Update Info
            userInfo.money -= userInfo.allPlanets.get(0).mapOfShips.get(ship.key).price;
            int quant = userInfo.allPlanets.get(0).mapOfShips.get(ship.key).quantity++;
            // Update Layout
            viewHolder.currentMoney.setText("" + userInfo.money);
            viewHolder.shipQuantity.setText(""  + (quant+1));
            return true;
        }

        return false;
    }



}
