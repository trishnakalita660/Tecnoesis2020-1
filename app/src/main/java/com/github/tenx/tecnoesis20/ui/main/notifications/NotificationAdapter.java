//package com.github.tenx.tecnoesis20.ui.main.notifications;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.github.tenx.tecnoesis20.R;
//import com.github.tenx.tecnoesis20.data.models.NotificationBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.CustomViewHolder> {
//
//
//    private List<NotificationBody> mList;
//
//    private Context context;
//    public NotificationAdapter() {
//        mList = new ArrayList<>();
//    }
//
//    @NonNull
//    @Override
//    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        this.context = parent.getContext();
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_notifications_body, parent, false);
//
//        return new CustomViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
//            NotificationBody currentNotif = mList.get(position);
//
//            Glide.with(context).load(currentNotif.getImage()).into(holder.civNotificationitemImage);
//            holder.tvNotificationitemSenderName.setText(currentNotif.getSender());
//            holder.tvNotificationitemSubject.setText(currentNotif.getTitle());
//            holder.tvNotificationitemMessage.setText(currentNotif.getMessage());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mList.size();
//    }
//
//    class CustomViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.civ_notificationitem_image)
//        CircleImageView civNotificationitemImage;
//        @BindView(R.id.tv_notificationitem_sender_name)
//        TextView tvNotificationitemSenderName;
//        @BindView(R.id.tv_notificationitem_subject)
//        TextView tvNotificationitemSubject;
//        @BindView(R.id.tv_notificationitem_message)
//        TextView tvNotificationitemMessage;
//
//
//        public CustomViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this , itemView);
//
//        }
//    }
//
//    public void setmList(List<NotificationBody> mList) {
//        this.mList = mList;
//        notifyDataSetChanged();
//    }
//}
