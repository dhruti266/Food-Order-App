package com.example.a101039706.a1101039706;

/*  Dhruti Parekh - 101039706
    COMP3074 -  Assignment 1
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CustomerInfoActivity extends AppCompatActivity implements OnFocusChangeListener {

    EditText name;
    EditText address;
    EditText creditCard;
    EditText favFood;
    EditText favCuisine;
    Button order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        // get control over all edit text field exist in layout and set on focus listner to them
        name = (EditText) findViewById(R.id.editTextName);
        name.setOnFocusChangeListener(this);

        address = (EditText) findViewById(R.id.editTextAddress);
        address.setOnFocusChangeListener(this);

        creditCard = (EditText) findViewById(R.id.editTextCreditCard);
        creditCard.setOnFocusChangeListener(this);

        favFood = (EditText) findViewById(R.id.editTextFavouriteFood);
        favFood.setOnFocusChangeListener(this);

        favCuisine = (EditText) findViewById(R.id.editTextFavouriteCuisine);
        favCuisine.setOnFocusChangeListener(this);

        order = (Button) findViewById(R.id.btnOrder);


    }

    // validates all the text field data entered by the user
    @Override
    public void onFocusChange(View view, boolean b) {
        validateUserInfo();
    }

    public boolean validateUserInfo(){

        if( name.getText().toString().length() == 0 ){
            name.setError( "Valid name is required!" );
            return false;
        }
        else if( address.getText().toString().length() == 0 ){
            address.setError( "Valid address is required!" );
            return false;
        }
        else if( creditCard.getText().toString().length() != 16){
            creditCard.setError( "Please enter valid 16 digit card number!" );
            return false;
        }
        return  true;
    }

    // method will be called when order button is pressed
    public  void goToCheckOutScreen(View view){

        if(validateUserInfo()) {

            Intent intent = new Intent(this, CheckOutActivity.class);
            Bundle extras = new Bundle();// used to transfer multiple values using putExtra

            //send all the order information to checkout screen
            Intent intent2 = getIntent();
            String restaurant = intent2.getStringExtra("restaurant");
            String menu = intent2.getStringExtra("menuItems");

            extras.putString("restaurant", restaurant);
            extras.putString("menuItems", menu);
            extras.putString("name", name.getText().toString());
            extras.putString("address", address.getText().toString());
            extras.putString("creditCard", creditCard.getText().toString());

            // send favourite food and cuisine info when user enters otherwise send empty string
            if(favFood.getText().toString().length() > 0 || favCuisine.getText().toString().length() > 0){
                extras.putString("favFood", favFood.getText().toString());
                extras.putString("favCuisine", favCuisine.getText().toString());
            }
            else
            {
                extras.putString("favFood", "");
                extras.putString("favCuisine", "");
            }
            intent.putExtras(extras);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
