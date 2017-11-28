package com.moco.wonchu.iwantyoucook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Chaewon on 2017-11-29.
 */

public class BookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ImageButton korean= (ImageButton)findViewById(R.id.korean);
        ImageButton asian= (ImageButton)findViewById(R.id.asian);
        ImageButton western= (ImageButton)findViewById(R.id.western);
        ImageButton favorite= (ImageButton)findViewById(R.id.favorite);

        TextView kortext= (TextView)findViewById(R.id.koreanText);
        TextView asitext= (TextView)findViewById(R.id.asianText);
        TextView westext= (TextView)findViewById(R.id.westernText);
        TextView favtext= (TextView)findViewById(R.id.favoriteText);
    }
}
