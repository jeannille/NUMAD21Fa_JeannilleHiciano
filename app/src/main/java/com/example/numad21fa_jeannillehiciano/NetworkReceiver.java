package com.example.numad21fa_jeannillehiciano;

//Interface to be used by NetworkActivity to keep tabs on user's network access
// and type of connection while using app

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

//responding to changes in user preferences
//app checks preferences settings in onStart()

//https://developer.android.com/training/basics/network-ops/managing
//example from class

public class NetworkReceiver extends BroadcastReceiver {

    String userNetworkPref;

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager conn = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();

        // Checks the user prefs and the network connection.
        // If the userpreference is Wi-Fi only, checks to see if the device has a Wi-Fi connection.
        if ("Wi-Fi".equals(userNetworkPref) &&
                networkInfo != null &&
                networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            Toast.makeText(context, "Can do data task on Wi-Fi based on your preference", Toast.LENGTH_SHORT).show();

            // If the setting is ANY network and there is a network connection
            // (which by process of elimination would be mobile)
        } else if (
                networkInfo != null &&
                        networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {

            Toast.makeText(context, "Can do data task on mobile connection", Toast.LENGTH_SHORT).show();

            // Otherwise, the app can't download content--either because there is no network
            // connection (mobile or Wi-Fi), or because the pref setting is WIFI, and there
            // is no Wi-Fi connection.
        } else  {
            Toast.makeText(context, "No Wi-Fi or cellular connected. ", Toast.LENGTH_SHORT).show();
        }

    }

    public void setUserPreference(String userNetworkPref){
        this.userNetworkPref = userNetworkPref;
    }
}
