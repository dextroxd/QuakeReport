package com.example.android.quakereport;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{   ArrayList<CustomModel> list;
    Activity activity;


    public CustomAdapter(ArrayList<CustomModel> list, Activity activity)
    {
        this.list=list;
        this.activity = activity;

    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv1,tv2,tv3,tv4,tv5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv5 = itemView.findViewById(R.id.tv5);

        }
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.custom_view, null);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder myViewHolder, int i)
    {
        CustomModel model = list.get(i);

        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        myViewHolder.tv1.setText(magnitudeFormat.format(model.getmMag()));
        GradientDrawable magnitudeCircle = (GradientDrawable) myViewHolder.tv1.getBackground();

        magnitudeCircle.setColor(getMagnitudeColor(model.getmMag()));
        int a = model.getmPlace().indexOf("of");
        if(a>0)
        {myViewHolder.tv2.setText(model.getmPlace().substring(0,a+2));
        myViewHolder.tv5.setText(model.getmPlace().substring(a+3));}

        else
        {
            myViewHolder.tv5.setText(model.getmPlace());
        }
        myViewHolder.tv3.setText(model.getmDate());
        myViewHolder.tv4.setText(model.getmTime());



    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
                return ContextCompat.getColor(activity,magnitudeColorResourceId);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
