package com.moco.wonchu.iwantyoucook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonStart = (Button) findViewById(R.id.buttonstart); //R.id.buttonStart 해서 버튼 이름을 똑같이 해버리면 이게 int가 아니고 button으로 인지해서 안 됨.

        //displaying logged in user name
        textViewUserEmail.setText("Welcome! Thousands of recipes are ready for you...");

        //adding listener to button
        buttonStart.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
    }

    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (view == buttonStart) {
            finish();
            startActivity(new Intent(this, MainActivity.class));

        }
    }
}
