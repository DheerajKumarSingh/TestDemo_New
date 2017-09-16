package com.example.dheeraj.testdemo.service;

import android.app.Activity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    ArrayList<Bean_Poke> arrayList;
    public      int lastCheckedPosition = -1;


    public Adapter_User_List(Activity mactivity, ArrayList<Bean_Poke> arrayList) {
        this.mactivity=mactivity;
        this.arrayList=arrayList;

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
        viewHolder.tv_user_name.setText(arrayList.get(position).getTitle());
        viewHolder.radiobtn.setChecked(position == lastCheckedPosition);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    private class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView img_user;
        TextView tv_user_name;
     //   AppCompatCheckBox cb;
        RadioButton radiobtn;

        public UserViewHolder(View itemView) {
            super(itemView);
            tv_user_name=(TextView)itemView.findViewById(R.id.tv_user_name);
            img_user=(ImageView)itemView.findViewById(R.id.img_user);
         //   cb=(AppCompatCheckBox)itemView.findViewById(R.id.checkbox);
            radiobtn=(RadioButton)itemView.findViewById(R.id.radiobtn);
            tv_user_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lastCheckedPosition = getAdapterPosition();
                    //because of this blinking problem occurs so
                    //i have a suggestion to add notifyDataSetChanged();
                    //   notifyItemRangeChanged(0, list.length);//blink list problem
                    notifyDataSetChanged();
                }
            });
            radiobtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastCheckedPosition = getAdapterPosition();
                    //because of this blinking problem occurs so
                    //i have a suggestion to add notifyDataSetChanged();
                    //   notifyItemRangeChanged(0, list.length);//blink list problem
                    notifyDataSetChanged();

                }
            });
        }
    }



}
