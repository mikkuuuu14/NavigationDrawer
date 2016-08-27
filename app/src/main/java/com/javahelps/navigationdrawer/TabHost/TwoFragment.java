package com.javahelps.navigationdrawer.TabHost;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.javahelps.navigationdrawer.R;


/**
 * Created by Cedric on 8/14/2016.
 */
public class TwoFragment extends Fragment {

    public TwoFragment() {
        // Required empty public constructor
    }
    Button af;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.twofragment, container, false);

        af = (Button) view.findViewById(R.id.af);
        af.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), allaninfo.class);
                getActivity().startActivity(intent);

            }

        });
        return view;
    }
}




