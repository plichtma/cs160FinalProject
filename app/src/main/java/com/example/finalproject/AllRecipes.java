package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AllRecipes extends AppCompatActivity {

    //define navigation indicators
    public static Boolean ALLRECEGGTART = false;
    public static Boolean ALLRECSALAD = false;
    public static Boolean ALLRECFRENCHTOAST = false;
    public static Boolean ALLRECPBCOOKIE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipes);

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

        if (Recommended.ADDED1 != null) {
            ImageView rec1 = (ImageView) findViewById(R.id.imageViewRec1Added);
            TextView ft = (TextView) findViewById(R.id.textViewFrenchToast);
            rec1.setVisibility(View.VISIBLE);
            ft.setVisibility(View.VISIBLE);
        }
        if (Recommended.ADDED2 != null) {
            ImageView rec2 = (ImageView) findViewById(R.id.imageViewRec2Added);
            TextView cookies = (TextView) findViewById(R.id.textViewCookies);
            rec2.setVisibility(View.VISIBLE);
            cookies.setVisibility(View.VISIBLE);
        }


    }

    /** Called when the user taps the View All under recipes */
    public void backMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the View All under recipes */
    public void createRecipe(View view) {
        Intent intent = new Intent(this, CreateRecipe.class);
        startActivity(intent);
    }

    /** Called when the user taps on a recipe */
    public void openRecipe(View view) {
        Intent intent = new Intent(this, EggTart.class);
        ALLRECEGGTART = true;
        startActivity(intent);
    }

    /** Called when the user taps on salad recipe */
    public void openSaladRecipe(View view) {
        Intent intent = new Intent(this, Salad.class);
        ALLRECSALAD = true;
        startActivity(intent);
    }

    /** Called when the user taps on rec1recipe */
    public void openRec1Recipe(View view) {
        Intent intent = new Intent(this, Rec1Recipe.class);
        ALLRECFRENCHTOAST = true;
        startActivity(intent);
    }
    /** Called when the user taps on rec2recipe */
    public void openRec2Recipe(View view) {
        Intent intent = new Intent(this, Rec2Recipe.class);
        ALLRECPBCOOKIE = true;
        startActivity(intent);
    }

    public void openPancakeRecipe(View view) {
        Intent intent = new Intent(this, Pancake.class);
        startActivity(intent);
    }

    public void openBreadPuddingRecipe(View view) {
        Intent intent = new Intent(this, BreadPudding.class);
        startActivity(intent);
    }

    /**Called when user taps plus button */
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.create_recipe_options, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    // dismiss the popup window when cancel button clicked
    public void cancelOptions(View view) {
        Intent intent = new Intent(this, AllRecipes.class);
        startActivity(intent);
    }

}