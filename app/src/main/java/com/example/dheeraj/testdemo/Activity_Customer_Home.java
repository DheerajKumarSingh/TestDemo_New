package com.example.dheeraj.testdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by JimmyPC_Webdior on 2/1/2017.
 */

public class Activity_Customer_Home extends AppCompatActivity {

    private static final String TAG = "Activity_Customer_Home";
    ImageView toolbar_menu;
    ListView left_drawer;
    DrawerLayout drawlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        findView();
        setUp_Drawable_Adapter();
    }


    @Override
    protected void onStart() {
        super.onStart();

    }



    Customer_DrawerItem_Adapter drawerItemCustomAdapter;
    int counterr = 0;
    private void setUp_Drawable_Adapter() {

        {
            ArrayList<Bean_Menu_Item> arrayList_ = new ArrayList<>();
            Bean_Menu_Item bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("dk customer");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(0);
            arrayList_.add(bean_menu_item);

            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("dashboard");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);
            ////
            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("my_profile");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);
            ///   bean_menu_item=new Bean_Menu_Item();
            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("my_account");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);

            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("my_review");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);

            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("message");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);

            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("hint_title_my_wishlist");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);


            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("trascations");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);


            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("hint_contact_us");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);


            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("help_supprt");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);


            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("settings");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);


    /*        bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName(getResources().getString(R.string.about_us));
            bean_menu_item.setImage(R.drawable.menu_icon_aboutus);
            bean_menu_item.setView_type(1);
            arrayList_.add(bean_menu_item);*/

            bean_menu_item = new Bean_Menu_Item();
            bean_menu_item.setName("sign_out");
            bean_menu_item.setImage(R.drawable.ic_camera);
            bean_menu_item.setView_type(2);
            arrayList_.add(bean_menu_item);

            // adding user name,rating, icon
            String user_name = "dksingh";
            String rating = "3";
            String user_image = "";

            drawerItemCustomAdapter = new Customer_DrawerItem_Adapter(this, 0, arrayList_);
            left_drawer.setAdapter(drawerItemCustomAdapter);
            drawerItemCustomAdapter.notifyDataSetChanged();
        }
    }


    ProgressBar progressBar;
    LinearLayoutManager linearLayoutManager;
    ImageView img_search;
    private void findView() {
        drawlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer = (ListView) findViewById(R.id.left_drawer);
        toolbar_menu = (ImageView) findViewById(R.id.toolbar_menu);
        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawlayout.openDrawer(Gravity.LEFT);
            }
        });



    }

















}
