package com.marapps.uniqoffer.ui.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.marapps.uniqoffer.R;
import com.marapps.uniqoffer.ui.base.GridAdapter;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    SliderLayout sliderLayout;
    private HorizontalRecyclerViewAdapter horizontalAdapter;
    private LinearLayoutManager horizontalLayoutManager;
    private RecyclerView mShopsList;
    private RecyclerView mCategoriesList;
    private GridAdapter gridAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sliderLayout = getActivity().findViewById(R.id.imageSlider);
        mShopsList = getActivity().findViewById(R.id.rv_explore_by_shops_list);
        mCategoriesList = getActivity().findViewById(R.id.rv_explore_by_categories_list);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL);
        sliderLayout.setScrollTimeInSec(1);


        horizontalAdapter = new HorizontalRecyclerViewAdapter(fillWithData(), getActivity());
        horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mShopsList.setLayoutManager(horizontalLayoutManager);
        mShopsList.setAdapter(horizontalAdapter);


        String[] categories = new String[]{"Recharge", "Travel", "Fasion", "Food", "Electronics"};

        gridAdapter = new GridAdapter(getActivity(),categories );
        mCategoriesList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mCategoriesList.setAdapter(gridAdapter);


        setSliderViews();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(getActivity());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getActivity(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);


        }
    }


    public ArrayList<ImageModel> fillWithData() {
        ArrayList<ImageModel> imageModelArrayList = new ArrayList<>();
        ImageModel imageModel0 = new ImageModel();
        imageModel0.setId(System.currentTimeMillis());
        imageModel0.setImageName("Battle");
        imageModel0.setImagePath("https://www.underconsideration.com/brandnew/archives/flipkart_logo_detail.jpg");
        imageModelArrayList.add(imageModel0);


        ImageModel imageModel1 = new ImageModel();
        imageModel1.setId(System.currentTimeMillis());
        imageModel1.setImageName("Battle");
        imageModel1.setImagePath("https://www.underconsideration.com/brandnew/archives/flipkart_logo_detail.jpg");
        imageModelArrayList.add(imageModel0);


        ImageModel imageModel2 = new ImageModel();
        imageModel2.setId(System.currentTimeMillis());
        imageModel2.setImageName("Battle");
        imageModel2.setImagePath("https://www.underconsideration.com/brandnew/archives/flipkart_logo_detail.jpg");
        imageModelArrayList.add(imageModel0);


        ImageModel imageModel3 = new ImageModel();
        imageModel3.setId(System.currentTimeMillis());
        imageModel3.setImageName("Battle");
        imageModel3.setImagePath("https://www.underconsideration.com/brandnew/archives/flipkart_logo_detail.jpg");
        imageModelArrayList.add(imageModel0);


        return imageModelArrayList;
    }




}
