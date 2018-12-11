package com.example.hp.finalproject.MainActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp.finalproject.MainActivity.Fragments.FragmentGallery;
import com.example.hp.finalproject.MainActivity.Fragments.FragmentHome;
import com.example.hp.finalproject.MainActivity.Fragments.FragmentNotes;

public class Items_Viewpager_market extends FragmentPagerAdapter {
    public Items_Viewpager_market(FragmentManager fm) {
        super(fm);

    }

    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentNotes.newInstance();
            case 1:
                return FragmentGallery.newInstance();
            case 2:
                return FragmentHome.newInstance();
            default:
                return FragmentHome.newInstance();
        }
    }

}
