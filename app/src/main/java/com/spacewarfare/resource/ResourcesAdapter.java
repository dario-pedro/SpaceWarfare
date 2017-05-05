package com.spacewarfare.resource;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.spacewarfare.MainContext;
import com.spacewarfare.R;
import com.spacewarfare.others.UserInfo;

import java.util.List;

import cn.iwgang.countdownview.CountdownView;

import static java.lang.Thread.sleep;



/**
 * Created by DidierRodriguesLopes on 04/02/17.
 */

public class ResourcesAdapter extends ArrayAdapter<Resource> {

    final int maxProgress = 100;
    final int secToMS = 1000;

    public ResourcesAdapter(Context context, List<Resource> resources) {
        super(context, R.layout.resource_row, resources);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ResourcesAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_row, parent, false);

          /*  if(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfBuildings.get(R.string.key_Building_Mine).level > position)
                convertView.setVisibility(View.VISIBLE);
            else
                convertView.setVisibility(View.GONE);*/

            holder = new ResourcesAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ResourcesAdapter.ViewHolder) convertView.getTag();

           /* if(MainContext.INSTANCE.getUserI().allPlanets.get(0).mapOfBuildings.get(R.string.key_Building_Mine).level > position)
                convertView.setVisibility(View.VISIBLE);
            else
                convertView.setVisibility(View.GONE);*/
        }

        parent.findViewById(R.id.moneyTextView);
        holder.infoView = LayoutInflater.from(getContext()).inflate(R.layout.building_research_info_row, null, false);
        holder.setParameters(position);

        return convertView;
    }

    private class ViewHolder{
        private TextView resourceName;
        private Button upgradeResource;
        private TextView priceToUpgradeResource;
        private Button infoResource;
        private ImageView resourcePhoto;
        private TextView resourceLevel;
        private TextView crystalsReceived;
        //private TextView timerResource;

        private RelativeLayout resourceInfoLayout;
        public Resource resource;
        public TextView currentMoney;

        public View infoView;
        private Button infoUpgradeResource;
        private Button infoCancelResource;
        private CountdownView timerResource;
        private RoundCornerProgressBar progressBarResource;

        private Handler vHandler;

        public ViewHolder(View convertView) {

            vHandler = new Handler();

            resourceName = (TextView) convertView.findViewById(R.id.TextView_NameResource);
            upgradeResource = (Button) convertView.findViewById(R.id.Button_UpgradeResource);
            priceToUpgradeResource = (TextView) convertView.findViewById(R.id.TextView_PriceResource);
            infoResource = (Button) convertView.findViewById(R.id.Button_InfoResource);
            infoResource.setOnClickListener(infoResourceClick);
            resourcePhoto = (ImageView) convertView.findViewById(R.id.ImageView_PhotoResource);
            resourceLevel = (TextView) convertView.findViewById(R.id.TextView_LevelResource);
            crystalsReceived = (TextView) convertView.findViewById(R.id.TextView_CrystalsReceived);
            //timerResource = (TextView) convertView.findViewById(R.id.TextView_TimerResource);
            timerResource = (CountdownView)convertView.findViewById(R.id.timerResource);
            progressBarResource = (RoundCornerProgressBar) convertView.findViewById(R.id.progressBarResource);
            resourceInfoLayout = (RelativeLayout) (MainContext.INSTANCE.getMainActivity()).findViewById(R.id.geralRelativeLayout);
            currentMoney = (TextView) resourceInfoLayout.findViewById(R.id.moneyTextView);
        }

        public void setParameters(int position) {
            resource = getItem(position);

            // Setup Building row
            currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
            resourceName.setText(resource.name);
            resourceName.setOnClickListener(extractingResourceClick);
            resourcePhoto.setImageResource(resource.image);
            priceToUpgradeResource.setText("" + resource.priceLevel);
            resourceLevel.setText("" + resource.level);
            crystalsReceived.setText("" + resource.crystalsLevel);
            upgradeResource.setOnClickListener(upgradeResourceClick);
            //timerResource.setOnClickListener(extractResourceClick);
            timerResource.updateShow(resource.secondsTimer*secToMS);
            timerResource.setOnClickListener(extractingResourceClick);
            timerResource.setOnCountdownEndListener(extractResourceClick);
            progressBarResource.setOnClickListener(extractingResourceClick);

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
                if(!upgradeResourceAction(ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
            }
        };

        private View.OnClickListener infoUpgradeResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!upgradeResourceAction(ViewHolder.this))
                    Snackbar.make(v, "Not enough money!", Snackbar.LENGTH_SHORT).show();
                infoView.setVisibility(View.GONE);
            }
        };

        private View.OnClickListener infoCancelResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoView.setVisibility(View.GONE);
            }
        };

        private CountdownView.OnCountdownEndListener extractResourceClick = new CountdownView.OnCountdownEndListener() {
            @Override
            public void onEnd(CountdownView cv) {
                progressBarResource.setProgress(maxProgress);
                Snackbar.make(cv, resource.crystalsLevel + " crystals were earned!", Snackbar.LENGTH_SHORT).show();
                MainContext.INSTANCE.getUserI().money += ViewHolder.this.resource.crystalsLevel;
                ViewHolder.this.currentMoney.setText("" + MainContext.INSTANCE.getUserI().money);
                timerResource.updateShow(resource.secondsTimer*secToMS);
                progressBarResource.setProgress(0);
            }
        };

        private View.OnClickListener extractingResourceClick = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                timerResource.start(resource.secondsTimer*secToMS);

                // Start lengthy operation in a background thread
                new Thread(new Runnable() {
                    public void run() {
                        while (progressBarResource.getProgress() < maxProgress) {
                            try {
                                sleep(1000);
                                // Update the progress bar
                                progressBarResource.post(new Runnable() {
                                    public void run() {
                                        progressBarResource.setProgress((maxProgress*(resource.secondsTimer - timerResource.getSecond()))/resource.secondsTimer);
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }

        };

        private boolean upgradeResourceAction(ResourcesAdapter.ViewHolder viewHolder){
            UserInfo userInfo = MainContext.INSTANCE.getUserI();

            if(userInfo.money >= viewHolder.resource.priceLevel){
                // Update Info
                userInfo.money -= viewHolder.resource.priceLevel;
                // Update Layout
                viewHolder.currentMoney.setText("" + userInfo.money);
                viewHolder.resource.setLevelTransition();
                viewHolder.resourceLevel.setText(""  + (viewHolder.resource.level));
                viewHolder.priceToUpgradeResource.setText("" + viewHolder.resource.priceLevel);
                viewHolder.crystalsReceived.setText("" + viewHolder.resource.crystalsLevel);
                return true;
            }
            return false;
        }
    }
}
