package com.example.android.quakereport;

public class CustomModel {
    private double mMag;
    private String mPlace;
    private String mDate;
    private String mTime;
    private String mUrl;
    public CustomModel(double m,String a,String b,String c,String d)
    {
        mMag=m;
        mPlace=a;
        mDate=b;
        mTime=c;
        mUrl =d;
    }

    public double getmMag() {
        return mMag;
    }

    public String getmPlace() {
        return mPlace;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmTime() { return mTime; }

    public String getmUrl() {
        return mUrl;
    }
}
