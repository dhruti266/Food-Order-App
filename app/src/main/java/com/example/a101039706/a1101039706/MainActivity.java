package com.example.a101039706.a1101039706;

/*  Dhruti Parekh - 101039706
    COMP3074 -  Assignment 1
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String msg = "Welcome to FoodCircles";
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    // method will called when user pressed the enter buttons
    public void goToCuisineScreen(View view){

        // control moves to next Cuisine screen
        Intent intent = new Intent(this, CuisineActivity.class);
        startActivity(intent);
    }

}
