package com.example.productive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.productive.db.AddData;
import com.example.productive.db.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.List;

public class tasks extends AppCompatActivity {


    MaterialTimePicker picker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    userlistadapter adap;


    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        createNotificationChannel();

//       toolbar = (Toolbar) findViewById(R.id.tool);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Day Scheduler App");

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setReverseLayout(false);
//        linearLayoutManager.setStackFromEnd(true);
//        recyclerView.setHasFixedSize(true);
 //       recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        loader = new ProgressDialog(this);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.plus);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtask();
            }
        });

        adap=new userlistadapter(this);
        recyclerView.setAdapter(adap);

         loaduserlist();
    }

    private void addtask() {

        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View myView = inflater.inflate(R.layout.add_task_file, null);
        myDialog.setView(myView);
        final AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);
        // TextView id_i = myView.findViewById(R.id.number);
        EditText task_k = myView.findViewById(R.id.newtask);
        EditText description_n = myView.findViewById(R.id.desc);
        EditText time_t = myView.findViewById(R.id.time);
        Button save = myView.findViewById(R.id.savebutton);
        Button cancel = myView.findViewById(R.id.cancel_button);


            picker=new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setHour(12)
                    .setMinute(0)
                    .setTitleText("Select Alarm Time")
                    .build();
            picker.show(getSupportFragmentManager(),"ALARM");
            picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (picker.getHour() > 12) {


                        time_t.setText(String.format(picker.getHour()-12 +"  :  "+String.format("%02d",picker.getMinute())+ " PM "));

                 //       time_t.setText(String.format("%02d",(picker.getHour()-12)+"  :  "+String.format("%02d",picker.getMinute())+ " PM "));

                    }
                    else {

                        time_t.setText(picker.getHour()+"  :  "+picker.getMinute()+" AM ");
                    }

                    dialog.show();

                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            saveNewUser(time_t.getText().toString(),task_k.getText().toString(),description_n.getText().toString());

//                            calendar = Calendar.getInstance();
//                            calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
//                            calendar.set(Calendar.MINUTE,picker.getMinute());
//                            calendar.set(Calendar.SECOND,0);
//                            calendar.set(Calendar.MILLISECOND,0);
//                            dialog.dismiss();
                        }
                    });
                }
            });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }



    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            CharSequence name = "Daily Tasks";
            String description = "Channel for task";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel=new NotificationChannel("ALARM",name,importance);
            channel.setDescription(description);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void saveNewUser( String t, String ts, String dn)
    {
        AddData db=AddData.getDbInstance(this.getApplicationContext());
        User user=new User();
        user.time=t;
        user.task=ts;
        user.descp=dn;
        db.userDao().insertUser(user);
        finish();
    }


    private void loaduserlist()
    {
        AddData db=AddData.getDbInstance(this.getApplicationContext());
       List<User> user= db.userDao().getAllUsers();
       adap.setuserlist(user);
    }

}