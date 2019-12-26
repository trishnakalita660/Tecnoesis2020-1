package com.github.tenx.tecnoesis20.ui.main.notifications;

import androidx.lifecycle.ViewModel;

import com.github.tenx.tecnoesis20.data.models.NotificationBody;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class NotificationsViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private FirebaseDatabase db;
    public NotificationsViewModel() {
        db = FirebaseDatabase.getInstance();
    }





}







