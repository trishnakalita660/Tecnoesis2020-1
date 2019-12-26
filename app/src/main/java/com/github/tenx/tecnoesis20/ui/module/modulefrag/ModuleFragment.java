package com.github.tenx.tecnoesis20.ui.module.modulefrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.Utils;
import com.github.tenx.tecnoesis20.data.models.ModuleBody;
import com.github.tenx.tecnoesis20.ui.module.ModuleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModuleFragment extends Fragment {


    @BindView(R.id.recycler_module_event_list)
    RecyclerView recyclerModuleEventList;


    private ModuleViewModel mViewModel;

    private EventAdapter adapter;


    public static ModuleFragment newInstance() {
        return new ModuleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_module, container, false);
        ButterKnife.bind(this, v);


        try {
            Bundle args = getArguments();
            int index = args.getInt(ModuleActivity.PAGE_INDEX_KEY);

            ModuleBody testdata = Utils.getModules().get(index);

            initData(testdata, getActivity());


        } catch (NullPointerException e) {
            throw new Error("Did not receive page index in bundle!");
        }


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ModuleViewModel.class);
        // TODO: Use the ViewModel
    }


    private void initData(ModuleBody data, Context context) {
        adapter = new EventAdapter(context , data);
        recyclerModuleEventList.setLayoutManager(new LinearLayoutManager(context));

        recyclerModuleEventList.setNestedScrollingEnabled(false);
        recyclerModuleEventList.setAdapter(adapter);

    }


}
