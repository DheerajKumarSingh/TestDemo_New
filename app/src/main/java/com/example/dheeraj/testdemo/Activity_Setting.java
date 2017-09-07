package com.example.dheeraj.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by DHEERAJ on 8/28/2017.
 */

public class Activity_Setting extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void click_Account_Setting(View view)
    {
        Intent intent=new Intent(Activity_Setting.this,Activity_Account_Setting.class);
        startActivity(intent);
    }

    public void click_Notification(View view)
    {
        Intent intent=new Intent(Activity_Setting.this,Activity_Notification_Setting.class);
        startActivity(intent);

    }
}
