package com.retailboosters;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

public class SplashActivity extends Activity {
    ImageView companyIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.
                FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        companyIcon = findViewById(R.id.logo);
        companyIcon.postDelayed(new Runnable() {
            @Override
            public void run() {
                zoomLogoIn();
            }
        }, 1);

        /*Log.e("Step", " == " + Pref.loadIntPref(SplashActivity.this, Pref.REGISTRATION_STEP));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        new Handler().postDelayed(runnable, 3000);*/
    }

    void zoomLogoIn() {
        Animation bubbleAnim = AnimationUtils.loadAnimation(SplashActivity.this,
                R.anim.bubble_zoom_in_anim);
        bubbleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                zoomLogoOut();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        companyIcon.startAnimation(bubbleAnim);
    }

    void zoomLogoOut() {
        Animation bubbleAnim = AnimationUtils.loadAnimation(SplashActivity.this,
                R.anim.bubble_zoom_out_anim);
        bubbleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                companyIcon.setVisibility(View.VISIBLE);
                fadeInJataks();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        companyIcon.startAnimation(bubbleAnim);
    }

    void fadeInJataks() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(900);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Utils().callDropDownApi(SplashActivity.this);
                if (Pref.loadStringPref(SplashActivity.this, Pref.AUTH_TOKEN_KEY) != null &&
                        Pref.loadIntPref(SplashActivity.this, Pref.REGISTRATION_STEP) == 4) {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                preLoadData();

            }
        }, 2500);
        super.onPostCreate(savedInstanceState);
    }

    private void preLoadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                exitCompLogo();
            }
        }, 600);
    }

    private void exitCompLogo() {
        Animation zoomOut = new AlphaAnimation(1, 0);
        zoomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                companyIcon.setVisibility(View.INVISIBLE);
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        zoomOut.setDuration(500);
        companyIcon.startAnimation(zoomOut);


    }

}
