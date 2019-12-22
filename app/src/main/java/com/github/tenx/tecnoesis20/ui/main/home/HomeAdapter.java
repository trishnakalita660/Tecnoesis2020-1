package com.github.tenx.tecnoesis20.ui.main.home;

import android.content.Context;
import android.content.Intent;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.ui.main.events.EventsFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ImageViewHOlder> {

    private Context tcontext;
    private List<events> hlist;

    public HomeAdapter(Context tcontext, List<events> hlist) {
        this.tcontext = tcontext;
        this.hlist = hlist;
    }

    @NonNull
    @Override
    public ImageViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home,parent,false);
        return new ImageViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHOlder holder, final int position) {
        holder.textView.setText(hlist.get(position).getEventsNames());
        holder.textView2.setText(hlist.get(position).getDescription());
        holder.imageView.setImageResource(hlist.get(position).getImages());

    }

    @Override
    public int getItemCount()
    {
        return hlist.size();
    }


    public  class ImageViewHOlder extends RecyclerView.ViewHolder{

        @BindView(R.id.home_image)
        ImageView imageView;
        @BindView(R.id.Modules)
        TextView textView;
        @BindView(R.id.Description)
        TextView textView2;

        public ImageViewHOlder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}

