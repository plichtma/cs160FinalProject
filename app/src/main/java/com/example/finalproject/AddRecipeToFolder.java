package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddRecipeToFolder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe_to_folder);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddRecipeToFolder.this,
            android.R.layout.simple_list_item_1,
            getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /** Called when the user taps add with add recipe to folder popup */
    public void addPopup(View view) {
        //store indicators then reset them
        Boolean rec1Indicator = Rec1Recipe.POPUPOPENED1;
        Boolean rec2Indicator = Rec2Recipe.POPUPOPENED2;
        Rec1Recipe.POPUPOPENED1 = false;
        Rec2Recipe.POPUPOPENED2 = false;
        //prepare back options
        Intent intent = new Intent(this, AllRecipes.class);
        Intent intent1 = new Intent(this, Rec1Recipe.class);
        Intent intent2 = new Intent(this, Rec2Recipe.class);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        String selected_folder = spinner1.getSelectedItem().toString();
        if ((rec1Indicator == true) && (selected_folder.equals("Breakfast"))) {
            FolderOne.REC1ADDEDTOFOLDER = true;
            startActivity(intent1);
        }else if ((rec2Indicator == true) && (selected_folder.equals("Dessert"))) {
            FolderTwo.REC2ADDEDTOFOLDER = true;
            startActivity(intent2);
        } else {
            startActivity(intent);
        }
    }
    /** Called when the user taps cancel with add recipe to folder popup */
    public void cancelAddPopup(View view) {
        Intent intent = new Intent(this, AllRecipes.class);
        Rec1Recipe.POPUPOPENED1 = false;
        Rec2Recipe.POPUPOPENED2 = false;
        startActivity(intent);
    }
}