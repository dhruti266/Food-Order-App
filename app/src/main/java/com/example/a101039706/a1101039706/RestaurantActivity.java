package com.example.a101039706.a1101039706;

/*  Dhruti Parekh - 101039706
    COMP3074 -  Assignment 1
 */

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends Activity implements OnItemSelectedListener{

    Spinner restaurants;
    String restaurantType;
    List<String> restaurantList;
    ListView menuList;
    ArrayAdapter<String> adapter;
    Button next;
    SparseBooleanArray checkBoxArray ;
    String restaurantName;
    String[] selectedMenuItems;

    // indian restaurant menu list
    String[] empireGrill = new String[] {
            "Samosa", "Aloo Tikki Chaat", "Butter Chiken", "Eggplant Bharta", "Vegetable Biryani"
    };
    String[] rotiPalace = new String[] {
            "Veg Pakora", "Samosa", "Palak Paneer", "Daal Tadka", "Malai Kofta"
    };
    String[] jaipurGrill = new String[] {
            "Chicken Tikka Masala", "Prawn Curry", "Mango Lassi", "Chicken Biryani", "Pineapple Juice"
    };

    // maxican restaurant menu list
    String[] chipotle = new String[] {
            "Burrito", "Burrito Bowl", "Salad", "Crispy Corn Tacos", "Soft Drinks"
    };
    String[] laMexicana = new  String[]{
            "Tostadas", "Fiesta Nachos", "Sopa de Lima", "Sopa de Tortilla", "Tacos"
    };
    String[] burrito = new String[] {
            "Pollo con Mole", "Flautas", "Nachos", "Soft Drinks", "Salad"
    };

    //chinese resstaurant menu list
    String[] seaHi = new String[] {
            "Hot & Sour Soup", "Hakka Noodles", "Vegetable Balls", "Shrimp Lo-mein", "Chicken Fried Rice"
    };
    String[] spring = new String[] {
            "Manchaow Soup", "Sweet Corn Soup", "Chicken Chow Mein", "Roasted Vegetables", "Veg. Spring Roll"
    };
    String[] mioChi = new String[] {
            "Hakka Noodles", "Vegetable Balls", "Hot & Sour Soup", "Veg. Fried Rice", "Sweet Corn Soup"
    };

    // italian restaurant menu list
    String[] jamie = new String[] {
            "Breaded Ravioli", "Chicken Wings", "Chicken Marsala Bites", "Italian Salad", "Lasagna"
    };
    String[] pease = new String[] {
            "Caesar Salad", "Greek Salad", "Lasagna", "Pesto Ravioli", "Chicken Parmigiana"
    };
    String[] ristorante = new String[] {
            "Greek Salad", "Breaded Ravioli", "Lasagna", "Ravioli Carbonara", "Chicken Alla Grilla"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        // get the selected cuisine type from previous screen
        Intent intent = getIntent();
        restaurantType = intent.getStringExtra("checked");

        // get control over all edit text field exist in layout
        restaurants = (Spinner) findViewById(R.id.spinnerlistOfrestaurant);
        menuList = (ListView) findViewById(R.id.menuItemListView);
        next = (Button) findViewById(R.id.BtnNext);


        // adds restaurants in array list according to selected restaurant type on previous screen
        if (restaurantType.equals("Indian")) {
            restaurantList = new ArrayList<String>();
            restaurantList.add("Empire Grill");
            restaurantList.add("Roti Palace");
            restaurantList.add("Jaipur Grill");
            addRestaurantToSpinner();
        } else if (restaurantType.equals("Mexican")) {
            restaurantList = new ArrayList<String>();
            restaurantList.add("Chipotle Mexican Grill");
            restaurantList.add("La Mexicana");
            restaurantList.add("Barburrito");
            addRestaurantToSpinner();
        } else if (restaurantType.equals("Chinese")) {
            restaurantList = new ArrayList<String>();
            restaurantList.add("Sea Hi");
            restaurantList.add("Spring China House");
            restaurantList.add("Mio Chinese");
            addRestaurantToSpinner();
        } else if (restaurantType.equals("Italian")) {
            restaurantList = new ArrayList<String>();
            restaurantList.add("Jamie's Italian");
            restaurantList.add("PAESE Ristorante");
            restaurantList.add("Ristorante Boccaccio");
            addRestaurantToSpinner();
        }

        restaurants.setOnItemSelectedListener(this);
    }

    // adds and display the list of restaurant to spinner
    public void addRestaurantToSpinner(){

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, restaurantList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.notifyDataSetChanged();
        restaurants.setAdapter(dataAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        restaurantName = String.valueOf(restaurants.getSelectedItem());

        // get the selected restaurant name from spinner and create its menu list
        if(restaurantName.equals("Empire Grill")){
            createMenuList(empireGrill);
        }
        else if(restaurantName.equals("Roti Palace")){
            createMenuList(rotiPalace);
        }
        else if(restaurantName.equals("Jaipur Grill")){
            createMenuList(jaipurGrill);
        }
        else if (restaurantName.equals("Chipotle Mexican Grill")){
            createMenuList(chipotle);
        }
        else if (restaurantName.equals("La Mexicana")){
            createMenuList(laMexicana);
        }
        else if (restaurantName.equals("Barburrito")){
            createMenuList(burrito);
        }
        else if (restaurantName.equals("Sea Hi")){
            createMenuList(seaHi);
        }
        else if (restaurantName.equals("Spring China House")){
            createMenuList(spring);
        }
        else if (restaurantName.equals("Mio Chinese")){
            createMenuList(mioChi);
        }
        else if (restaurantName.equals("Jamie's Italian")){
            createMenuList(jamie);
        }
        else if (restaurantName.equals("PAESE Ristorante")){
            createMenuList(pease);
        }
        else if (restaurantName.equals("Ristorante Boccaccio")){
            createMenuList(ristorante);
        }


    }

    // change menu items according to selected restaurant
    public void createMenuList(final String[] menuListItems){
         adapter = new ArrayAdapter<String>
                (RestaurantActivity.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, menuListItems );

        menuList.setAdapter(adapter);
        selectedMenuItems = menuListItems;
    }

    //
    public  void goToCustomerInfo(View view){

        int i = 0;
        String strMenu = "";

        checkBoxArray = menuList.getCheckedItemPositions(); // adds all checked box value to an array

        // add selected menu items to string variable
        while(i < checkBoxArray.size()){
            if (checkBoxArray.valueAt(i)) {
                strMenu += selectedMenuItems[checkBoxArray.keyAt(i)] + "\n";
            }
            i++;
        }

        // shows error message when nothing is selected form menu item list
        if(strMenu.length() < 1){
            Toast.makeText(RestaurantActivity.this, "Please select menu items", Toast.LENGTH_SHORT).show();
            return;
        }

        // send selected menu items to next screen
        Intent intent = new Intent(this, CustomerInfoActivity.class);
        Bundle extras = new Bundle();
        extras.putString("restaurant",restaurantName);
        extras.putString("menuItems",strMenu);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}