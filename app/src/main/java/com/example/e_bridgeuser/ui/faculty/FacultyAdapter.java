package com.example.e_bridgeuser.ui.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_bridgeuser.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.FacultyViewAdapter> {
    String category;
    private ArrayList<FacultyData> arrayList;
    private Context context;

    public FacultyAdapter(ArrayList<FacultyData> arrayList, Context context) {
        this.arrayList = arrayList;
        //this.category = category;
        this.context = context;
    }

    @NonNull
    @Override
    public FacultyViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(context).inflate(R.layout.faculty_data_layout, parent, false);

        return new FacultyViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewAdapter holder, int position) {
        final FacultyData item = arrayList.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        try {
            Picasso.get().load(item.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(context, UpdateFacultyActivity.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("email", item.getEmail());
                intent.putExtra("post", item.getPost());
                intent.putExtra("image", item.getImage());
                intent.putExtra("key", item.getKey());
                intent.putExtra("category", category);
                context.startActivity(intent);*/

                Toast.makeText(context, "Update Faculty", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class FacultyViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;
        private Button update;
        private ImageView imageView;

        public FacultyViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.facultyName);
            email = itemView.findViewById(R.id.facultyEmail);
            post = itemView.findViewById(R.id.facultyPost);
            imageView = itemView.findViewById(R.id.facultyImage);
            update = itemView.findViewById(R.id.askDoubtButton);
        }
    }
}
