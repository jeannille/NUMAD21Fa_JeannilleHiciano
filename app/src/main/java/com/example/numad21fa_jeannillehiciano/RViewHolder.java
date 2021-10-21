package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

//RViewHolder
//needs to extend RecyclerView.ViewHolder
public class RViewHolder extends AppCompatActivity {
    //activity (RAdapter) that makes list of lists (LinkItem objects)
    //list is brought up by Link Collector button in main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_links);
    }

    public void addLink(View view){

    }

}