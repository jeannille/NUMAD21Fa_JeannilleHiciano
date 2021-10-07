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
//        Toast.makeText(getApplicationContext(), "Original onClick", Toast.LENGTH_SHORT).show();
//        TextView clickyText = findViewById(R.id.aboutMeText);

        switch (view.getId()){
            case R.id.aboutButton:
                Toast.makeText(getApplicationContext(), "Jeannille H, hiciano.j", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clickyButton:
                Toast.makeText(getApplicationContext(), "Pressed clicky", Toast.LENGTH_SHORT).show();
                TextView clickyMsg = findViewById(R.id.aboutMeText);
                clickyMsg.setText("modified text");
                break;
            case R.id.button_a:
                TextView clickyMsg2 = findViewById(R.id.pressedText);
                clickyMsg2.setText("Pressed: A");
                break;
            case R.id.button_b:
                TextView clickyMsgB = findViewById(R.id.pressedText);
                clickyMsgB.setText("Pressed: B");
                break;
            case R.id.button_c:
                TextView clickyMsgC = findViewById(R.id.pressedText);
                clickyMsgC.setText("Pressed: C");
                break;

            case R.id.button_d:
                TextView clickyMsgD = findViewById(R.id.pressedText);
                clickyMsgD.setText("Pressed: D");
                break;
            case R.id.button_e:
                TextView clickyMsgE = findViewById(R.id.pressedText);
                clickyMsgE.setText("Pressed: E");
                break;
            case R.id.button_f:
                TextView clickyMsgF = findViewById(R.id.pressedText);
                clickyMsgF.setText("Pressed: F");
                break;

        }
    }
}