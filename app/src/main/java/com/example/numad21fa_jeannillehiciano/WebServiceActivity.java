package com.example.numad21fa_jeannillehiciano;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
//activity handles the user's input (from WebView), makes (HTTP) request to the web service
// makes request and receives responses from the web service (third party api)
//Android Service runs its processes in the background of app

public class WebServiceActivity extends AppCompatActivity {

    private EditText mURLEditText;
    private TextView mTitleTextView;

    private static final String TAG = "WebServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);


        //the edit text box taking in URL (temporary, should beuser data input sent to web serv)
        mURLEditText = (EditText)findViewById(R.id.URL_editText);
        //textbox where result will be displayed (title of json obj in example)
        //will change to a webview object for Tumblr posts
        mTitleTextView = (TextView)findViewById(R.id.result_textview);
    }

    public void callWebserviceButtonHandler(View view) {
        PingWebServiceTask task = new PingWebServiceTask();
        try {
            //get & save url user has entered in textbox, make sure its valid
            String rawInput = mURLEditText.getText().toString();
            //will edit to append query string

            //hardcoded test for bridget jones, success
            String url = NetworkUtil.validInput("https://www.omdbapi.com/?apikey=21a5afff&s=Bridget+Jones");
            //append user's input as query to api that includes my API key

//            String url2 = NetworkUtil.validInput("https://www.omdbapi.com/?i=tt3896198&apikey=21a5afff");

            task.execute(url); // This is a security risk.  Don't let your user enter the URL in a real app.
        } catch (NetworkUtil.MyException e) {
            //show user exception if caught
            Toast.makeText(getApplication(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


        //from networkExample code
    private class PingWebServiceTask  extends AsyncTask<String, Integer, JSONObject> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making progress...");
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            //placeholder for JSON object after i format its result in order to return to app

            //intialize JSONObject to be returned
            JSONObject jObject = new JSONObject();
            try {

                URL url = new URL(params[0]);
                Log.i("--------current url to be parsed by NetworkUtil", url.toString());
                // Get String response from the url address
                //NetworkUtil  creates HttpURLConnection obj & uses GET req method
                //reads response using input stream & returns resp as String
                String resp = NetworkUtil.httpResponse(url);
                Log.i("String resp-----> ", resp);

                // JSONArray jArray = new JSONArray(resp);    // Use this if your web service returns an array of objects.  Arrays are in [ ] brackets.
                // Transform String into JSONObject
                jObject = new JSONObject(resp);
                //url returns JSONArray, grab second element which is another array of search results
                JSONArray jArray = (JSONArray) jObject.get("Search");

                //print to log every title in the results list
                for (int i = 0; i < jArray.length(); i++){
                    Log.i("Title" , jArray.getJSONObject(i).getString("Title"));
                }

                //Log.i("jTitle",jObject.getString("title"));
                //Log.i("jBody",jObject.getString("body"));

                Log.i(TAG, "SUCCESS - connection grabbed json obj no exceptionzzz");
                return jObject;

            } catch (MalformedURLException e) {
                Log.e(TAG,"MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                Log.e(TAG,"ProtocolException");
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG,"IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG,"JSONException");
                e.printStackTrace();
            }

            return jObject;

        }

        //this is what gets called when server comes back w/ response
        @Override
        protected void onPostExecute(JSONObject jObject) {
            super.onPostExecute(jObject);
            TextView result_view = (TextView)findViewById(R.id.result_textview);

            //put response inf result_view textbox
            try {
//                String jResults = jObject.getString("totalResults");
//                String jResponse = jObject.getString("Responses");
//                result_view.setText("Results: " + jResults + " jResponse: " + jResponse );
                result_view.setText(jObject.getString("totalResults"));
//                result_view.setText(jObject.getString("Plot"));
            } catch (JSONException e) {
                result_view.setText("Something went wrong!");
            }

        }
    }


}