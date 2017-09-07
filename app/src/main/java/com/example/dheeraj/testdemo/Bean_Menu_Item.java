package com.example.dheeraj.testdemo;

/**
 * Created by DHEERAJ on 2/1/2017.
 */

public class Bean_Menu_Item {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    String name;
    int image;
    int view_type;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getView_type() {
        return view_type;
    }

    public void setView_type(int view_type) {
        this.view_type = view_type;
    }
}
