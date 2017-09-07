package com.example.dheeraj.testdemo.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.HashMap;


/**
 * Created by DHEERAJ on 2/1/2017.
 */

public class MyAsynTask extends AsyncTask<String,String,String> {

    Context mcontext;


    MyAsynTask(Context mcontext)
    {
        this.mcontext=mcontext;


    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {


        {
           // hit our api gettting responce

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
