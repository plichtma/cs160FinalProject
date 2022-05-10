package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Salad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salad);
    }

    /** Called when the user taps the share icon */
    public void shareRecipe(View view) {
        Intent intent = new Intent(this, ShareRecipe.class);
        startActivity(intent);
    }

    /** Called when the user taps the folder icon to add recipe to folder*/
    public void addRecipeToFolderPopup(View view) {

        Intent intent = new Intent(this, AddRecipeToFolder.class);
        startActivity(intent);
    }

    /** Called when the user taps the back icon to go back to home page*/
    public void backToRecipes(View view) {
        //store indicators then reset them
        Boolean indicator1 = MainActivity.MAINSALAD;
        Boolean indicator2 = AllRecipes.ALLRECSALAD;
        MainActivity.MAINSALAD = false;
        AllRecipes.ALLRECSALAD = false;
        //prepare back options
        Intent intent1 = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, AllRecipes.class);
        if (indicator2 == true) {
            startActivity(intent2);
        } else {
            startActivity(intent1);
        }
    }

    /** Reset instructions when reset is pressed*/
    public void resetInstr(View view) {
        CheckBox eggs = (CheckBox)findViewById(R.id.checkBoxEggs);
        CheckBox salt = (CheckBox)findViewById(R.id.checkBoxSalt);
        CheckBox bp = (CheckBox)findViewById(R.id.checkBoxBP);
        CheckBox milk = (CheckBox)findViewById(R.id.checkBoxMilk);
        if(eggs.isChecked()){
            eggs.toggle();
        }
        if(salt.isChecked()){
            salt.toggle();
        }
        if(bp.isChecked()){
            bp.toggle();
        }
        if(milk.isChecked()){
            milk.toggle();
        }
    }

    /** Reset steps when reset is pressed*/
    public void resetSteps(View view) {
        CheckBox step1 = (CheckBox)findViewById(R.id.checkBoxStep1);
        CheckBox step2 = (CheckBox)findViewById(R.id.checkBoxStep2);
        if(step1.isChecked()){
            step1.toggle();
        }
        if(step2.isChecked()){
            step2.toggle();
        }
    }
}