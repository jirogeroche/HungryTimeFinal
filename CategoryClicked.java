package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryClicked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_clicked);

    }

    public void goBackPage2(View view){
        Intent goBackPage2Intent = new Intent(CategoryClicked.this, CategoryPage.class);
        startActivity(goBackPage2Intent);
        finish();
    }

    public void goMaxChicken(View view){
        Intent goMaxChickenIntent = new Intent (CategoryClicked.this, IndividualFoodPage.class);
        startActivity(goMaxChickenIntent);
        finish();
    }




}