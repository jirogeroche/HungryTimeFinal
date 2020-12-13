package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
    }

    public void goHomePage(View view){
        Intent goHomePageIntent = new Intent(Restaurants.this, HomeActivity.class);
        startActivity(goHomePageIntent);
        finish();
    }

    public void goCategoryPage(View view){
        Intent goCategoryIntent = new Intent(Restaurants.this, CategoryPage.class);
        startActivity(goCategoryIntent);
        finish();
    }
    public void goIndividualRestaurant(View view){
        Intent goIndividualRestaurantIntent = new Intent(Restaurants.this, IndividualRestaurantPage.class);
        startActivity(goIndividualRestaurantIntent);
        finish();
    }

}