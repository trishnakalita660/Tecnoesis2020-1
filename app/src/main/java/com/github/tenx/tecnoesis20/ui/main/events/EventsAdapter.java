package com.github.tenx.tecnoesis20.ui.main.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;

import java.util.List;

import butterknife.ButterKnife;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ImageViewHolder> {
    Context mContext;
    List<EventsModel> elist;

    public EventsAdapter(Context mContext, List<EventsModel> edata) {
        this.mContext = mContext;
        this.elist = edata;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.listitem_events_list,parent,false);
        return new ImageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position)
    {
        holder.event_image.setImageResource(elist.get(position).getImage());

    }

    @Override
    public int getItemCount() {

        return elist.size();

    }

    public  static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView event_image;
        public  ImageViewHolder(@NonNull View itemView)
        {
            super(itemView);
            event_image=itemView.findViewById(R.id.image);
            ButterKnife.bind(this,itemView);
        }
    }
}