package com.spacewarfare.research;

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

        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.default_info_row, null, false);
        Research singleResearchItem = getItem(position);
        holder.setParameters(singleResearchItem);

        return convertView;
    }

    private class ViewHolder {
        private TextView researchName;
        private Button buyResearch;
        private TextView researchPrice;
        private Button infoResearch;
        private ImageView research;
        private ImageView researchChecked;

        private RelativeLayout researchInfoLayout;
        public View infoView;
        Button infoLeftButton;
        Button infoRightButton;

        public ViewHolder(View convertView) {
            this.researchName = (TextView) convertView.findViewById(R.id.TextView_Name);
            this.buyResearch = (Button) convertView.findViewById(R.id.Button_Buy);
            this.researchPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            this.infoResearch = (Button) convertView.findViewById(R.id.Button_Info);
            this.infoResearch.setOnClickListener(infoResearchClick);
            this.research = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.researchChecked = (ImageView) convertView.findViewById(R.id.ImageView_Checked);
            this.researchInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
        }

        public void setParameters(Research singleResearchItem){
            this.researchName.setText(singleResearchItem.name);
            this.research.setImageResource(singleResearchItem.image);

            if(!singleResearchItem.owned){
                this.researchPrice.setText("Price: " + singleResearchItem.price + " cr.");
                this.buyResearch.setText("BUY");
                this.researchChecked.setVisibility(View.GONE);
            }
            else{
                this.researchChecked.setVisibility(View.VISIBLE);
                this.researchChecked.setImageResource(R.drawable.checked);
                this.buyResearch.setText("OWNED");
            }
            researchInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);
        }

        private View.OnClickListener infoResearchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
                //Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
