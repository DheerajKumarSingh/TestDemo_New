package com.example.dheeraj.testdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dheeraj.testdemo.service.Adapter_User_List;
import com.example.dheeraj.testdemo.service.MyBottomSheetDialogFragment;
import com.example.dheeraj.testdemo.service.RecyclerItemClickListener;

import java.util.ArrayList;

import static com.example.dheeraj.testdemo.R.id.img_cross;

/**
 * Created by DHEERAJ on 8/25/2017.
 */

public class Activity_Profile extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        fab=(FloatingActionButton)findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perform whatever you want on back arrow click
                Activity_Profile.this.onBackPressed();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("floating click","floating click");
            }
        });
   //     setUP_Customized_Collapse();
        //  Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        intialized_bottomsheat();




    }


    BottomSheetBehavior behavior;
    boolean isopen_bottomsheat = false;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String> arrayList_loadmore;
    Adapter_User_List adapter_user_list;
    private boolean limit_loading = true;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private int firstVisiblePosition;
    RecyclerView recyclerview_user_list;
    String share_user;
    private void intialized_bottomsheat() {

        arrayList_loadmore = new ArrayList<>();

        TextView img_cross;
        final int[] counter = new int[1];

        View bottomSheet = findViewById(R.id.botoomsheat_user_list);
        behavior = BottomSheetBehavior.from(bottomSheet);
        img_cross = (TextView) bottomSheet.findViewById(R.id.img_cross);

        recyclerview_user_list = (RecyclerView) bottomSheet.findViewById(R.id.recyclerview_user_list);
        recyclerview_user_list.addOnItemTouchListener(
                new RecyclerItemClickListener(Activity_Profile.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        isopen_bottomsheat = false;
                        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }
                })
        );
        linearLayoutManager = new LinearLayoutManager(Activity_Profile.this);
        recyclerview_user_list.setLayoutManager(linearLayoutManager);
        adapter_user_list = new Adapter_User_List(Activity_Profile.this);
        recyclerview_user_list.setAdapter(adapter_user_list);
        adapter_user_list.notifyDataSetChanged();


        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged( View bottomSheet, int newState) {
                // React to state change
                if (behavior instanceof LockableBottomSheetBehavior) {
                    ((LockableBottomSheetBehavior) behavior).setLocked(true);
                }
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }


        });
        img_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isopen_bottomsheat = false;
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });


        recyclerview_user_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
                firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
                if (dy > 0) {
                    // Scroll Down
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
                    Log.v("", "" + visibleItemCount);
                    Log.v("", "" + totalItemCount);
                    Log.v("", "" + pastVisiblesItems);
                    if (limit_loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            limit_loading = false;
                            ++counter[0];
                            task_Load_User_List_Private_Share(counter[0]);
                        }
                    }
                }


            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {


                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    private void task_Load_User_List_Private_Share(int i) {

    }


/*    private void setUP_Customized_Collapse() {
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Jeniifer Lorence");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Profile");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle("Jeniifer Lorence");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }


        });


    }*/

    public void click_Bottomsheat(View view)
    {
        if (isopen_bottomsheat) {
            behavior.setPeekHeight(0);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            isopen_bottomsheat = false;
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            isopen_bottomsheat = true;
        }

    }


}
