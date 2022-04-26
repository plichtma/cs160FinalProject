package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class CreateRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        final EditText edit_title = findViewById(R.id.editTextRecipeName);
        final EditText edit_ingredients = findViewById(R.id.editTextAddIngredients);
        final EditText edit_steps = findViewById(R.id.editTextAddNewStep);
        Button save_btn = findViewById(R.id.saveBtn);

    }
}