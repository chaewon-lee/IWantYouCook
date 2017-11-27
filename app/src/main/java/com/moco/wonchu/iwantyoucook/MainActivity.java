package com.moco.wonchu.iwantyoucook;

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

        intent= new Intent().setClass(this, CookActivity.class);
        spec = tabhost.newTabSpec("TAB1").setIndicator("", getResources().getDrawable(R.drawable.ic_chef));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent= new Intent().setClass(this, MarketActivity.class);
        spec = tabhost.newTabSpec("TAB2").setIndicator("", getResources().getDrawable(R.drawable.ic_shopping_cart));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent= new Intent().setClass(this, RecipeActivity.class);
        spec = tabhost.newTabSpec("TAB3").setIndicator("", getResources().getDrawable(R.drawable.ic_recipe));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent= new Intent().setClass(this, ProfileActivity.class);
        spec = tabhost.newTabSpec("TAB4").setIndicator("", getResources().getDrawable(R.drawable.ic_cooker));
        spec.setContent(intent);
        tabhost.addTab(spec);

        tabhost.setCurrentTab(0);
    }
}