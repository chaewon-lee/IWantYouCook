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

    @Override
    protected void onStart(){
        super.onStart();

        RecipeFragment recipeFragment = new RecipeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.root_layout, recipeFragment, recipeFragment.getTag()).commit();

    }
}