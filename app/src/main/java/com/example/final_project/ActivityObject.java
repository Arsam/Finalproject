package com.example.final_project;

public class ActivityObject {
    public String activity;
    public String accessibility;
    public String type;
    public String participants;
    public String price;
    public String link;
    public String key;

    public ActivityObject(String activity, String accessibility, String type,String participants,String price,String link,String key){
        this.activity = activity;
        this.accessibility = accessibility;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
        this.key = key;
    }
}