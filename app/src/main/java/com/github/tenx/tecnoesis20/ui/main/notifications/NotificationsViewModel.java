package com.github.tenx.tecnoesis20.ui.main.notifications;

import androidx.lifecycle.ViewModel;

import com.github.tenx.tecnoesis20.data.models.NotificationBody;

import java.util.ArrayList;
import java.util.List;

public class NotificationsViewModel extends ViewModel {
    // TODO: Implement the ViewModel



    public List<NotificationBody> getNotifications(){
        List<NotificationBody> list = new ArrayList<>();
        list.add(new NotificationBody("Jhon 1" , "My awesome title" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien velit, aliquet eget commodo nec, auctor a sapien. Nam eu neque vulputate diam rhoncus faucibus. Curabitur quis varius libero. Lorem.", "https://i.pravatar.cc/301"));
        list.add(new NotificationBody("Jhon 1" , "My awesome title" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien velit, aliquet eget commodo nec, auctor a sapien. Nam eu neque vulputate diam rhoncus faucibus. Curabitur quis varius libero. Lorem.", "https://i.pravatar.cc/300"));
        list.add(new NotificationBody("Jhon 1" , "My awesome title" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien velit, aliquet eget commodo nec, auctor a sapien. Nam eu neque vulputate diam rhoncus faucibus. Curabitur quis varius libero. Lorem.", "https://i.pravatar.cc/302"));
        list.add(new NotificationBody("Jhon 1" , "My awesome title" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien velit, aliquet eget commodo nec, auctor a sapien. Nam eu neque vulputate diam rhoncus faucibus. Curabitur quis varius libero. Lorem.", "https://i.pravatar.cc/303"));
        list.add(new NotificationBody("Jhon 1" , "My awesome title" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien velit, aliquet eget commodo nec, auctor a sapien. Nam eu neque vulputate diam rhoncus faucibus. Curabitur quis varius libero. Lorem.", "https://i.pravatar.cc/305"));
        list.add(new NotificationBody("Jhon 1" , "My awesome title" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien velit, aliquet eget commodo nec, auctor a sapien. Nam eu neque vulputate diam rhoncus faucibus. Curabitur quis varius libero. Lorem.", "https://i.pravatar.cc/304"));
        return list;
    }

}







