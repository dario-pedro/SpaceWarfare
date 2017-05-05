package com.spacewarfare.research;

import android.content.Context;
import android.support.design.widget.Snackbar;
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
import com.spacewarfare.others.UserInfo;


import java.util.List;

/**
 * Created by DidierRodriguesLopes on 23/01/17.
 */

public class ResearchesAdapter extends ArrayAdapter<Research> {

    public ResearchesAdapter(Context context, List<Research> researches) {
        super(context, R.layout.default_row, researches);
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
        private TextView researchName;
        private Button buyResearch;
        private TextView researchPrice;
        private Button infoResearch;
        private ImageView researchPhoto;
        private ImageView researchChecked;

        private RelativeLayout researchInfoLayout;
        public Research research;
        public TextView currentMoney;

        public View infoView;
        private Button infoBuyResearch;
        private Button infoCancelResearch;

        public ViewHolder(View convertView) {
            researchName = (TextView) convertView.findViewById(R.id.TextView_Name);
            buyResearch = (Button) convertView.findViewById(R.id.Button_Buy);
            researchPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            infoResearch = (Button) convertView.findViewById(R.id.Button_Info);
            infoResearch.setOnClickListener(infoResearchClick);
            researchPhoto = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            researchChecked = (ImageView) convertView.findViewById(R.id.ImageView_Checked);
            researchInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) researchInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position){
            research = getItem(position);

            // Setup Research row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            researchName.setText(research.name);
            researchPhoto.setImageResource(research.image);
            researchPrice.setText("" + research.price + " cr.");
            buyResearch.setOnClickListener(buyResearchClick);
            researchChecked.setImageResource(R.drawable.checked);

            // Setup Research info
            TextView TextView_infoName = (TextView) infoView.findViewById(R.id.TextView_infoName);
            TextView_infoName.setText(research.name);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            ImageView_infoPhoto.setImageResource(research.image);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            TextView_infoDescription.setText(research.description);
            infoBuyResearch = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoBuyResearch.setOnClickListener(infoBuyResearchClick);
            infoCancelResearch = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelResearch.setOnClickListener(infoCancelResearchClick);
            researchInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);

            if(research.owned){
                researchChecked.setVisibility(View.VISIBLE);
                infoBuyResearch.setText("OWNED");
                buyResearch.setText("OWNED");
            }
            else{
                researchChecked.setVisibility(View.GONE);
                buyResearch.setText("BUY");
            }

        }

        private View.OnClickListener infoResearchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
            }
        };

        private View.OnClickListener buyResearchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(research.owned)
                    Snackbar.make(v, "You already have this research!", Snackbar.LENGTH_SHORT).show();
                else
                if(!buyResearchAction(ResearchesAdapter.ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener infoBuyResearchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(research.owned)
                    Snackbar.make(v, "You already have this research!", Snackbar.LENGTH_SHORT).show();
                else
                if(!buyResearchAction(ResearchesAdapter.ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                infoView.setVisibility(View.GONE);
            }
        };

        private View.OnClickListener infoCancelResearchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };
    }

    private boolean buyResearchAction(ResearchesAdapter.ViewHolder viewHolder){
        UserInfo userInfo = MainContext.INSTANCE.getUserI();
        Research research = viewHolder.research;

        if(userInfo.money >= userInfo.allPlanets.get(0).mapOfResearches.get(research.key).price){
            // Update Info
            userInfo.money -= userInfo.allPlanets.get(0).mapOfResearches.get(research.key).price;
            userInfo.allPlanets.get(0).mapOfResearches.get(research.key).owned = true;
            // Update Layout
            viewHolder.currentMoney.setText("" + userInfo.money);
            viewHolder.researchChecked.setVisibility(View.VISIBLE);
            viewHolder.buyResearch.setText("OWNED");
            viewHolder.infoBuyResearch.setText("OWNED");
            return true;
        }

        return false;
    }


}

