package com.moco.wonchu.iwantyoucook;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moco.wonchu.iwantyoucook.Helper.DBHelper;
import com.moco.wonchu.iwantyoucook.Model.CategoryItem;

import java.util.ArrayList;

/**
 * Created by Chaewon on 2017-11-29.
 */


public class BookFragment extends Fragment {
    public BookFragment() {
        // required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,

                             @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_book,

                container, false);

        DBHelper dbHelper = new DBHelper(getContext(), "Recipes.db", null, 1);
        final ArrayList<CategoryItem> categotyList = dbHelper.recipes_SelectCategory();


        ImageButton korean = (ImageButton) layout.findViewById(R.id.korean);
        ImageButton asian = (ImageButton) layout.findViewById(R.id.asian);
        ImageButton western = (ImageButton) layout.findViewById(R.id.western);
        ImageButton favorite = (ImageButton) layout.findViewById(R.id.favorite);

        TextView kortext = (TextView) layout.findViewById(R.id.koreanText);
        TextView asitext = (TextView) layout.findViewById(R.id.asianText);
        TextView westext = (TextView) layout.findViewById(R.id.westernText);
        TextView favtext = (TextView) layout.findViewById(R.id.favoriteText);


        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryItem selectCategory = categotyList.get(1);
                Intent intent = new Intent(getContext(), RecipeListActivity.class);
                intent.putExtra("category", selectCategory.get_category());
                startActivity(intent);
            }
        });

        asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryItem selectCategory = categotyList.get(0);
                Intent intent = new Intent(getContext(), RecipeListActivity.class);
                intent.putExtra("category", selectCategory.get_category());
                startActivity(intent);
            }
        });

        western.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryItem selectCategory = categotyList.get(2);
                Intent intent = new Intent(getContext(), RecipeListActivity.class);
                intent.putExtra("category", selectCategory.get_category());
                startActivity(intent);
            }
        });

       /* favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookFragment.this, ListActivity.class);
                intent.putExtra("BUTTON_ID", 4);
                startActivity(intent);
            }
        });*/

        return layout;
    }
}