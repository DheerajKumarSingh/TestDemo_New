package com.example.dheeraj.testdemo.service;

import android.app.Activity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dheeraj.testdemo.R;


import java.util.ArrayList;

/**
 * Created by DHEERAJ on 5/10/2017.
 */

public class Adapter_User_List extends RecyclerView.Adapter {

    Activity mactivity;
    LayoutInflater layoutInflater;


    public Adapter_User_List(Activity mactivity) {
        this.mactivity=mactivity;

        layoutInflater=LayoutInflater.from(mactivity);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserViewHolder viewHolder;
        View view=layoutInflater.inflate(R.layout.adapter_item_user,null);
        viewHolder=new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        UserViewHolder viewHolder=(UserViewHolder)holder;

    }

    @Override
    public int getItemCount() {
        return 20;
    }


    private class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView img_user;
        TextView tv_user_name;
        AppCompatCheckBox cb;

        public UserViewHolder(View itemView) {
            super(itemView);
            tv_user_name=(TextView)itemView.findViewById(R.id.tv_user_name);
            img_user=(ImageView)itemView.findViewById(R.id.img_user);
            cb=(AppCompatCheckBox)itemView.findViewById(R.id.checkbox);
        }
    }



}
