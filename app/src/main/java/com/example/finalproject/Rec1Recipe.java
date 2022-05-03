package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Rec1Recipe extends AppCompatActivity {

    public static Boolean POPUPOPENED1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec1_recipe);
    }
    /** Called when the user taps the share icon */
    public void shareRecipe(View view) {
        Intent intent = new Intent(this, ShareRecipe.class);
        startActivity(intent);
    }

    /** Called when the user taps the folder icon to add recipe to folder*/
    public void addRecipeToFolderPopup(View view) {
        Intent intent = new Intent(this, AddRecipeToFolder.class);
        POPUPOPENED1 = true;
        startActivity(intent);
    }

    /** Called when the user taps the back icon to go back to home page*/
    public void backToRecipes(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
        CheckBox step3 = (CheckBox)findViewById(R.id.checkBoxStep3);
        CheckBox step4 = (CheckBox)findViewById(R.id.checkBoxStep4);
        CheckBox step5 = (CheckBox)findViewById(R.id.checkBoxStep5);
        CheckBox step6 = (CheckBox)findViewById(R.id.checkBoxStep6);
        CheckBox step7 = (CheckBox)findViewById(R.id.checkBoxStep7);
        if(step1.isChecked()){
            step1.toggle();
        }
        if(step2.isChecked()){
            step2.toggle();
        }
        if(step3.isChecked()){
            step3.toggle();
        }
        if(step4.isChecked()){
            step4.toggle();
        }
        if(step5.isChecked()){
            step5.toggle();
        }
        if(step6.isChecked()){
            step6.toggle();
        }
        if(step7.isChecked()){
            step7.toggle();
        }
    }

}