package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goRestaurants(View view){
        Intent goRestaurantsIntent = new Intent(HomeActivity.this, Restaurants.class);
        startActivity(goRestaurantsIntent);
        finish();
    }

    public void goCategoryPage(View view){
        Intent goCategoryIntent2 = new Intent(HomeActivity.this, CategoryPage.class);
        startActivity(goCategoryIntent2);
        finish();
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent (getApplicationContext(),SignIn.class));
        finish();
    }

}