package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Recommended extends AppCompatActivity {
    public static Boolean ADDED1;
    public static Boolean ADDED2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set recommended selected
        bottomNavigationView.setSelectedItemId(R.id.recommended);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.recipes:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.recommended:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        if ((ADDED1 != null) && (ADDED2 == null)) {
            //retrieve elements from view
            ImageView rec1 = (ImageView) findViewById(R.id.imageViewRec1);
            TextView rec1_name = (TextView) findViewById(R.id.textViewRec1Name);
            ImageView rec2 = (ImageView) findViewById(R.id.imageViewRec2);
            TextView rec2_name = (TextView) findViewById(R.id.textViewRec2Name);
            //redefine constraints of rec2
            RelativeLayout.LayoutParams rec2_params = (RelativeLayout.LayoutParams)rec2.getLayoutParams();
            rec2_params.addRule(RelativeLayout.ALIGN_PARENT_START);
            rec2_params.removeRule(RelativeLayout.END_OF);
            rec2.setLayoutParams(rec2_params);
            //replace text of rec1_name with rec2_name text
            String replace_name = rec2_name.getText().toString();
            rec1_name.setText(replace_name);
            //get rid of rec1 and rec2_name
            rec1.setVisibility(View.GONE);
            rec2_name.setVisibility(View.GONE);

        } else if ((ADDED1 == null) && (ADDED2 != null)) {
            //retrieve elements from view
            ImageView rec1 = (ImageView) findViewById(R.id.imageViewRec1);
            TextView rec1_name = (TextView) findViewById(R.id.textViewRec1Name);
            ImageView rec2 = (ImageView) findViewById(R.id.imageViewRec2);
            TextView rec2_name = (TextView) findViewById(R.id.textViewRec2Name);
            // get rid of rec2 and rec2name
            rec2.setVisibility(View.GONE);
            rec2_name.setVisibility(View.GONE);

        } else if ((ADDED1 != null) && (ADDED2 != null)) {
            //retrieve elements from view
            ImageView rec1 = (ImageView) findViewById(R.id.imageViewRec1);
            TextView rec1_name = (TextView) findViewById(R.id.textViewRec1Name);
            ImageView rec2 = (ImageView) findViewById(R.id.imageViewRec2);
            TextView rec2_name = (TextView) findViewById(R.id.textViewRec2Name);
            // get rid of all of them
            rec1.setVisibility(View.GONE);
            rec2.setVisibility(View.GONE);
            rec1_name.setVisibility(View.GONE);
            rec2_name.setVisibility(View.GONE);
        }

    }

    /** Called when the user taps the Egg Tart under recipes */
    public void openEggTart(View view) {
        Intent intent = new Intent(this, EggTart.class);
        startActivity(intent);
    }

    /** Called when the user taps the Egg Tart under recipes */
    public void openRecommended1(View view) {
        Intent intent = new Intent(this, Recommended1.class);
        startActivity(intent);
    }
}
