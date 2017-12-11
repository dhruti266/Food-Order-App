package com.example.a101039706.a1101039706;

/*  Dhruti Parekh - 101039706
    COMP3074 -  Assignment 1
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckOutActivity extends AppCompatActivity {

    TextView restaurantName, username, address, menuItems;
    String restaurant, name, add, credit, food, cuisine, menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras(); // used to retrieve multiple values

        // get restaurant name and set the value to the text view
        restaurant = extras.getString("restaurant");
        restaurantName = (TextView) findViewById(R.id.restaurantName);
        restaurantName.setText(restaurant);

        // get user name and set the value to the text view
        name = extras.getString("name");
        username = (TextView) findViewById(R.id.userName);
        username.setText(name);

        // get address, credit card, favourite food and cuisine values and set the values to the text view
        add = extras.getString("address");
        credit = extras.getString("creditCard");
        food = extras.getString("favFood");
        cuisine = extras.getString("favCuisine");
        address = (TextView) findViewById(R.id.address);
        address.setText(add + "\n" + "Card: " + credit + "\n" + food + "\n" + cuisine);

        // get selected menu items and set the value to the text view
        menu = extras.getString("menuItems");
        menuItems = (TextView) findViewById(R.id.menuItems);
        menuItems.setText(menu);

    }
}
