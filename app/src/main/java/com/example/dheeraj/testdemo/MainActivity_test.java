package com.example.dheeraj.testdemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;


public class MainActivity_test extends AppCompatActivity {



    ArrayList<Uri> uriList_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        object_Initialization();
        setUp_RecyclerViews();


        TedBottomPicker bottomSheetDialogFragment = new TedBottomPicker.Builder(MainActivity_test.this)
                .setOnMultiImageSelectedListener(new TedBottomPicker.OnMultiImageSelectedListener() {
                    @Override
                    public void onImagesSelected(ArrayList<Uri> uriList) {
                        uriList_.clear();
                        uriList_.addAll(uriList);
                        for (Uri a: uriList
                             ) {
                            Log.v("path",""+a);
                        }
                        gridAdapter.notifyDataSetChanged();
                    }
                })
                .setPeekHeight(1600)
                .showTitle(true)
                .setCompleteButtonText("Done")
                .setEmptySelectionText("No Image Selected yet")
                .setSelectMaxCount(10)
                .setTitle("Select Images")
                .create();
        bottomSheetDialogFragment.show(getSupportFragmentManager());
    }

    private void object_Initialization() {
        uriList_=new ArrayList<>();
    }

    GridAdapter_Images gridAdapter;
    private void setUp_RecyclerViews() {

        gridAdapter=new GridAdapter_Images(MainActivity_test.this,uriList_);
        gridLayout.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();

    }

    GridView gridLayout;

    private void findViews() {
        gridLayout=(GridView)findViewById(R.id.gridview);
    }


}
