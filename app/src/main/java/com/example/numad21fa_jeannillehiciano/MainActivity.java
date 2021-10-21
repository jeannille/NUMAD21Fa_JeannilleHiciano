package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        sets contentLayouts specified in what is passed eg. activity_main xml file
        setContentView(R.layout.activity_main);
    }

    /** Called when the user touches About Me button */

    public void startAboutMeActivity(){
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

    public void startGridActivity(){
        Intent intent = new Intent(this, GridButtonActivity.class);
        startActivity(intent);
    }

    //connect RecyclerView (List of Links) activity when this method is called
    public void startListOfLinksActivity(){
        Intent intent = new Intent(this, RViewHolder.class);
        startActivity(intent);
    }

    //when get location button is clicked, location activity will open
    public void startLocationActivity(){
        Intent intentLocation = new Intent(this, LocationActivity.class);
        startActivity(intentLocation);
    }

    //do same thing here for activity opened by link collector button

    public void onClick(View view){
//        case for each view (whatever being clicked on) being attached

        switch (view.getId()){
            case R.id.aboutButton:
                startAboutMeActivity();
//                Toast.makeText(getApplicationContext(), "Jeannille H, hiciano.j", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clickyButton:
//                Toast.makeText(getApplicationContext(), "Pressed clicky", Toast.LENGTH_SHORT).show();
                startGridActivity();
                break;
            case R.id.linkButton:
//               Toast.makeText(getApplicationContext(), "Pressed LINK COLLECTOR", Toast.LENGTH_SHORT).show();
                startListOfLinksActivity();
                break;
            case R.id.locationButton:
                startLocationActivity();
                break;

        }
    }


}