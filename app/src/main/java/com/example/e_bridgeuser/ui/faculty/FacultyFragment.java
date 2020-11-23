package com.example.e_bridgeuser.ui.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

public class FacultyFragment extends Fragment {


    RecyclerView cseDept, meDept, ceDept, eceDept, ccvDept, cyberDept, otherDept;
    LinearLayout cseNoData, meNoData, ceNoData, eceNoData, ccvNoData, cyberNoData, otherNoData;
    ArrayList<FacultyData> list1, list2, list3, list4, list5, list6, list7;
    FacultyAdapter adapter;

    DatabaseReference databaseReference, dbref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        cseDept = (RecyclerView) view.findViewById(R.id.cseDept);
        meDept = (RecyclerView) view.findViewById(R.id.meDept);
        eceDept = (RecyclerView) view.findViewById(R.id.eceDept);
        ceDept = (RecyclerView) view.findViewById(R.id.ceDept);
        otherDept = (RecyclerView) view.findViewById(R.id.otherDept);
        ccvDept = (RecyclerView) view.findViewById(R.id.ccvDept);
        cyberDept = (RecyclerView) view.findViewById(R.id.cyberDept);

        cyberNoData = (LinearLayout) view.findViewById(R.id.cyberNoData);
        cseNoData = (LinearLayout) view.findViewById(R.id.cseNoData);
        eceNoData = (LinearLayout) view.findViewById(R.id.eceNoData);
        ceNoData = (LinearLayout) view.findViewById(R.id.ceNoData);
        ccvNoData = (LinearLayout) view.findViewById(R.id.ccvNoData);
        meNoData = (LinearLayout) view.findViewById(R.id.meNoData);
        otherNoData = (LinearLayout) view.findViewById(R.id.otherNoData);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Faculty");

        cseDepartment();
        eceDepartment();
        meDepartment();
        ceDepartment();
        otherDepartment();
        cyberDepartment();
        ccvDepartment();

        return view;


    }

    private void cseDepartment() {
        dbref = databaseReference.child("B Tech CSE");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDept.setVisibility(View.GONE);
                } else {

                    cseNoData.setVisibility(View.GONE);
                    cseDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list1.add(data);

                    }
                    cseDept.setHasFixedSize(true);
                    cseDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list1, getContext());
                    cseDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eceDepartment() {
        dbref = databaseReference.child("B Tech ECE");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDept.setVisibility(View.GONE);
                } else {

                    eceNoData.setVisibility(View.GONE);
                    eceDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list2.add(data);

                    }
                    eceDept.setHasFixedSize(true);
                    eceDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list2, getContext());
                    eceDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbref = databaseReference.child("B Tech ME");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    meNoData.setVisibility(View.VISIBLE);
                    meDept.setVisibility(View.GONE);
                } else {

                    meNoData.setVisibility(View.GONE);
                    meDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list3.add(data);

                    }
                    meDept.setHasFixedSize(true);
                    meDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list3, getContext());
                    meDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartment() {
        dbref = databaseReference.child("B Tech CE");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    ceNoData.setVisibility(View.VISIBLE);
                    ceDept.setVisibility(View.GONE);
                } else {

                    ceNoData.setVisibility(View.GONE);
                    ceDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list4.add(data);

                    }
                    ceDept.setHasFixedSize(true);
                    ceDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list4, getContext());
                    ceDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void otherDepartment() {
        dbref = databaseReference.child("Other Branch");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    otherNoData.setVisibility(View.VISIBLE);
                    otherDept.setVisibility(View.GONE);
                } else {

                    otherNoData.setVisibility(View.GONE);
                    otherDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list7.add(data);

                    }
                    otherDept.setHasFixedSize(true);
                    otherDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list7, getContext());
                    otherDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ccvDepartment() {
        dbref = databaseReference.child("B Tech CCV");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    ccvNoData.setVisibility(View.VISIBLE);
                    ccvDept.setVisibility(View.GONE);
                } else {

                    ccvNoData.setVisibility(View.GONE);
                    ccvDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list5.add(data);

                    }
                    ccvDept.setHasFixedSize(true);
                    ccvDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list5, getContext());
                    ccvDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cyberDepartment() {
        dbref = databaseReference.child("B Tech Cyber Security");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if (!snapshot.exists()) {//agar exist karta hai to faculty hai lekin agar nahi kart ahai to no faculty found vala xml file use hoga
                    cyberNoData.setVisibility(View.VISIBLE);
                    cyberDept.setVisibility(View.GONE);
                } else {

                    cyberNoData.setVisibility(View.GONE);
                    cyberDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        FacultyData data = snapshot1.getValue(FacultyData.class);
                        list6.add(data);

                    }
                    cyberDept.setHasFixedSize(true);
                    cyberDept.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new FacultyAdapter(list6, getContext());
                    cyberDept.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}