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
        Intent intent = new Intent(this, EggTart.class);
        startActivity(intent);
    }
    /** Called when the user taps cancel with add recipe to folder popup */
    public void cancelAddPopup(View view) {
        Intent intent = new Intent(this, EggTart.class);
        startActivity(intent);
    }
}