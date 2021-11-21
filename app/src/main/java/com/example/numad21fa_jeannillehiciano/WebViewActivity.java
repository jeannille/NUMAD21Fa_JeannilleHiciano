package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
//Once response is received after request has been made (via WebServiceActivity), the results
//are rendered in this webView for the user

public class WebViewActivity extends AppCompatActivity {
//    Android's WebView object just renders a web page
//    https://developer.android.com/guide/webapps/webview
//    this class uses a WebView, which allows us to display content from website on app

    // adding a webViewClient overrides the default behavior for loading URLs
    //how we modify our own display of the web service's response data (url)
    // allows for subsequent pages to keep loading in app

    private WebView mWebView;
    private EditText mWebDestEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.webView);
        mWebDestEditText = findViewById(R.id.webview_edit_text);

        // Setting the WebViewClient to allow the WebView to override handling the
        // redirects, as opposed to being redirected/launched in the browser
        //avoid sending user outside of the app

        mWebView.setWebViewClient(new WebViewClient() {

            // Deprecated in API 24, but the alternative is not compatible with Android <19
            @SuppressWarnings("deprecation")
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }


    //gets called when user clicks button
    //tell webView set its setting so JS is enabled, we enable false for security holes
    public void loadWebsite(View view){
        //tells the WebView so JavaScript is enabled
        //may have to set this to false (because of reasons beyond this class)
        mWebView.getSettings().setJavaScriptEnabled(false);
        //tell webView to loadURL by getting the text input from user (url)
        mWebView.loadUrl(mWebDestEditText.getText().toString());
    }
}