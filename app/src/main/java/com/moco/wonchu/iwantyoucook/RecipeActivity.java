package com.moco.wonchu.iwantyoucook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chaewon on 2017-11-11.
 */

public class RecipeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        ImageView img= (ImageView)findViewById(R.id.foodImg);
        TextView food= (TextView)findViewById(R.id.foodName);
        TextView recipe= (TextView)findViewById(R.id.recipe);

        //DB의 내용들을 각각의 View와 연동
    }

}
