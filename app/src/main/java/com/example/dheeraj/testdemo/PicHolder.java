package com.example.dheeraj.testdemo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by DHEERAJ on 8/25/2017.
 */

public class PicHolder extends RecyclerView.Adapter {

    Activity mcontext;
    LayoutInflater layoutInflater;
    ArrayList<Uri> uriList;


    PicHolder(Activity mcontext) {
        this.mcontext = mcontext;
        this.uriList = uriList;
        layoutInflater = LayoutInflater.from(mcontext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_img_grid, null);
        ViewHolder_Images viewHolder_images = new ViewHolder_Images(view);
        return viewHolder_images;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder_Images viewHolder_images = (ViewHolder_Images) holder;
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    public class ViewHolder_Images extends RecyclerView.ViewHolder {
        ImageView item_img;

        public ViewHolder_Images(View itemView) {
            super(itemView);
            item_img = (ImageView) itemView.findViewById(R.id.imgview_item);
        }
    }
}
