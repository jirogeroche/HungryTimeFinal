package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class CategoryPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
    }

    public void goHomePage(View view){
        Intent goHomePageIntent = new Intent(CategoryPage.this, HomeActivity.class);
        startActivity(goHomePageIntent);
        finish();
    }

    public void goRestaurantsPage(View view){
        Intent goRestaurantsIntent = new Intent(CategoryPage.this, Restaurants.class);
        startActivity(goRestaurantsIntent);
        finish();
    }

    public void goChickenPage(View view){
        Intent goChickenPageIntent = new Intent(CategoryPage.this, CategoryClicked.class);
        startActivity(goChickenPageIntent);
        finish();
    }

}