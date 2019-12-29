package com.github.tenx.tecnoesis20.ui.event.eventPage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.EventBody;
import com.github.tenx.tecnoesis20.ui.MyApplication;
import com.github.tenx.tecnoesis20.ui.event.EventActivity;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventPageFragment extends Fragment {


    private  int currentModuleIndex;
    private int currentEventIndex;
    private EventBody currentEvent;

    private MyApplication application;



    @BindView(R.id.iv_event_image)
    ImageView ivEventImage;
    @BindView(R.id.tv_event_title)
    TextView tvEventTitle;
    @BindView(R.id.tv_event_date)
    TextView tvEventDate;
    @BindView(R.id.btn_event_register)
    MaterialButton btnEventRegister;
    @BindView(R.id.tv_event_desc)
    TextView tvEventDesc;
    @BindView(R.id.tv_event_rules)
    TextView tvEventRules;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event_page, container, false);

        ButterKnife.bind(this, v);


//        get indexes
        try {

            currentEventIndex = getArguments().getInt(EventActivity.EVENT_INDEX_KEY);
            currentModuleIndex = getArguments().getInt(EventActivity.MODULE_INDEX_KEY);

        }catch (NullPointerException e){
            currentEventIndex = 0;
            currentModuleIndex = 0;
        }

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        application = (MyApplication) getActivity().getApplication();
    }

    @Override
    public void onStart() {
        super.onStart();
        currentEvent = application.getModuleList().get(currentModuleIndex).getEvents().get(currentEventIndex);
        initEvents(currentEvent , getActivity());
    }

    private void initEvents(EventBody data , Context context){
        tvEventDate.setText(data.getDate());
        tvEventDesc.setText(data.getDescription());
        tvEventTitle.setText(data.getName());
        Glide.with(context).load(data.getImage()).into(ivEventImage);
        tvEventRules.setText("");
        String temp = "";
        for(String text : data.getRules()){
            temp += text + "\n\n";

        }
        tvEventRules.setText(temp);


    }



}
