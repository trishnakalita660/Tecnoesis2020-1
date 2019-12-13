package com.github.tenx.tecnoesis20.ui.main.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.EventResponse;

import java.util.ArrayList;
import java.util.List;

public class HomeEventAdapter extends RecyclerView.Adapter<HomeEventAdapter.HomeEventHolder> {
    private List<EventResponse> eventResponse = new ArrayList<>();

    @NonNull
    @Override
    public HomeEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_home,parent,false);
        return new HomeEventHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeEventHolder holder, int position) {
        EventResponse currentEventResponse = eventResponse.get(position);
        holder.titleTextView.setText(currentEventResponse.getName());
        //holder.posterImageView.setImageResource(currentEventResponse.getImageUrl());
        holder.descriptionTextView.setText(currentEventResponse.getDate());
    }

    @Override
    public int getItemCount() {
        return eventResponse.size();
    }
    //to change eventResponse
    public void setEventResponse(List<EventResponse> eventResponse){
        this.eventResponse = eventResponse;
        notifyDataSetChanged();
    }

    class HomeEventHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;
        private ImageView posterImageView;
        private TextView descriptionTextView;

        public HomeEventHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.card_home_tv_title);
            posterImageView = itemView.findViewById(R.id.card_home_img_poster);
            descriptionTextView = itemView.findViewById(R.id.card_home_tv_description);
        }
    }
}
