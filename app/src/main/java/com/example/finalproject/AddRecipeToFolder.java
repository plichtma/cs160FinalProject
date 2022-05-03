package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddRecipeToFolder extends AppCompatActivity {

    public static String RECIPE;

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
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        String selected_folder = spinner1.getSelectedItem().toString();
        //((RECIPE == "rec1") && (selected_folder == "Breakfast"))
        if ((Rec1Recipe.POPUPOPENED == true) && (selected_folder.equals("Breakfast"))) {
            FolderOne.REC1ADDEDTOFOLDER = true;
        }
        Intent intent = new Intent(this, Rec1Recipe.class);
        Rec1Recipe.POPUPOPENED = false;
        startActivity(intent);
    }
    /** Called when the user taps cancel with add recipe to folder popup */
    public void cancelAddPopup(View view) {
        Intent intent = new Intent(this, Rec1Recipe.class);
        Rec1Recipe.POPUPOPENED = false;
        startActivity(intent);
    }
}