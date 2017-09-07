package com.example.dheeraj.testdemo;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DHEERAJ on 9/1/2017.
 */

public class AppAdapter extends BaseSwipListAdapter {

Activity mactivity;
    private List<ApplicationInfo> mAppList;

    AppAdapter(Activity mactivity,List<ApplicationInfo> mAppList)
    {
        this.mactivity=mactivity;
        this.mAppList=mAppList;

    }
    @Override
    public int getCount() {
        return mAppList.size();
    }
    @Override
    public ApplicationInfo getItem(int position) {
        return mAppList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mactivity,
                    R.layout.item_list_app, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        ApplicationInfo item = getItem(position);
        holder.iv_icon.setImageDrawable(item.loadIcon(mactivity.getPackageManager()));
        holder.tv_name.setText(item.loadLabel(mactivity.getPackageManager()));
        holder.iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mactivity instanceof SimpleActivity)
                {
                    SimpleActivity simpleActivity=(SimpleActivity)mactivity;
                    simpleActivity.open_item(position);
                }

            }
        });
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mactivity instanceof SimpleActivity)
                {
                    SimpleActivity simpleActivity=(SimpleActivity)mactivity;
                    simpleActivity.open_item(position);
                }

            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        public ViewHolder(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(this);
        }
    }

    @Override
    public boolean getSwipEnableByPosition(int position) {
        if(position % 2 == 0){
            return false;
        }
        return true;
    }
}
