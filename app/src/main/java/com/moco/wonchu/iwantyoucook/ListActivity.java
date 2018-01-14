package com.moco.wonchu.iwantyoucook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Chaewon on 2017-12-06.
 */

public class ListActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent= getIntent();
        if(intent.getIntExtra("BUTTON_ID",0)==1) //pressed button 'korean'
             {
            ListView list = (ListView) findViewById(R.id.list);
            //한식 레시피를 리스트뷰에 띄운다
        }

        else if(intent.getIntExtra("BUTTON_ID",0)==2)
        //pressed button 'asian'
            {
            ListView list = (ListView) findViewById(R.id.list);
            //동양식 레시피를 리스트뷰에 띄운다
        }

        else if(intent.getIntExtra("BUTTON_ID",0)==3)
        //pressed button 'western'
        {
            ListView list = (ListView) findViewById(R.id.list);
            //서양식 레시피를 리스트뷰에 띄운다
        }

        else
            //pressed button 'favorite'
            {
            ListView list = (ListView) findViewById(R.id.list);
            //별표 레시피를 리스트뷰에 띄운다. 초기는 "There is no favorite recipe existing"
        }
    }
}
