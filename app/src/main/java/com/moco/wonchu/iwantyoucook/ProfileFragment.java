package com.moco.wonchu.iwantyoucook;

/**
 * Created by lg on 2018-01-24.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Chaewon on 2017-11-28.
 */

public class ProfileFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,

                             @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_profile,

                container, false);


        Button btAccount = (Button) layout.findViewById(R.id.btAccount);
        btAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.btAccount:
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });

        return layout;
    }
}