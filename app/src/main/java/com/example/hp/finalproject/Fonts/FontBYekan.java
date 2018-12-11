package com.example.hp.finalproject.Fonts;

import android.app.Application;

import com.example.hp.finalproject.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class FontBYekan extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("Fonts/BYekan.ttf")
        .setFontAttrId(R.attr.font)
        .build());
    }
}
