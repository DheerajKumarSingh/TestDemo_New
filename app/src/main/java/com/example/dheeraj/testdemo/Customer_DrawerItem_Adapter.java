package com.example.dheeraj.testdemo;

/**
 * Created by DHEERAJ on 1/16/2017.
 */


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class Customer_DrawerItem_Adapter extends ArrayAdapter<String> {

    Context mContext;
    int layoutResourceId;
    ArrayList<Bean_Menu_Item> arrayList = null;
    private final int VIEW_TYPE_EXAMPLE = 0;
    private final int VIEW_TYPE_EXAMPLE_TWO = 1;
    private final int VIEW_TYPE_EXAMPLE_THREE = 2;

    String user_gmail;


    public Customer_DrawerItem_Adapter(Context mContext, int layoutResourceId,
                                       ArrayList<Bean_Menu_Item> arrayList) {
        super(mContext, layoutResourceId);
        //   this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.arrayList = arrayList;


        Log.v("arraylsit", "" + arrayList.size());
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (arrayList.get(position).getView_type() == 0) {
            return VIEW_TYPE_EXAMPLE;
        } else if (arrayList.get(position).getView_type() == 1) {
            return VIEW_TYPE_EXAMPLE_TWO;
        } else {
            return VIEW_TYPE_EXAMPLE_THREE;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case VIEW_TYPE_EXAMPLE: {
                FirstViewHolder firstViewHolder = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_profile_customer, parent, false);
                    firstViewHolder = new FirstViewHolder(convertView);
                    convertView.setTag(firstViewHolder);
                } else {
                    firstViewHolder = (FirstViewHolder) convertView.getTag();
                }


                firstViewHolder.tv_gmail.setText("" + arrayList.get(0).getName());

                firstViewHolder.toolbar_notif_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mContext instanceof Activity_Customer_Home) {
                            Activity_Customer_Home activity_customer_home = (Activity_Customer_Home) mContext;


                        }
                    }
                });
                firstViewHolder.imgview_profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mContext instanceof Activity_Customer_Home) {
                            Activity_Customer_Home activity_customer_home = (Activity_Customer_Home) mContext;


                        }
                    }
                });


                break;
            }

            case VIEW_TYPE_EXAMPLE_TWO: {
                SecondViewHolder holder = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item_row, parent, false);
                    holder = new SecondViewHolder(convertView);
                    convertView.setTag(holder);
                } else holder = (SecondViewHolder) convertView.getTag();
                holder.tv_name.setText(arrayList.get(position).getName());
                Picasso.with(mContext).load(arrayList.get(position).getImage()).into(holder.imageViewIcon);

                if (position == 8) {
                    holder.ll_line.setVisibility(View.VISIBLE);
                    holder.linearlayout.setVisibility(View.GONE);
                } else {
                    holder.ll_line.setVisibility(View.GONE);
                    holder.linearlayout.setVisibility(View.GONE);
                }

                break;
            }


            case VIEW_TYPE_EXAMPLE_THREE: {
                ThirdViewHolder holder = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item_row_third, parent, false);
                    holder = new ThirdViewHolder(convertView);
                    convertView.setTag(holder);
                } else holder = (ThirdViewHolder) convertView.getTag();
                holder.tv_name.setText(arrayList.get(position).getName());
                Picasso.with(mContext).load(arrayList.get(position).getImage()).into(holder.imageViewIcon);
                break;
            }
        }

        return convertView;
    }


    class SecondViewHolder {
        TextView tv_name;
        ImageView imageViewIcon;
        LinearLayout linearlayout, ll_line;


        public SecondViewHolder(View view) {
            ll_line = (LinearLayout) view.findViewById(R.id.ll_line);
            imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            linearlayout = (LinearLayout) view.findViewById(R.id.linearlayout);
        }
    }

    class FirstViewHolder {

        TextView tv_gmail, tv_counter_noti, tv_gmail_;
        ImageView imgview_profile, toolbar_notif_icon;


        public FirstViewHolder(View view) {
            tv_gmail_ = (TextView) view.findViewById(R.id.tv_gmail_);
            tv_counter_noti = (TextView) view.findViewById(R.id.tv_counter_noti);
            toolbar_notif_icon = (ImageView) view.findViewById(R.id.toolbar_notif_icon);
            tv_gmail = (TextView) view.findViewById(R.id.tv_gmail);
            imgview_profile = (ImageView) view.findViewById(R.id.imgview_profile);
            int color = Color.parseColor("#474749"); //The color u want
            toolbar_notif_icon.setColorFilter(color);


        }
    }

    class ThirdViewHolder {

        TextView tv_name;
        ImageView imageViewIcon;


        public ThirdViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);

        }
    }
}