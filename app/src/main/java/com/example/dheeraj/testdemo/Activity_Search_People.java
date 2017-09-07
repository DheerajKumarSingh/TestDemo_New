package com.example.dheeraj.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by DHEERAJ on 8/25/2017.
 */

public class Activity_Search_People extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_people);
        findViews();
    }

    RecyclerView recyclerview;
    GridLayoutManager gridLayoutManager;
    PicHolder picHolder;
    private void findViews() {
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        gridLayoutManager=new GridLayoutManager(Activity_Search_People.this,2);
        recyclerview.setLayoutManager(gridLayoutManager);
        picHolder=new PicHolder(Activity_Search_People.this);
        recyclerview.setAdapter(picHolder);


        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,
                HORIZONTAL);
        DividerItemDecoration dividerItemDecoration1=new DividerItemDecoration(this,
                VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.background));
        dividerItemDecoration1.setDrawable(getResources().getDrawable(R.drawable.background));
        recyclerview.setHasFixedSize(true);
    }
}
