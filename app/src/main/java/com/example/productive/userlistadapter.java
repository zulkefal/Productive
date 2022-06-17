package com.example.productive;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productive.db.User;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class userlistadapter extends RecyclerView.Adapter<userlistadapter.Viewholder> {

    private Context context;
    private List<User> list;

    public userlistadapter(Context context)
    {
        this.context=context;
    }


    public void setuserlist(List<User> list)
    {
        this.list=list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public userlistadapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.task_recieved,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userlistadapter.Viewholder holder, int position) {

            holder.dateTextView.setText(this.list.get(position).time);
            holder.taskTectView.setText(this.list.get(position).task);
            holder.descTectView.setText(this.list.get(position).descp);

//        holder.setTime(this.list.get(position).time);
//        holder.setTask(this.list.get(position).task);
//        holder.setDesc(this.list.get(position).descp);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView dateTextView,taskTectView,descTectView;
        View mView;

//        private Activity activity;
//        Context context;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
//            mView = itemView;
             dateTextView = itemView.findViewById(R.id.dateTv);
             taskTectView = itemView.findViewById(R.id.taskTv);
             descTectView = itemView.findViewById(R.id.descriptionTv);
        }

//        public void setTask(String task) {
//            TextView taskTectView = mView.findViewById(R.id.taskTv);
//            taskTectView.setText(task);
//        }
//        public void setDesc(String desc) {
//            TextView descTectView = mView.findViewById(R.id.descriptionTv);
//            descTectView.setText(desc);
//        }
//        public void setTime(String time) {
//            TextView dateTextView = mView.findViewById(R.id.dateTv);
//            dateTextView.setText(time);
//        }
//        public void setId(String date) {
//            TextView id = mView.findViewById(R.id.number);
//        }
    }
}
