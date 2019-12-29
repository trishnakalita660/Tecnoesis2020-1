package com.github.tenx.tecnoesis20.ui.main.home;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.EventResponse;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
//    google fragment lifecycle or https://developer.android.com/guide/components/fragments if you are unsure about how to use fragment lifecycle

    private HomeViewModel mViewModel;


ArrayList<events> events;
    ArrayList<SponsorsList> sponsersList;

    @BindView(R.id.recycler_home_events)
    RecyclerView recyclerView;

    @BindView((R.id.slider_home_events))
    SliderView sliderView;
    @BindView(R.id.recycler_sponsors_home_events)
    RecyclerView recyclerView2;


    private HomeAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
   private SponsorsAdapter adapter2;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, parent);

        initModuleRecycler();
        initSlider();
        initSponsorsRecycler();
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
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
    private void initModuleRecycler() {
        events=new ArrayList<>();
        events.add(new events("MODULES","Tecnoesis 2020 presents before you an amazing and alluring blende of events and modules. Dive straight into the world of techies and ignite the innovative genius within you. Particapate in workshops to discover exciting new topics.",R.drawable.digital));
        events.add(new events("NITS HACKS 3.0","It is all about providing the fanatics with the flavour of the emerging technical aspects of many real life applications. With the idea of binding pack of celebrated minds into the same platform, the team will be conducting Hackatons and coding competitions to bring out the best in the tech geeks!",R.drawable.digital));
        events.add(new events("SPARK","The coup de grace event of the annual techno-management festivals. Culminating the end of festivities in form of a musical extravaganza, Spark is the spectacle to behold. From edm artists to classical artists, from rock bands to solo singers,the Spark night truly covers the art of production and provides the drive to feature the elite artists of the present generation.",R.drawable.digital));


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new HomeAdapter(getActivity(), events);
        recyclerView.setAdapter(adapter);
    }

    private void initSlider() {
        SliderAdapter adapter = new SliderAdapter(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
    }


    private void initSponsorsRecycler() {

        sponsersList=new ArrayList<>();
        sponsersList.add(new SponsorsList(R.drawable.digital));
        sponsersList.add(new SponsorsList(R.drawable.digital));
        sponsersList.add(new SponsorsList(R.drawable.digital));

        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setHasFixedSize(true);

        recyclerView2.setLayoutManager(layoutManager);
        adapter2 = new SponsorsAdapter(getActivity(),sponsersList);
        recyclerView2.setAdapter(adapter2);
    }
}
