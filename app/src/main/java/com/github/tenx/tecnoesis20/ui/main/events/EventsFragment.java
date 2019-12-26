package com.github.tenx.tecnoesis20.ui.main.events;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.ui.main.home.events;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsFragment extends Fragment {

    private EventsViewModel mViewModel;


    List<EventsModel> modules;
    @BindView(R.id.listitem_events_list)
    RecyclerView recyclerView;


    private EventsAdapter eventAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public static EventsFragment newInstance()
    {
        return new EventsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, parent);



        modules =new ArrayList<>();
        modules.add(new EventsModel(R.drawable.tecnoesis));
        modules.add(new EventsModel(R.drawable.digital));
        modules.add(new EventsModel(R.drawable.sky));
        modules.add(new EventsModel(R.drawable.digital));

        layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        eventAdapter=new EventsAdapter(getActivity(),modules);
        recyclerView.setAdapter(eventAdapter);

        return parent;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EventsViewModel.class);
        // TODO: Use the ViewModel
    }

}
