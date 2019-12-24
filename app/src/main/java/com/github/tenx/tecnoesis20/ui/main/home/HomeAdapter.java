package com.github.tenx.tecnoesis20.ui.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;


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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_home_events,parent,false);
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

        @BindView(R.id.iv_home_event_image)
        ImageView imageView;
        @BindView(R.id.tv_home_module_title)
        TextView textView;
        @BindView(R.id.tv_home_description)
        TextView textView2;

        public ImageViewHOlder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}

