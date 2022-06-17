package com.example.productive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.productive.db.AddData;
import com.example.productive.db.User;

import java.util.List;

public class dashboard extends AppCompatActivity {
    ImageView task_1,task_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        task_1=(ImageView) findViewById(R.id.day);
        task_2=(ImageView) findViewById(R.id.groc);
//        signout=(TextView) findViewById(R.id.signout);


        task_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(dashboard.this, tasks.class);
                startActivity(intent);
            }
        });

        task_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(dashboard.this, grocerylist.class);
//                startActivity(intent);
            }
        });
    }

}