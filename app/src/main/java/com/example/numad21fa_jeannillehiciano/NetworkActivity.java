package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// https://developer.android.com/training/basics/network-ops/managing.html
// Checks what type of Network connection the user has (cellular, wifi) in order to specify which
// activity is best to implement at given time
public class NetworkActivity extends AppCompatActivity {
//    class keeps track of network connectivity

    //private NetworkReceiver receiver = new NetworkReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
    }


}