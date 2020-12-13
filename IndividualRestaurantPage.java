package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IndividualRestaurantPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_restaurant_page);
    }

    public void goBackPage(View view){
        Intent goBackPageIntent = new Intent(IndividualRestaurantPage.this, Restaurants.class);
        startActivity(goBackPageIntent);
        finish();
    }
}