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

        // Setting the WebViewClient to allow the WebView to handle the
        // redirects within the WebView, as opposed to being launched in a browser.

        mWebView.setWebViewClient(new WebViewClient() {

            // Deprecated in API 24, but the alternative is not compatible with Android <19
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }


    //gets called when user clicks button
    public void loadWebsite(View view){
        //tells the WwebView so JavaScipt is enabled
        //may have to set this to false (because of reasons beyond this class)
        mWebView.getSettings().setJavaScriptEnabled(false);
        //gets the text that the user input
        mWebView.loadUrl(mWebDestEditText.getText().toString());
    }
}