package com.moco.wonchu.iwantyoucook;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        Button search = (Button)findViewById(R.id.searchBtn);
        Button market = (Button)findViewById(R.id.marketBtn);
        Button recipe = (Button)findViewById(R.id.recipeBtn);
        Button profile= (Button)findViewById(R.id.profileBtn);

        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(0);

        View.OnClickListener movePageListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                int tag = (int)view.getTag();
                pager.setCurrentItem(tag);
            }
        };

        search.setOnClickListener(movePageListener);
        search.setTag(0);
        market.setOnClickListener(movePageListener);
        market.setTag(1);
        recipe.setOnClickListener(movePageListener);
        recipe.setTag(2);
        profile.setOnClickListener(movePageListener);
        profile.setTag(3);
    }

    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(FragmentManager fm )
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    return new CookFragment();
                case 1:
                    return new MarketFragment();
                case 2:
                    return new BookFragment();
                case 3:
                    return new ProfileFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // total page count
            return 4;
        }
    }
}


/*
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabhost = getTabHost();
        Intent intent;
        TabSpec spec;

        intent= new Intent().setClass(this, CookFragment.class);
        spec = tabhost.newTabSpec("TAB1").setIndicator("", getResources().getDrawable(R.drawable.ic_chef));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent= new Intent().setClass(this, MarketFragment.class);
        spec = tabhost.newTabSpec("TAB2").setIndicator("", getResources().getDrawable(R.drawable.ic_shopping_cart));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent= new Intent().setClass(this, BookFragment.class);
        spec = tabhost.newTabSpec("TAB3").setIndicator("", getResources().getDrawable(R.drawable.ic_recipe));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent= new Intent().setClass(this, ProfileFragment.class);
        spec = tabhost.newTabSpec("TAB4").setIndicator("", getResources().getDrawable(R.drawable.ic_cooker));
        spec.setContent(intent);
        tabhost.addTab(spec);

        tabhost.setCurrentTab(0);
    }
}
*/