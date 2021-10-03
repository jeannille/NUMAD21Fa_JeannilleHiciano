package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        sets contentLayouts specified in what is passed eg. activity_main xml file
        setContentView(R.layout.activity_main);
    }

    /** Called when the user touches About Me button */

//    public void toastNameInfo(View view) {
//        Toast toast = Toast.makeText(this, "Jeannille Hiciano, hiciano.j@northeastern.edu", Toast.LENGTH_LONG);
//        toast.show();
//    }

    public void onClick(View view){
//        case for each view (whatever being clicked on) being attached

        switch (view.getId()){
            case R.id.aboutButton:
                Toast.makeText(getApplicationContext(), "Jeannille H, hiciano.j", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clickyButton:
                Toast.makeText(getApplicationContext(), "Pressed clicky", Toast.LENGTH_SHORT).show();
                break;

        }
    }


}