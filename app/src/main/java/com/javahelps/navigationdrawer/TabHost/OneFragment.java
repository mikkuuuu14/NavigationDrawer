package com.javahelps.navigationdrawer.TabHost;



import android.content.Intent;
import android.support.v4.app.Fragment;
/**
 * Created by Cedric on 8/14/2016.
 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
;import com.javahelps.navigationdrawer.R;


public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

    View view = inflater.inflate(R.layout.onefragment, container, false);

    button = (Button) view.findViewById(R.id.mikko);

    button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(getActivity(), micahinfo.class);
            getActivity().startActivity(intent);

        }

    });
    return view;
}

}
