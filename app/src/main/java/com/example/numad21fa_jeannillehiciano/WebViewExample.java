package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);
    }


    public void loadUrlExample(){
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("http://www.northeastern.edu");
    }
}