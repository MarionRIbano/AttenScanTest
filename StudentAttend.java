package com.example.attenscantest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAttend extends RecyclerView.Adapter<StudentAttend.MyViewHolder> {
Context context;
ArrayList<Student> list;

public StudentAttend(Context context, ArrayList<Student> list){


    this.context = context;
    this.list = list;
}
    @NonNull
    @Override
    public StudentAttend.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.studentlist,parent,false);

    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAttend.MyViewHolder holder, int position) {

    Student student = list.get(position);
    holder.firstName.setText(student.getFirstName());
    holder.lastName.setText(student.getLastName());
    holder.Section.setText(student.getSection());
    holder.StudentNumber.setText(student.getStudentNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView firstName, lastName, Section, StudentNumber;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        firstName = itemView.findViewById( R.id.getfirstname );
        lastName = itemView.findViewById( R.id.getlastname );
        Section = itemView.findViewById( R.id.getsection );
        StudentNumber = itemView.findViewById( R.id.getstudentID );

    }
    }
}