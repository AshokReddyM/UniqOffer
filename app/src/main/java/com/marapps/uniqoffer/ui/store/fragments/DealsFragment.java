package com.marapps.uniqoffer.ui.store.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marapps.uniqoffer.R;
import com.marapps.uniqoffer.ui.store.adapters.CouponsDealsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DealsFragment extends Fragment {

    String[] strings = {"1", "2", "3", "4", "5", "6", "7"};

    public DealsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new CouponsDealsAdapter(strings));
        return inflater.inflate(R.layout.fragment_deals, container, false);
    }


    public static DealsFragment newInstance(String text) {

        DealsFragment f = new DealsFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
