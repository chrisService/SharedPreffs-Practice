package com.example.geekguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {


    public TabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        TextView textView = rootView.findViewById(R.id.textViewTab);


        if(getArguments() != null){
            String mainTab = getArguments().getString("TAB");
            textView.setText(mainTab);
        }


        ImageButton slika = rootView.findViewById(R.id.tube);
        slika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/Vsauce"));
                startActivity(intent);
            }
        });


        return rootView;
    }

}
