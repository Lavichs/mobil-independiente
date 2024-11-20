package com.example.independentwork_v23;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PagesMenu extends Fragment {
    Button btn7, btn11, btn12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pages_menu, container, false);
        btn7 = rootView.findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        btn11 = rootView.findViewById(R.id.button11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Catalog.class);
                startActivity(intent);
            }
        });
//        btn12 = rootView.findViewById(R.id.button12);
//        btn12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Record.class);
//                startActivity(intent);
//            }
//        });
//        return inflater.inflate(R.layout.fragment_pages_menu, container, false);
        return rootView;
    }
}