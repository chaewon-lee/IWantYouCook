package com.moco.wonchu.iwantyoucook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

/**
 * Created by Chaewon on 2018-01-22.
 */

public class CookFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,

                             @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_cook,

                container, false);

        SeekBar seekBar= (SeekBar)layout.findViewById(R.id.seekBar);

        Button easy = (Button) layout.findViewById(R.id.easy);
        Button medium = (Button) layout.findViewById(R.id.medium);
        Button hard = (Button) layout.findViewById(R.id.hard);
        Button search = (Button) layout.findViewById(R.id.search);


        EditText ing1 = (EditText) layout.findViewById(R.id.ingr1);
        EditText ing2 = (EditText) layout.findViewById(R.id.ingr2);
        EditText ing3 = (EditText) layout.findViewById(R.id.ingr3);
        EditText ing4 = (EditText) layout.findViewById(R.id.ingr4);
        EditText ing5 = (EditText) layout.findViewById(R.id.ingr5);



        return layout;
    }

}


