package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IndividualFoodPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_food_page);
    }
    public void goBackPage3(View view){
        Intent goBackPage3Intent = new Intent(IndividualFoodPage.this, CategoryClicked.class);
        startActivity(goBackPage3Intent);
        finish();
    }
}