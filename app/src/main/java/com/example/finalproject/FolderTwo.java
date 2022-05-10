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
    //define navigation indicators
    public static Boolean FOLDER2EGGTART = false;
    public static Boolean FOLDER2PBCOOKIE = false;

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
        //store indicators then reset them
        Boolean indicator1 = MainActivity.MAINFOLDER2;
        Boolean indicator2 = AllFolders.ALLFOLDER2;
        MainActivity.MAINFOLDER2 = false;
        AllFolders.ALLFOLDER2 = false;
        //prepare back options
        Intent intent1 = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, AllFolders.class);
        if (indicator2 == true) {
            startActivity(intent2);
        } else {
            startActivity(intent1);
        }
    }
    /** Called when the user taps on rec1recipe */
    public void openRec2Recipe(View view) {
        Intent intent = new Intent(this, Rec2Recipe.class);
        FOLDER2PBCOOKIE = true;
        startActivity(intent);
    }

    /** Called when the user taps on a first recipe */
    public void openRecipe(View view) {
        Intent intent = new Intent(this, EggTart.class);
        FOLDER2EGGTART = true;
        startActivity(intent);
    }

    public void openBreadPuddingRecipe(View view) {
        Intent intent = new Intent(this, BreadPudding.class);
        startActivity(intent);
    }
}