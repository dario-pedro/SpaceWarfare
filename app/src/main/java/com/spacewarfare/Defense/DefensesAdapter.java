package com.spacewarfare.Defense;

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

        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.default_info_row, null, false);
        Defense singleDefenseItem = getItem(position);
        holder.setParameters(singleDefenseItem);

        return convertView;
    }

    private class ViewHolder {
        private TextView defenseName;
        private Button buyDefense;
        private TextView defensePrice;
        private Button infoDefense;
        private ImageView defense;
        private TextView defenseQuantity;

        private RelativeLayout defenseInfoLayout;
        public View infoView;
        Button infoLeftButton;
        Button infoRightButton;

        public ViewHolder(View convertView) {
            this.defenseName = (TextView) convertView.findViewById(R.id.TextView_Name);
            this.buyDefense = (Button) convertView.findViewById(R.id.Button_Buy);
            this.defensePrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            this.infoDefense = (Button) convertView.findViewById(R.id.Button_Info);
            this.infoDefense.setOnClickListener(infoDefenseClick);
            this.defense = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.defenseQuantity = (TextView) convertView.findViewById(R.id.TextView_Quantity);
            this.defenseInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
        }

        public void setParameters(Defense singleDefenseItem){
            this.defenseName.setText(singleDefenseItem.name);
            this.defense.setImageResource(singleDefenseItem.image);
            this.defensePrice.setText("Price: " + singleDefenseItem.price + " cr.");
            this.buyDefense.setText("BUY");
            if(singleDefenseItem.quantity>0){
                this.defenseQuantity.setVisibility(View.VISIBLE);
                this.defenseQuantity.setText("Quantity: " + singleDefenseItem.quantity);
            }
            else
                this.defenseQuantity.setVisibility(View.GONE);

            defenseInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);
        }

        private View.OnClickListener infoDefenseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
                //Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
