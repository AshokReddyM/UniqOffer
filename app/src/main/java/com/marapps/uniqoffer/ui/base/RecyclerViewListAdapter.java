package com.marapps.uniqoffer.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.marapps.uniqoffer.R;
import com.marapps.uniqoffer.ui.home.ImageModel;

import java.util.ArrayList;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ShopsViewHolder> {

    private ArrayList<ImageModel> imageModelArrayList = new ArrayList<>();
    private Context context;

    public RecyclerViewListAdapter(ArrayList<ImageModel> horizontalList, Context context) {
        this.imageModelArrayList = horizontalList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(final ShopsViewHolder holder, final int position) {
        final ImageModel model = imageModelArrayList.get(position);
        ShopsViewHolder messageViewHolder = (ShopsViewHolder) holder;

        messageViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, model.getImageName() + " - " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ShopsViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        private ShopsViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);

            Glide.with(context).load("https://www.underconsideration.com/brandnew/archives/flipkart_logo_detail.jpg")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(RequestOptions.noTransformation().placeholder(R.drawable.offers_placeholder))
                    .into(imageView);
        }
    }

    @Override
    public ShopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_item, parent, false);
        return new ShopsViewHolder(itemView);
    }
}

