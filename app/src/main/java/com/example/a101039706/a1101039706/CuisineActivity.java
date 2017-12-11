package com.example.a101039706.a1101039706;

/*  Dhruti Parekh - 101039706
    COMP3074 -  Assignment 1
 */

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class CuisineActivity extends Activity {

    RadioGroup cuisineGroup;
    RadioButton rbCommon;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        cuisineGroup = (RadioGroup) findViewById(R.id.radioGroupCusine);
        next = (Button) findViewById(R.id.BtnNext);
    }

    // get the selected radio button value and go to the restaurant screen
    public void getCheckedRadio(View view){

        //gets the selected radio button id
        int radioId = cuisineGroup.getCheckedRadioButtonId();
        if(radioId <= 0){
            String error = "Please select cuisine type";
            Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
        }
        else
        {
            rbCommon = (RadioButton) findViewById(radioId);

            if(rbCommon.getText().equals("Indian") ){
                goToRestaurantScreen(rbCommon);
            }
            else if(rbCommon.getText().equals("Mexican")){
                goToRestaurantScreen(rbCommon);
            }
            else if(rbCommon.getText().equals("Chinese")){
                goToRestaurantScreen(rbCommon);
            }
            else if(rbCommon.getText().equals("Italian")){
                goToRestaurantScreen(rbCommon);
            }
        }

    }

    // method will be called when user hit the next button after selecting cuisine type
    public void goToRestaurantScreen(RadioButton rbCommon){
        Intent intent = new Intent(this, RestaurantActivity.class);
        intent.putExtra("checked",rbCommon.getText());
        startActivity(intent);
    }
}
