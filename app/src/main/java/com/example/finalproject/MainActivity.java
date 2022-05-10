package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //define navigation indicators
    public static Boolean MAINEGGTART = false;
    public static Boolean MAINSALAD = false;
    public static Boolean MAINFOLDER1 = false;
    public static Boolean MAINFOLDER2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Recipes selected
        bottomNavigationView.setSelectedItemId(R.id.recipes);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.recommended:
                        startActivity(new Intent(getApplicationContext(),Recommended.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.recipes:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }


    /** Called when the user taps the View All under recipes */
    public void allRecipes(View view) {
        Intent intent = new Intent(this, AllRecipes.class);
        startActivity(intent);
    }

    /** Called when the user taps the View All under folders */
    public void allFolders(View view) {
        Intent intent = new Intent(this, AllFolders.class);
        startActivity(intent);
    }

    /** Called when the user taps on Egg tart recipe */
    public void openEggTartRecipe(View view) {
        Intent intent = new Intent(this, EggTart.class);
        MAINEGGTART = true;
        startActivity(intent);
    }

    /** Called when the user taps on salad recipe */
    public void openSaladRecipe(View view) {
        Intent intent = new Intent(this, Salad.class);
        MAINSALAD = true;
        startActivity(intent);
    }

    public void openPancakeRecipe(View view) {
        Intent intent = new Intent(this, Pancake.class);
        startActivity(intent);
    }

    /** Called when the user taps on folder 1 */
    public void openFolder1(View view) {
        Intent intent = new Intent(this, FolderOne.class);
        MAINFOLDER1 = true;
        startActivity(intent);
    }
    /** Called when the user taps on folder 2 */
    public void openFolder2(View view) {
        Intent intent = new Intent(this, FolderTwo.class);
        MAINFOLDER2 = true;
        startActivity(intent);
    }

}
