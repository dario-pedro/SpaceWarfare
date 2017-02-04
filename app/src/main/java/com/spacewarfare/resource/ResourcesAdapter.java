package com.spacewarfare.resource;

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
import com.spacewarfare.UserInfo;
import com.spacewarfare.building.Building;
import com.spacewarfare.building.BuildingsAdapter;

import java.util.List;

/**
 * Created by DidierRodriguesLopes on 04/02/17.
 */

public class ResourcesAdapter extends ArrayAdapter<Resource> {

    public ResourcesAdapter(Context context, List<Resource> resources) {
        super(context, R.layout.resource_row, resources);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ResourcesAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_row, parent, false);

            if(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfBuildings.get(R.string.key_Building_Mine).level <= position)
                convertView.setVisibility(View.GONE);
            else
                convertView.setVisibility(View.VISIBLE);

            holder = new ResourcesAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ResourcesAdapter.ViewHolder) convertView.getTag();

            if(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfBuildings.get(R.string.key_Building_Mine).level <= position)
                convertView.setVisibility(View.GONE);
            else
                convertView.setVisibility(View.VISIBLE);
        }

        parent.findViewById(R.id.moneyTextView);
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.building_research_info_row, null, false);
        holder.setParameters(position);

        return convertView;
    }

    private class ViewHolder {
        private TextView resourceName;
        private Button upgradeResource;
        private TextView priceToUpgradeResource;
        private Button infoResource;
        private ImageView resourcePhoto;
        private TextView resourceLevel;
        private TextView crystalsReceived;

        private RelativeLayout resourceInfoLayout;
        public Resource resource;
        public TextView currentMoney;

        public View infoView;
        private Button infoUpgradeResource;
        private Button infoCancelResource;

        public ViewHolder(View convertView) {
            resourceName = (TextView) convertView.findViewById(R.id.TextView_NameResource);
            upgradeResource = (Button) convertView.findViewById(R.id.Button_UpgradeResource);
            priceToUpgradeResource = (TextView) convertView.findViewById(R.id.TextView_PriceResource);
            infoResource = (Button) convertView.findViewById(R.id.Button_InfoResource);
            infoResource.setOnClickListener(infoResourceClick);
            resourcePhoto = (ImageView) convertView.findViewById(R.id.ImageView_PhotoResource);
            resourceLevel = (TextView) convertView.findViewById(R.id.TextView_LevelResource);
            crystalsReceived = (TextView) convertView.findViewById(R.id.TextView_CrystalsReceived);
            resourceInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) resourceInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position) {
            resource = getItem(position);

            // Setup Building row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            resourceName.setText(resource.name);
            resourcePhoto.setImageResource(resource.image);
            priceToUpgradeResource.setText("" + resource.priceLevel);
            resourceLevel.setText("" + resource.level);
            crystalsReceived.setText("" + resource.crystalsLevel);
            upgradeResource.setOnClickListener(upgradeResourceClick);

            // Setup Building info
            TextView TextView_infoName = (TextView) infoView.findViewById(R.id.TextView_infoName);
            TextView_infoName.setText(resource.name);
            ImageView ImageView_infoPhoto = (ImageView) infoView.findViewById(R.id.ImageView_infoPhoto);
            ImageView_infoPhoto.setImageResource(resource.image);
            TextView TextView_infoDescription = (TextView) infoView.findViewById(R.id.TextView_infoDescription);
            TextView_infoDescription.setText(resource.description);
            infoUpgradeResource = (Button) infoView.findViewById(R.id.Button_infoBuy);
            infoUpgradeResource.setOnClickListener(infoUpgradeResourceClick);
            infoCancelResource = (Button) infoView.findViewById(R.id.Button_infoCancel);
            infoCancelResource.setOnClickListener(infoCancelResourceClick);
            resourceInfoLayout.addView(infoView);
            infoView.setVisibility(View.GONE);
            infoUpgradeResource.setText("UPGRADE");
        }

        private View.OnClickListener infoResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.VISIBLE);
            }
        };

        private View.OnClickListener upgradeResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };

        private View.OnClickListener infoUpgradeResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };

        private View.OnClickListener infoCancelResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };

    }
}
