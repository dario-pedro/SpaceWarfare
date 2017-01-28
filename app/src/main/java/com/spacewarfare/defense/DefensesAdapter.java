package com.spacewarfare.defense;

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
import com.spacewarfare.building.Building;
import com.spacewarfare.building.BuildingsAdapter;

import org.w3c.dom.Text;

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
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.default_info_row, null, false);
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

        public ViewHolder(View convertView) {
            defenseName = (TextView) convertView.findViewById(R.id.TextView_Name);
            buyDefense = (Button) convertView.findViewById(R.id.Button_Buy);
            defensePrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            infoDefense = (Button) convertView.findViewById(R.id.Button_Info);
            infoDefense.setOnClickListener(infoDefenseClick);
            defensePhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            defenseQuantity = (TextView) convertView.findViewById(R.id.TextView_Quantity);
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
            TextView_infoName.setText(defense.name);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            ImageView_infoPhoto.setImageResource(defense.image);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            TextView_infoDescription.setText(defense.description);
            infoBuyDefense = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoBuyDefense.setOnClickListener(infoBuyDefenseClick);
            infoCancelDefense = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelDefense.setOnClickListener(infoCancelDefenseClick);
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
            }
        };

        private View.OnClickListener infoBuyDefenseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!buyDefenseAction(DefensesAdapter.ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                infoView.setVisibility(View.GONE);
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

}
