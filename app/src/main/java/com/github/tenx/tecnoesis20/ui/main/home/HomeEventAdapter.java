package com.github.tenx.tecnoesis20.ui.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;


import java.util.ArrayList;


public class HomeEventAdapter extends RecyclerView.Adapter<HomeEventAdapter.HomeEventViewHolder>{

    private ArrayList<String> mImageUrl = new ArrayList<>();
    private ArrayList<String> mTitleName = new ArrayList<>();
    private ArrayList<String> mDate = new ArrayList<>();
    private Context mContext;

    public HomeEventAdapter(Context mContext,ArrayList<String> mImageUrl, ArrayList<String> mTitleName, ArrayList<String> mDate) {
        this.mImageUrl = mImageUrl;
        this.mTitleName = mTitleName;
        this.mDate = mDate;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HomeEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_home,parent,false);
        HomeEventViewHolder holder = new HomeEventViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeEventViewHolder holder, int position) {
        Glide.with(mContext)
        .asBitmap()
        .load(mImageUrl.get(position))
        .into(holder.posterImageView);
        holder.titleTextView.setText(mTitleName.get(position));
        holder.descriptionTextView.setText(mDate.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitleName.size();
    }

    public class HomeEventViewHolder extends RecyclerView.ViewHolder{

        ImageView posterImageView;
        TextView titleTextView;
        TextView descriptionTextView;
        public HomeEventViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView = itemView.findViewById(R.id.card_home_img_poster);
            titleTextView = itemView.findViewById(R.id.card_home_tv_title);
            descriptionTextView = itemView.findViewById(R.id.card_home_tv_description);
        }
    }
}


