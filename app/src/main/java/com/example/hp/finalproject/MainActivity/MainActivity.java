package com.example.hp.finalproject.MainActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.finalproject.R;

public class MainActivity extends AppCompatActivity {


    //Button gallery
    LinearLayout home;
    TextView tv_home;
    ImageView img_home;


    //Button notes
    LinearLayout Notes;
    TextView tv_notes;
    ImageView img_notes;

    //Button profile
    LinearLayout profile;
    TextView tv_profile;
    ImageView img_profile;



    Context conInst;
    NonSwipeableViewPager pager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conInst = this;



        img_profile = (ImageView) findViewById(R.id.img_profile);
        img_home = (ImageView) findViewById(R.id.img_home);
        img_notes = (ImageView) findViewById(R.id.img_notes);

        tv_profile = (TextView) findViewById(R.id.tv_profile);
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_notes = (TextView) findViewById(R.id.tv_notes);



        pager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        Items_Viewpager_market adapter_articles = new Items_Viewpager_market(getSupportFragmentManager());
        pager.setAdapter(adapter_articles);
        pager.setCurrentItem(4, false);
        pager.setOffscreenPageLimit(4);

        //defult property View
        tv_home.setVisibility(View.VISIBLE);



    }



    //Bottom Navigation
    public void onCLickHome(View v) {
        setVisibiltyBottomBar(tv_home);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        img_home.startAnimation(animation);
        tv_home.startAnimation(animation1);

        pager.setCurrentItem(0);
    }

    public void onCLickProfile(View v) {
        setVisibiltyBottomBar(tv_profile);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        img_profile.startAnimation(animation);
        tv_profile.startAnimation(animation1);

        pager.setCurrentItem(3);
    }


    public void onCLickNotes(View v) {
        setVisibiltyBottomBar(tv_notes);
        Animation animation = new TranslateAnimation(0, 0, 15, 0);
        Animation animation1 = new TranslateAnimation(0, 0, 70, 0);
        animation.setDuration(300);
        animation1.setDuration(200);
        img_notes.startAnimation(animation);
        tv_notes.startAnimation(animation1);

        pager.setCurrentItem(3);
    }




    //method set visible bottom bar
    public void setVisibiltyBottomBar(TextView tv) {
        tv_profile.setVisibility(View.GONE);
        tv_notes.setVisibility(View.GONE);
        tv_home.setVisibility(View.GONE);
        tv.setVisibility(View.VISIBLE);
    }
}
