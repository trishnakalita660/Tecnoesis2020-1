package com.github.tenx.tecnoesis20.ui.main.home;

import androidx.lifecycle.Observer;
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
import android.widget.TextView;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.EventResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {
//    google fragment lifecycle or https://developer.android.com/guide/components/fragments if you are unsure about how to use fragment lifecycle

    private HomeViewModel mViewModel;

//    @BindView(R.id.frag_home_tv_demo)
//    TextView tvDemo;

    @BindView(R.id.frag_home_rv_card)
    RecyclerView cardView;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent =  inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, parent);
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
        cardView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardView.setHasFixedSize(true);

        final HomeEventAdapter adapter = new HomeEventAdapter();
        cardView.setAdapter(adapter);

//        @TODO how to call view model demo

//        mViewModel.getEvents().observe(this, eventsResponse -> {
////            display result
//            String display = "";
//            for (EventResponse res : eventsResponse){
//                display += res.getName() + "\n";
//                display += res.getDate() + "\n";
//                display += res.getImageUrl() + "\n";
//                display += "-------------------------\n";
//            }
//            tvDemo.setText(display);
//        });
        mViewModel.getEvents().observe(this, new Observer<ArrayList<EventResponse>>() {
            @Override
            public void onChanged(ArrayList<EventResponse> eventResponses) {
                adapter.setEventResponse(eventResponses);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}
