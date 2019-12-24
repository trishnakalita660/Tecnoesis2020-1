package com.github.tenx.tecnoesis20.ui.main.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsFragment extends Fragment {

    @BindView(R.id.recycler_notifications_list)
    RecyclerView recyclerNotificationsList;

    private NotificationsViewModel mViewModel;
    private NotificationAdapter adapter;


    public static NotificationsFragment newInstance() {
        return new NotificationsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_notifications, container, false);
        ButterKnife.bind(this , v);
        return v ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
        // TODO: Use the ViewModel
    }

    private  void initAdapter(Context ctx){
        adapter = new NotificationAdapter();
        recyclerNotificationsList.setLayoutManager(new LinearLayoutManager(ctx));
        recyclerNotificationsList.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        initAdapter(getActivity());
        adapter.setmList(mViewModel.getNotifications());

    }
}
