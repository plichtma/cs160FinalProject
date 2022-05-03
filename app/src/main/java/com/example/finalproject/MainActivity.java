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

        //get the spinner from the xml.
//        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//        String[] paths = {"item 1", "item 2", "item 3"};
//        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_spinner_item,paths);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);



    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
//
//        switch (position) {
//            case 0:
//                // Whatever you want to happen when the first item gets selected
//                break;
//            case 1:
//                // Whatever you want to happen when the second item gets selected
//                break;
//            case 2:
//                // Whatever you want to happen when the thrid item gets selected
//                break;
//
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        // TODO Auto-generated method stub
//    }

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

    /** Called when the user taps on a recipe */
    public void openEggTartRecipe(View view) {
        Intent intent = new Intent(this, EggTart.class);
        startActivity(intent);
    }

    public void openSaladRecipe(View view) {
        Intent intent = new Intent(this, Salad.class);
        startActivity(intent);
    }

    /** Called when the user taps on folder 1 */
    public void openFolder1(View view) {
        Intent intent = new Intent(this, FolderOne.class);
        startActivity(intent);
    }

}
