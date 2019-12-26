package com.github.tenx.tecnoesis20.ui.main.events;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.github.tenx.tecnoesis20.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsFragment extends Fragment {

    @BindView(R.id.modules_grid)
    GridView modulesGrid;


    private EventsViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, parent);
        initModuleGrid(getContext());

        return parent;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EventsViewModel.class);
        // TODO: Use the ViewModel
    }


    private void initModuleGrid(Context context){
        ModuleGridAdapter adapter = new ModuleGridAdapter(context);
        modulesGrid.setNumColumns(2);
        modulesGrid.setAdapter(adapter);
    }

}
