package com.spacewarfare.ship;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spacewarfare.MainContext;
import com.spacewarfare.R;
import com.spacewarfare.others.UserInfo;

import java.lang.reflect.Field;
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

            if(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfBuildings.get(R.string.key_Building_Hangar).level*3 > position)
                convertView.setVisibility(View.VISIBLE);
            else
                convertView.setVisibility(View.GONE);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }
        else{
                holder = (ViewHolder) convertView.getTag();

                if(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfBuildings.get(R.string.key_Building_Hangar).level*3 > position)
                    convertView.setVisibility(View.VISIBLE);
                else
                    convertView.setVisibility(View.GONE);
            }

        parent.findViewById(R.id.moneyTextView);
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.ship_defense_info_row, null, false);
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
        private NumberPicker infoNumberBuy;

        private TextView atk;
        private TextView def;
        private TextView hp;
        private TextView speed;

        public ViewHolder(View convertView) {
            shipName = (TextView) convertView.findViewById(R.id.TextView_Name);
            buyShip = (Button) convertView.findViewById(R.id.Button_Buy);
            shipPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            infoShip = (Button) convertView.findViewById(R.id.Button_Info);
            infoShip.setOnClickListener(infoShipClick);
            shipPhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            shipQuantity = (TextView) convertView.findViewById(R.id.TextView_QuantityLevel);
            shipInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) shipInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position){
            ship = getItem(position);

            // Setup Ship row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            shipName.setText(ship.name);
            shipPhoto.setImageResource(ship.image);
            shipPrice.setText("" + ship.price + " cr.");
            buyShip.setOnClickListener(buyShipClick);
            shipQuantity.setVisibility(View.VISIBLE);
            shipQuantity.setText("" + ship.quantity);

            // Setup Ship info
            TextView TextView_infoName = (TextView) infoView.findViewById(R.id.TextView_infoName);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            atk = (TextView) infoView.findViewById(R.id.TextView_Attack);
            def = (TextView) infoView.findViewById(R.id.TextView_Defense);
            hp = (TextView) infoView.findViewById(R.id.TextView_Hp);
            speed = (TextView) infoView.findViewById(R.id.TextView_Speed);
            infoNumberBuy = (NumberPicker) infoView.findViewById(R.id.infoNumberBuy);

            infoBuyShip = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoBuyShip.setOnClickListener(infoBuyShipClick);
            infoCancelShip = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelShip.setOnClickListener(infoCancelShipClick);

            infoNumberBuy.setMaxValue(99);
            infoNumberBuy.setMinValue(1);
            infoNumberBuy.setValue(1);
            infoNumberBuy.setWrapSelectorWheel(true);
            setNumberPickerTextColor(infoNumberBuy, Color.argb(255, 175, 255, 248));
            TextView_infoName.setText(ship.name);
            ImageView_infoPhoto.setImageResource(ship.image);
            TextView_infoDescription.setText(ship.description);
            atk.setText("" + ship.stats.atk);
            def.setText("" + ship.stats.def);
            hp.setText("" + ship.stats.hp);
            speed.setText("" + ship.stats.speed);

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
                else
                    Snackbar.make(v, "1 spacecraft was bought!", Snackbar.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener infoBuyShipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int shipsBought = 0;
                int shipsToBuy = infoNumberBuy.getValue();

                while (shipsBought < shipsToBuy){
                    if(!buyShipAction(ShipsAdapter.ViewHolder.this)){
                        if(shipsBought == 0){
                            Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                            infoView.setVisibility(View.GONE);
                            return;
                        }
                        else{
                            Snackbar.make(v, "It was only possible to buy " + shipsBought + " spacecrafts!" , Snackbar.LENGTH_SHORT).show();
                            infoView.setVisibility(View.GONE);
                            return;
                        }
                    }
                    shipsBought++;
                }
                if(shipsToBuy == shipsBought){
                    if(shipsToBuy == 1)
                        Snackbar.make(v, "1 spacecraft was bought!", Snackbar.LENGTH_SHORT).show();
                    else
                        Snackbar.make(v, shipsBought + " spacecrafts were bought!", Snackbar.LENGTH_SHORT).show();
                    infoView.setVisibility(View.GONE);
                    return;
                }
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

    public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color)
    {
        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            View child = numberPicker.getChildAt(i);
            if(child instanceof EditText){
                try{
                    Field selectorWheelPaintField = numberPicker.getClass().getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
                    ((EditText)child).setTextColor(color);
                    numberPicker.invalidate();
                    return true;
                }
                catch(NoSuchFieldException e){
                    Log.w("setNumberPickerTextColo", e);
                }
                catch(IllegalAccessException e){
                    Log.w("setNumberPickerTextColo", e);
                }
                catch(IllegalArgumentException e){
                    Log.w("setNumberPickerTextColo", e);
                }
            }
        }
        return false;
    }

}
