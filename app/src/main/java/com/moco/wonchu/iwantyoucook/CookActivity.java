package com.moco.wonchu.iwantyoucook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Chaewon on 2017-11-28.
 */

public class CookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);

        TextView text= (TextView)findViewById(R.id.textView);
        TextView time= (TextView)findViewById(R.id.time);
        TextView level= (TextView)findViewById(R.id.level);

        EditText ing1= (EditText)findViewById(R.id.ingr1);
        EditText ing2= (EditText)findViewById(R.id.ingr2);
        EditText ing3= (EditText)findViewById(R.id.ingr3);
        EditText ing4= (EditText)findViewById(R.id.ingr4);
        EditText ing5= (EditText)findViewById(R.id.ingr5);

        SeekBar seekBar= (SeekBar)findViewById(R.id.seekBar);

        Button easy= (Button)findViewById(R.id.easy);
        Button medium= (Button)findViewById(R.id.medium);
        Button hard= (Button)findViewById(R.id.hard);
    }
}
