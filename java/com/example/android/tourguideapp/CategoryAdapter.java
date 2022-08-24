package com.example.android.tourguideapp;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FoodsFragment();
        }
           else if (position == 1)
           {
            return new HistoricalPlacesFragment();
        }
           else if (position == 2)
           {
            return new HotelsFragment();
        }
           else
           {
            return new ShoppingPlacesFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
    String [] tabTitle = mContext.getResources().getStringArray(R.array.tabLayoutTitles);
        return tabTitle[position];
}

}
