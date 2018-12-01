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
public class CouponsFragment extends Fragment {

    String[] strings = {"1", "2", "3", "4", "5", "6", "7"};

    public CouponsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_coupons, container, false);
    }




}
