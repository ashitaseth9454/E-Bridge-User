package com.example.e_bridgeuser.ui.notices;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_bridgeuser.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {
    Context context;
    ArrayList<NoticeData> list;
   // private NoticeData item;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(context).inflate(R.layout.notice_layout, parent, false);
        return new NoticeViewAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, final int position) {
        final NoticeData item = list.get(position);
        holder.noticeTitle.setText(item.getTitle());
        holder.time.setText(item.getTime());
        holder.date.setText(item.getDate());
        try {
            if (item.getImage() != null)
                Picasso.get().load(item.getImage()).into(holder.noticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
//holder means the whole recycler virew layout and we are focusing on the button , delete button in the holder

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        TextView noticeTitle, date, time;
        ImageView noticeImage;


        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            noticeTitle = itemView.findViewById(R.id.noticeTitle);
            noticeImage = itemView.findViewById(R.id.noticeImage);
        }
    }

}
