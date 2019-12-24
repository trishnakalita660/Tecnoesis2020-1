package com.github.tenx.tecnoesis20.ui.main.home;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.EventResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
//    google fragment lifecycle or https://developer.android.com/guide/components/fragments if you are unsure about how to use fragment lifecycle

    private HomeViewModel mViewModel;

    @BindView(R.id.iv_home_banner_image)
    ImageView imageView;

List<events> events;
    @BindView(R.id.recycler_home_events)
    RecyclerView recyclerView;



    private HomeAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, parent);

        events=new ArrayList<>();
        events.add(new events("MODULES","Tecnoesis 2020 presents before you an amazing and alluring blende of events and modules. Dive straight into the world of techies and ignite the innovative genius within you. Particapate in workshops to discover exciting new topics.",R.drawable.digital));

        events.add(new events("NITS HACKS 3.0","It is all about providing the fanatics with the flavour of the emerging technical aspects of many real life applications. With the idea of binding pack of celebrated minds into the same platform, the team will be conducting Hackatons and coding competitions to bring out the best in the tech geeks!",R.drawable.digital));

        events.add(new events("SPARK","The coup de grace event of the annual techno-management festivals. Culminating the end of festivities in form of a musical extravaganza, Spark is the spectacle to behold. From edm artists to classical artists, from rock bands to solo singers,the Spark night truly covers the art of production and provides the drive to feature the elite artists of the present generation.",R.drawable.digital));


        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new HomeAdapter(getActivity(),events);
        recyclerView.setAdapter(adapter);



        return parent;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel this is for demo delete this later
        mViewModel.loadEvents();


    }

    @Override
    public void onStart() {
        super.onStart();

//        @TODO how to call view model demo

        mViewModel.getEvents().observe(this, eventsResponse -> {
//            display result
            for (EventResponse res : eventsResponse) {
//                mImageUrls.add(res.getImageUrl());
//                mDates.add(res.getDate());
//                mTitles.add(res.getName());
            }
//            initRecyclerView();
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

//    private void initRecyclerView() {
//        HomeEventAdapter adapter = new HomeEventAdapter(getActivity(), mImageUrls, mTitles, mDates);
//        cardRecyclerView.setAdapter(adapter);
//        cardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//    }


}
