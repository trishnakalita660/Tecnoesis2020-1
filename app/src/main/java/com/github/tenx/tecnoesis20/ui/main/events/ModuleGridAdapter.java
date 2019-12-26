package com.github.tenx.tecnoesis20.ui.main.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;

import java.util.ArrayList;
import java.util.List;

public class ModuleGridAdapter extends BaseAdapter {

//    2 column  matrix
    private class ModuleItem {
        String name;
        String image;
        String description;


    public ModuleItem(String name, String image) {
        this.name = name;
        this.image = image;
        description = "";
    }

    public ModuleItem() {
    }

    public ModuleItem(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

    private List<ModuleItem> listModules;

    private Context context;


    public ModuleGridAdapter(Context context) {
        this.context = context;
        listModules = new ArrayList<>();
        listModules.add(new ModuleItem("Robotron" , "https://robohash.org/12"));
        listModules.add(new ModuleItem("NITS Hacks" , "https://robohash.org/123"));
        listModules.add(new ModuleItem("Showcase" , "https://robohash.org/124"));
        listModules.add(new ModuleItem("Spark" , "https://robohash.org/125"));
        listModules.add(new ModuleItem("Speeches" , "https://robohash.org/126"));
        listModules.add(new ModuleItem("Business Quiz" , "https://robohash.org/12678"));
    }

    @Override
    public int getCount() {
        return listModules.size();
    }

    @Override
    public Object getItem(int position) {
        return listModules.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




            View v = LayoutInflater.from(context).inflate(R.layout.griditem_module_item, parent, false);

            ImageView moduleImage = v.findViewById(R.id.iv_events_module_image);
            TextView  moduleName = v.findViewById(R.id.tv_events_module_name);

            Glide.with(context).load(listModules.get(position).getImage()).into(moduleImage);
            moduleName.setText(listModules.get(position).getName().toUpperCase());



        return v;
    }
}
