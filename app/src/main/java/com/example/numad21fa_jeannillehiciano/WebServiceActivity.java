package com.example.numad21fa_jeannillehiciano;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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

    private static final String TAG = "WebServiceActivity";
    private String mUrl;
    private EditText mURLEditText;
    private TextView mTitleTextView;
//    private WebView mWebView; //movie poster placeholder, could not figure out imageView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        mURLEditText = (EditText)findViewById(R.id.URL_editText);
        mTitleTextView = (TextView)findViewById(R.id.result_textview);

    }

    //when user clicks on button, new Async task created, get url user has entered and execute it
    public void callWebserviceButtonHandler(View view) {
        PingWebServiceTask task = new PingWebServiceTask(); //extends asyncTask
        //get & save url user has entered in textbox, make sure its valid
        String rawInput = mURLEditText.getText().toString();
        //remove leading & trailing spaces plus any multiple spacing then replaces spaces with + for query
        String userInput = rawInput.trim().replaceAll(" +", " ");
        String queryString = userInput.replace(" ", "+");
        try {

//            Log.i("---------------------------------------------- input test", queryString);
//            String url = NetworkUtil.validInput("https://www.omdbapi.com/?apikey=21a5afff&s=Bridget+Jones");
            //append user's input as query to api that includes my API key
            String url = NetworkUtil.validInput("https://www.omdbapi.com/?apikey=21a5afff&plot=full&&t=" + queryString);

            task.execute(url); //execute updated url w/ user's query appended
        } catch (NetworkUtil.MyException e) {
            Toast.makeText(getApplication(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

//    //when user clicks on button, new Async task created, get url user has entered and execute it
//    public void callWebserviceButtonHandler(View view){
//        PingWebServiceTask task = new PingWebServiceTask(); //extends AsyncTask
//        try {
//            //get & save url user has entered in textbox, make sure its valid
////            String url = NetworkUtil.validInput(mURLEditText.getText().toString());
//            String url = NetworkUtil.validInput("https://www.omdbapi.com/?apikey=21a5afff&plot=full&t=Bridget+Jones");
////            String url = NetworkUtil.validInput("https://jsonplaceholder.typicode.com/posts/1");
//            task.execute(url); // This is a security risk.  Don't let your user enter the URL in a real app.
//        } catch (NetworkUtil.MyException e) {
//            //show user exception if caught
//            Toast.makeText(getApplication(),e.toString(),Toast.LENGTH_SHORT).show();
//        }
//
//    }


    private class PingWebServiceTask  extends AsyncTask<String, Integer, JSONObject> {
        //asynctask off main thread

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making progress...");
        }

        //takes in String params are the parameters from what the user has entered
        @Override
        protected JSONObject doInBackground(String... params) {

            //passing back result, pass back two strings as part of an array
            JSONObject result = null;

            //intialize JSONObject to be returned
            JSONObject jObject = new JSONObject();
            try {

                // Initial free web serv is "https://jsonplaceholder.typicode.com/posts/1"
                //

                URL url = new URL(params[0]);
                Log.i("--------current url to be parsed by NetworkUtil",url.toString() );
                // Get String response from the url address
                //NetworkUtil  creates HttpURLConnection obj & uses GET req method
                //typecode returns a JSON object
                //reads response using input stream & returns resp as String
                String resp = NetworkUtil.httpResponse(url);
                Log.i("String resp",resp);


                jObject = new JSONObject(resp);


                Log.i(TAG,"SUCCESS - connection grabbed json obj");
//                System.out.print("SUCCESS woooo");
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

        @Override
        protected void onPostExecute(JSONObject jObject) {
            super.onPostExecute(jObject);
            TextView result_view = (TextView)findViewById(R.id.result_textview);
            ImageView result_img = (ImageView) findViewById(R.id.webServiceImage);
//            result_img.setVisibility(View.INVISIBLE);

            try {
//                result_view.setText(jObject.getString("Search"));
                String plot = jObject.getString("Plot").replace("\n", "");
                String actors = jObject.getString("Actors").replace("\n", "");
                result_view.setText(jObject.getString("Title") + "\nPlot: "+ plot + "\nYear: " +
                        jObject.getString("Year") + "\n"+ "Actors: " + actors);
//                result_view.setVisibility(View.VISIBLE);

                //delete below if crash
                String imgStr = jObject.getString("Poster");
                Picasso.get().load(imgStr).into(result_img);
//                result_img.setVisibility(View.VISIBLE);


//                String actors = getJSONDataValue(jObject, "Actors").replace("\n", "");
//                result_view.setText("Title: " + jObject.getString("Title")
//                        + "\n Year: " + jObject.getString("Year") + "\n Plot: " + plot
//                        + "\n Actors: " + actors );
//                result_view.setText(jObject.toString());
            } catch (JSONException e) {
                result_view.setText("Something went wrong!");
            }

        }
    }



        //from networkExample code
    private class PingWebServiceTaskTWO  extends AsyncTask<String, Integer, JSONObject> {
            //asynctask off main thread

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making progress...");
        }

        //takes in String params are the parameters, updated url w/ user input
        @Override
        protected JSONObject doInBackground(String... params) {
            //initialize JSONObject to be returned
            JSONObject jObject = new JSONObject();
            try {

                URL url = new URL(params[0]);
                Log.i("--------current url to be parsed by NetworkUtil", url.toString());
                // Get String response from the url address
                //NetworkUtil  creates HttpURLConnection obj & uses GET req method
                //reads response using input stream & returns resp as String
                String resp = NetworkUtil.httpResponse(url);
                Log.i("\n"+ "String resp-----> ", resp);

                // JSONArray jArray = new JSONArray(resp);    // Use this if your web service returns an array of objects.  Arrays are in [ ] brackets.
                // Transform String into JSONObject
//                jObject = new JSONObject(resp);

                //url returns JSONArray, grab second element which is another array of search results
                JSONArray jArray = (JSONArray) jObject.get("Search");
                //return top 3 results as test and let user select

                //print to log every title in the results list
                for (int i = 0; i < jArray.length(); i++){
                    Log.i("Title" , jArray.getJSONObject(i).getString("Title"));
                }
                //for now just returning first movie result, user has to enter exact title
                //not ideal but it's working for now, will update to handle multiple results
                jObject = jArray.getJSONObject(0);

                Log.i("-----------------------ACTUAL TITLE", jObject.getString("Title"));
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
        //what to do after JSONObject has been obtained
        @Override
        protected void onPostExecute(JSONObject jObject) {
            super.onPostExecute(jObject);
            TextView result_view = (TextView) findViewById(R.id.result_textview);

            try {

                result_view.setText(jObject.toString());
//                String url4 = "https://m.media-amazon.com/images/M/MV5BOTJlNWQxZjctYmE3ZS00OTc0LWE2M2ItNzQwNmYyMjU4NDNmXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg";

                String posterUrl = jObject.getString("Poster");
//                loadWebsite(mWebView, posterUrl);

            } catch (JSONException e) {
                result_view.setText("Something went wrong!");
            }


        }
        }


    //helper function to create subfields from json returned object
    //didn't end up using but will when I update MovieCard as an obj to represent each JSON result
    public String getJSONDataValue(JSONObject j, String field) throws JSONException {
        try {
            return j.getString(field);
        } catch (JSONException e) {
            Log.e(TAG, "JSONException");
            e.printStackTrace();
        }
        return j.getString(field);
    }


}