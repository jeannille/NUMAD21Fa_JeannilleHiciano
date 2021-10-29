package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//Once response is received after request has been made (via WebServiceActivity), the results
//are rendered in this webView for the user

public class WebViewActivity extends AppCompatActivity {
//    Android's WebView object just renders a web page
//    https://developer.android.com/guide/webapps/webview
//    this class uses a WebView, and this webView allows us to display content from online

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
    }
}