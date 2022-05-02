package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Recommended1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended1);

    }

    /** Called when the user taps the folder icon to add recipe to folder*/
    public void addRecipeToFolderPopup(View view) {
        Intent intent = new Intent(this, AddRecipeToFolder.class);
        startActivity(intent);
    }
    /** Called when the user taps the back icon to go back to home page*/
    public void addToRecipes(View view) {
        Recommended.ADDED1 = true;
    }
    /** Called when the user taps the back icon to go back to home page*/
    public void backToRecommended(View view) {
        Intent intent = new Intent(this, Recommended.class);
        startActivity(intent);
    }
}