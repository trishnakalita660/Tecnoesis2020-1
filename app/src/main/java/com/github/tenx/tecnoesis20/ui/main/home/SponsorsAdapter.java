package com.github.tenx.tecnoesis20.ui.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.ImageViewHOlder> {

    private Context tcontext;
    private ArrayList<SponsorsList> hlist;

    public SponsorsAdapter(Context tcontext, ArrayList<SponsorsList> hlist) {
        this.tcontext = tcontext;
        this.hlist = hlist;
    }

    @NonNull
    @Override
    public ImageViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_sponsors_item,parent,false);
        return new ImageViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHOlder holder, final int position) {
        holder.imageView.setImageResource(hlist.get(position).getSponsersImages());

    }

    @Override
    public int getItemCount()
    {
        return hlist.size();
    }







    public  class ImageViewHOlder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_sponsors_home_events)
        CircleImageView imageView;


        public ImageViewHOlder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
