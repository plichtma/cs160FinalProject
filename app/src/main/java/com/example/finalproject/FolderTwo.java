package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FolderTwo extends AppCompatActivity {
    public static Boolean REC2ADDEDTOFOLDER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_two);
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
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        if (REC2ADDEDTOFOLDER != null) {
            ImageView rec2 = (ImageView) findViewById(R.id.imageViewRec2AddedFolder);
            TextView cookies = (TextView) findViewById(R.id.textViewCookies);
            rec2.setVisibility(View.VISIBLE);
            cookies.setVisibility(View.VISIBLE);
        }
    }

    /** Called when the user taps the back arrow */
    public void backMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    /** Called when the user taps on rec1recipe */
    public void openRec2Recipe(View view) {
        Intent intent = new Intent(this, Rec2Recipe.class);
        startActivity(intent);
    }

    /** Called when the user taps on a first recipe */
    public void openRecipe(View view) {
        Intent intent = new Intent(this, EggTart.class);
        startActivity(intent);
    }

    public void openBreadPuddingRecipe(View view) {
        Intent intent = new Intent(this, BreadPudding.class);
        startActivity(intent);
    }
}