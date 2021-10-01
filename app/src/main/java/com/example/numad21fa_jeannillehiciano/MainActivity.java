package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user touches About Me button */

    public void toastNameInfo(View view) {
        Toast toast = Toast.makeText(this, "Jeannille Hiciano, hiciano.j@northeastern.edu", Toast.LENGTH_LONG);
        toast.show();
    }


}