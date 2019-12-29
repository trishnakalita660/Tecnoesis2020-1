package com.github.tenx.tecnoesis20.ui.main.events;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.ui.main.MainActivity;
import com.github.tenx.tecnoesis20.ui.main.MainViewModel;
import com.victor.loading.newton.NewtonCradleLoading;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsFragment extends Fragment {

    @BindView(R.id.recycler_events_list)
    RecyclerView recyclerView;

    MainViewModel parentViewModel;

    @BindView(R.id.progress_content)
    NewtonCradleLoading progressContent;


    private EventsViewModel mViewModel;
    private ModuleRecyclerAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, parent);
        initModuleRecycler(getContext());

        return parent;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EventsViewModel.class);
        // TODO: Use the ViewModel
        parentViewModel = ((MainActivity) getActivity()).getViewModel();
    }


    private void initModuleRecycler(Context context) {
        adapter = new ModuleRecyclerAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        parentViewModel.getModules().observe(getActivity(), data -> {
            adapter.setListModules(data);
        });

        parentViewModel.getIsModulesLoaded().observe(getActivity() , loaded -> {
            if(loaded){
                hideProgress();
            }else {
                showProgress();
            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();

    }


    private void showProgress(){
        progressContent.start();
        progressContent.setVisibility(View.VISIBLE);
    }

    private void hideProgress(){
        progressContent.stop();
        progressContent.setVisibility(View.GONE);
    }
}
