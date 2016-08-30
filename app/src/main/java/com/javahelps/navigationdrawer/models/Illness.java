package com.javahelps.navigationdrawer.models;

/**
 * Created by Angelhia on 30/8/2016.
 */
public class Illness {

    private String name;
    private String desc;
    private int img;

    public Illness(String name, String desc, int img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
