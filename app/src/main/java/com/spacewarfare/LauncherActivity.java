package com.spacewarfare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.spacewarfare.login.LoginActivity;
import com.spacewarfare.utils.ServerConstants;


public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final TextView tv = (TextView) findViewById(R.id.launcher_text_Space);
        final TextView tvD = (TextView) findViewById(R.id.launcher_text_Warfa);

        final Animation rotate = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        final Animation fade = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        iv.startAnimation(rotate);

        rotate.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(fade);
                tv.startAnimation(fade);
                tvD.startAnimation(fade);

                finish();
                Intent i = (ServerConstants.require_login) ?
                        new Intent(getBaseContext(),LoginActivity.class)
                        :new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
