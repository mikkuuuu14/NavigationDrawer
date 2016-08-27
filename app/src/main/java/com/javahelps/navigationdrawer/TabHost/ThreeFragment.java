package com.javahelps.navigationdrawer.TabHost;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Cedric on 8/14/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.javahelps.navigationdrawer.R;


public class ThreeFragment extends Fragment{

    public ThreeFragment() {
        // Required empty public constructor
    }
    Button ced;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.threefragment, container, false);

        ced = (Button) view.findViewById(R.id.ced);
        ced.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), cedricinfo.class);
                getActivity().startActivity(intent);

            }

        });
        return view;
    }

}