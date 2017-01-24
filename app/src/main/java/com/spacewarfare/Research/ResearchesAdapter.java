package com.spacewarfare.Research;

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

public class ResearchesAdapter extends ArrayAdapter<Research> {

    public ResearchesAdapter(Context context, List<Research> researches) {
        super(context, R.layout.default_row, researches);
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

        public View infoView;
        //private RelativeLayout geralRelativeLayout;

        public ViewHolder(View convertView) {
            this.researchName = (TextView) convertView.findViewById(R.id.TextView_Name);
            this.buyResearch = (Button) convertView.findViewById(R.id.Button_Buy);
            this.researchPrice = (TextView) convertView.findViewById(R.id.TextView_Price);
            this.infoResearch = (Button) convertView.findViewById(R.id.Button_Info);
            this.infoResearch.setOnClickListener(infoResearchClick);
            this.research = (ImageView) convertView.findViewById(R.id.ImageView_Photo);
            this.researchChecked = (ImageView) convertView.findViewById(R.id.ImageView_Checked);
        }

        public void setParameters(Research singleResearchItem){
            this.researchName.setText(singleResearchItem.name);
            this.research.setImageResource(singleResearchItem.image);

            if(!singleResearchItem.owned){
                this.researchPrice.setText("Price: " + singleResearchItem.price + " cr.");
                this.buyResearch.setText("BUY");
            }
            else{
                this.researchChecked.setImageResource(R.drawable.checked);
                this.buyResearch.setText("OWNED");
            }
        }

        private View.OnClickListener infoResearchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //infoView.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "ZIMBORAAA, amanhã há mais", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
