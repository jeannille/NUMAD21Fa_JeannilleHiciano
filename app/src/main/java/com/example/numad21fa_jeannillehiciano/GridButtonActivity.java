package com.example.numad21fa_jeannillehiciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GridButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_buttons);
    }

    public void onClickGrid(View view){
//        case for each view (whatever being clicked on) being attached

        switch (view.getId()){
            case R.id.aboutButton:
                Toast.makeText(getApplicationContext(), "Jeannille H, hiciano.j", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clickyButton:
                Toast.makeText(getApplicationContext(), "Pressed clicky", Toast.LENGTH_SHORT).show();
                TextView clickyMsg = findViewById(R.id.aboutMeText);
                clickyMsg.setText("modified text");
                break;


        }
    }
}