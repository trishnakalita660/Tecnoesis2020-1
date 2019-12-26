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

import com.firebase.ui.common.ChangeEventType;
import com.firebase.ui.database.ChangeEventListener;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.NotificationBody;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class NotificationsFragment extends Fragment {

    @BindView(R.id.recycler_notifications_list)
    RecyclerView recyclerNotificationsList;

    private NotificationsViewModel mViewModel;


    private FirebaseNotificationAdapter adapter;


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

        recyclerNotificationsList.setLayoutManager(new LinearLayoutManager(ctx));


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("notifications")
                .limitToLast(50);
        FirebaseRecyclerOptions<NotificationBody> options =
                new FirebaseRecyclerOptions.Builder<NotificationBody>()
                        .setQuery(query, NotificationBody.class)
                        .build();
        adapter = new FirebaseNotificationAdapter(options);

        recyclerNotificationsList.setAdapter(adapter);

    }



    @Override
    public void onStart() {
        super.onStart();
        initAdapter(getActivity());
        adapter.startListening();
        adapter.getSnapshots().addChangeEventListener(new ChangeEventListener() {
            @Override
            public void onChildChanged(@NonNull ChangeEventType type, @NonNull DataSnapshot snapshot, int newIndex, int oldIndex) {
                Timber.e("Changed "+adapter.getItemCount());
            }

            @Override
            public void onDataChanged() {

            }

            @Override
            public void onError(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
