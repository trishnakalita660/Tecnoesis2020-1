package com.github.tenx.tecnoesis20.ui.main.events;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.Config;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.Utils;
import com.github.tenx.tecnoesis20.data.models.ModuleBody;
import com.github.tenx.tecnoesis20.ui.module.ModuleActivity;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModuleRecyclerAdapter extends RecyclerView.Adapter<ModuleRecyclerAdapter.CustomViewHolder> {


    class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_module_image)
        ImageView ivEventsModuleImage;
        @BindView(R.id.tv_module_name)
        TextView tvEventsModuleName;

        @BindView(R.id.tv_module_description)
        TextView tvModuleDescription;
        @BindView(R.id.btn_events_module_item_read_more)
        MaterialButton btnModuleItemReadMore;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private Context context;
    private List<ModuleBody> listModules;

//    2 column  matrix


    public ModuleRecyclerAdapter(Context context) {
        this.context = context;
        listModules = new ArrayList<>();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listitem_module_item, parent, false);


        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        ModuleBody currentItem = listModules.get(position);
        Glide.with(context).load(currentItem.getImage()).into(holder.ivEventsModuleImage);
        holder.tvEventsModuleName.setText(currentItem.getName().toUpperCase());

        holder.btnModuleItemReadMore.setOnClickListener(v -> {
            changeActivity(position);
        });
    }

    @Override
    public int getItemCount() {
        return listModules.size();
    }

    private void changeActivity(int position){
        Intent intent = new Intent(context , ModuleActivity.class);
        intent.putExtra(Config.INITIAL_PAGE, position);
        context.startActivity(intent);
    }


    public void setListModules(List<ModuleBody> listModules) {
        this.listModules = listModules;
        notifyDataSetChanged();
    }
}
