package com.example.e_bridgeuser.ui.notices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_bridgeuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NoticesFragment extends Fragment {

    RecyclerView noticeRecycler;
    ProgressBar progressBar;
    ArrayList<NoticeData> list;
    NoticeAdapter adapter;

    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notices, container, false);

        noticeRecycler = (RecyclerView) view.findViewById(R.id.noticeRecycler);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notice");

        //because it i a fragment so we will pass getContext();
        noticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        noticeRecycler.setHasFixedSize(true);

//creating a get notice method
        getNotice();
        return view;

    }

    private void getNotice() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    NoticeData data = snapshot1.getValue(NoticeData.class);
                    list.add(0, data);
                }
                // we need to pass context and the list to NoticeAdapter
                adapter = new NoticeAdapter(getContext(), list);
                adapter.notifyDataSetChanged();
                //progressbar removed when we get the data or when we fail to get the data
                progressBar.setVisibility(View.GONE);
                noticeRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
