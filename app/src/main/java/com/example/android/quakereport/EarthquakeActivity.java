/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
    ArrayList<CustomModel> arrayList = new ArrayList<>();

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        arrayList = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        final RecyclerView earthquakeListView =  (RecyclerView) findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter(arrayList,EarthquakeActivity.this);
        earthquakeListView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        earthquakeListView.setAdapter(customAdapter);
        earthquakeListView.addOnItemTouchListener(new RecyclerTouchListener(this, earthquakeListView, new RecyclerTouchListener.ClickListener()
        {
            @Override
            public void onClick(View view, int position)
            {
                CustomModel model =  arrayList.get(position);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(model.getmUrl()));
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
