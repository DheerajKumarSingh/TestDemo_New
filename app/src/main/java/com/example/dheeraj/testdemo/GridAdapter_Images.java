package com.example.dheeraj.testdemo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by DHEERAJ on 8/25/2017.
 */

public class GridAdapter_Images extends BaseAdapter {

    Activity mcontext;
    LayoutInflater inflater;
    ArrayList<Uri> uriList;

    GridAdapter_Images(Activity mcontext, ArrayList<Uri> uriList)
    {
        this.mcontext = mcontext;
        this.uriList=uriList;
       // layoutInflater = LayoutInflater.from(mcontext);
    }


    @Override
    public int getCount() {
        return uriList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return uriList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        NewHolder holder = null;
        ImageView imageView;

        if(convertView==null){//if convert view is null then only inflate the row
            inflater = (LayoutInflater) mcontext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate(R.layout.item_img,viewGroup,false);
            holder = new NewHolder();
            //find views in item row
            holder.imageView = (ImageView)convertView.findViewById(R.id.imgview_item);
          //  holder.textView = (ImageView)convertView.findViewById(R.id.textview_id);

            convertView.setTag(holder);
        }
        else { //otherwise get holder from tag
            holder = (NewHolder) convertView.getTag();
        }
        Log.v("",""+uriList.get(position));
        Log.v("check",""+new File(String.valueOf(uriList.get(position))).exists());

        //set data here
        Picasso.with(mcontext).load(uriList.get(position)).centerCrop().resize((int) mcontext.getResources().
                getDimension(R.dimen._100sdp),
                (int) mcontext.getResources().getDimension(R.dimen._100sdp))
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.v("","success");

                    }

                    @Override
                    public void onError() {

                    }
                });

        return convertView;
    }

    public class NewHolder {
        public ImageView imageView;

    }

}