package com.example.ThirdAssignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wbv.R;
import com.example.ThirdAssignment.model.Students;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {
    private Context context;
    private List<Students> studentsList;

    public StudentsAdapter(Context context, List<Students> studentsList) {
        this.context = context;
        this.studentsList = studentsList;
    }
    @NonNull
    @Override
    public StudentsAdapter.StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_cardview,parent,false);
        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.StudentsViewHolder holder, final int position) {
        Students students = studentsList.get(position);
        holder.imgStudent.setImageResource(students.getImgId());
        holder.tvStudentName.setText(students.getName());
        holder.tvStudentAge.setText(students.getAge());
        holder.tvStudentAddress.setText(students.getAddress());
        holder.tvStudentGender.setText(students.getGender());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentsList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }
    public class StudentsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgStudent;
        ImageButton imgDelete;
        TextView tvStudentName, tvStudentAge, tvStudentAddress, tvStudentGender;


        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgStudent = itemView.findViewById(R.id.imgStudent);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvStudentAge = itemView.findViewById(R.id.tvStudentAge);
            tvStudentAddress = itemView.findViewById(R.id.tvStudentAddress);
            tvStudentGender = itemView.findViewById(R.id.tvStudentGender);
        }
    }
}
