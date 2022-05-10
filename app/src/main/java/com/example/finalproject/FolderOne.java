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

public class FolderOne extends AppCompatActivity {
    public static Boolean REC1ADDEDTOFOLDER;
    //define navigation indicators
    public static Boolean FOLDER1EGGTART = false;
    public static Boolean FOLDER1FRENCHTOAST = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_one);

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

        if (REC1ADDEDTOFOLDER != null) {
            ImageView rec1 = (ImageView) findViewById(R.id.imageViewRec1AddedFolder);
            TextView ft = (TextView) findViewById(R.id.textViewFrenchToast);
            rec1.setVisibility(View.VISIBLE);
            ft.setVisibility(View.VISIBLE);
        }
    }

    /** Called when the user taps the back arrow */
    public void backMain(View view) {
        //store indicators then reset them
        Boolean indicator1 = MainActivity.MAINFOLDER1;
        Boolean indicator2 = AllFolders.ALLFOLDER1;
        MainActivity.MAINFOLDER1 = false;
        AllFolders.ALLFOLDER1 = false;
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
    public void openRec1Recipe(View view) {
        Intent intent = new Intent(this, Rec1Recipe.class);
        FOLDER1FRENCHTOAST = true;
        startActivity(intent);
    }


    /** Called when the user taps on a first recipe */
    public void openPancake(View view) {
        Intent intent = new Intent(this, Pancake.class);
        startActivity(intent);
    }
}