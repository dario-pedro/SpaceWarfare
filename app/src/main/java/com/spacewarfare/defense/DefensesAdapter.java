package com.spacewarfare.defense;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.text.SpannableString;
import android.text.style.StyleSpan;
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
import android.widget.Toast;

import com.spacewarfare.MainContext;
import com.spacewarfare.R;
import com.spacewarfare.UserInfo;
import com.spacewarfare.building.Building;
import com.spacewarfare.building.BuildingsAdapter;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class DefensesAdapter extends ArrayAdapter<Defense> {

    public DefensesAdapter(Context context, List<Defense> defenses) {
        super(context, R.layout.default_row, defenses);
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
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.ship_defense_info_row, null, false);
        holder.setParameters(position);

        return convertView;
    }

    private class ViewHolder {
        private TextView defenseName;
        private Button buyDefense;
        private TextView defensePrice;
        private Button infoDefense;
        private ImageView defensePhoto;
        private TextView defenseQuantity;

        private RelativeLayout defenseInfoLayout;
        public Defense defense;
        public TextView currentMoney;

        public View infoView;
        private Button infoBuyDefense;
        private Button infoCancelDefense;
        private NumberPicker infoNumberBuy;

        private TextView atk;
        private TextView def;
        private TextView hp;
        private TextView speed;

        public ViewHolder(View convertView) {
            defenseName = (TextView) convertView.findViewById(R.id.TextView_Name);
            buyDefense = (Button) convertView.findViewById(R.id.Button_Buy);
            defensePrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            infoDefense = (Button) convertView.findViewById(R.id.Button_Info);
            infoDefense.setOnClickListener(infoDefenseClick);
            defensePhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            defenseQuantity = (TextView) convertView.findViewById(R.id.TextView_QuantityLevel);
            defenseInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) defenseInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position){
            defense = getItem(position);

            // Setup Defense row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            defenseName.setText(defense.name);
            defensePhoto.setImageResource(defense.image);
            defensePrice.setText("" + defense.price + " cr.");
            buyDefense.setOnClickListener(buyDefenseClick);
            defenseQuantity.setVisibility(View.VISIBLE);
            defenseQuantity.setText("" + defense.quantity);

            // Setup Defense info
            TextView TextView_infoName = (TextView) infoView.findViewById(R.id.TextView_infoName);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            atk = (TextView) infoView.findViewById(R.id.TextView_Attack);
            def = (TextView) infoView.findViewById(R.id.TextView_Defense);
            hp = (TextView) infoView.findViewById(R.id.TextView_Hp);
            speed = (TextView) infoView.findViewById(R.id.TextView_Speed);
            infoNumberBuy = (NumberPicker) infoView.findViewById(R.id.infoNumberBuy);

            infoBuyDefense = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoBuyDefense.setOnClickListener(infoBuyDefenseClick);
            infoCancelDefense = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelDefense.setOnClickListener(infoCancelDefenseClick);

            infoNumberBuy.setMaxValue(99);
            infoNumberBuy.setMinValue(1);
            infoNumberBuy.setValue(1);
            infoNumberBuy.setWrapSelectorWheel(true);
            setNumberPickerTextColor(infoNumberBuy, Color.argb(255, 175, 255, 248));
            TextView_infoName.setText(defense.name);
            ImageView_infoPhoto.setImageResource(defense.image);
            TextView_infoDescription.setText(defense.description);
            atk.setText("" + defense.stats.atk);
            def.setText("" + defense.stats.def);
            hp.setText("" + defense.stats.hp);
            speed.setText("" + defense.stats.speed);

            defenseInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);
        }

        private View.OnClickListener infoDefenseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
            }
        };

        private View.OnClickListener buyDefenseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!buyDefenseAction(DefensesAdapter.ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                else
                    Snackbar.make(v, "1 defense was bought!", Snackbar.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener infoBuyDefenseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int defensesBought = 0;
                int defensesToBuy = infoNumberBuy.getValue();

                while (defensesBought < defensesToBuy){
                    if(!buyDefenseAction(DefensesAdapter.ViewHolder.this)){
                        if(defensesBought == 0){
                            Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                            infoView.setVisibility(View.GONE);
                            return;
                        }
                        else{
                                Snackbar.make(v, "It was only possible to buy " + defensesBought + " defenses!" , Snackbar.LENGTH_SHORT).show();
                                infoView.setVisibility(View.GONE);
                                return;
                            }
                    }
                    defensesBought++;
                }
                if(defensesToBuy == defensesBought){
                    if(defensesToBuy == 1)
                        Snackbar.make(v, "1 defense was bought!", Snackbar.LENGTH_SHORT).show();
                    else
                        Snackbar.make(v, defensesBought + " defenses were bought!", Snackbar.LENGTH_SHORT).show();
                    infoView.setVisibility(View.GONE);
                    return;
                }
            }
        };

        private View.OnClickListener infoCancelDefenseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };
    }

    private boolean buyDefenseAction(DefensesAdapter.ViewHolder viewHolder){
        UserInfo userInfo = MainContext.INSTANCE.getUserI();
        Defense defense = viewHolder.defense;

        if(userInfo.money >= userInfo.allPlanets.get(0).mapOfDefenses.get(defense.key).price){
            // Update Info
            userInfo.money -= userInfo.allPlanets.get(0).mapOfDefenses.get(defense.key).price;
            int quant = userInfo.allPlanets.get(0).mapOfDefenses.get(defense.key).quantity++;
            // Update Layout
            viewHolder.currentMoney.setText("" + userInfo.money);
            viewHolder.defenseQuantity.setText(""  + (quant+1));
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
