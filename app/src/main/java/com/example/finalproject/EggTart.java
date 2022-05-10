package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;

public class EggTart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egg_tart);
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
        Boolean indicator1 = MainActivity.MAINEGGTART;
        Boolean indicator2 = AllRecipes.ALLRECEGGTART;
        Boolean indicator3 = FolderTwo.FOLDER2EGGTART;
        MainActivity.MAINEGGTART = false;
        AllRecipes.ALLRECEGGTART =  false;
        FolderTwo.FOLDER2EGGTART = false;
        //prepare back options
        Intent intent1 = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, AllRecipes.class);
        Intent intent3 = new Intent(this, FolderTwo.class);
        if (indicator2 == true) {
            startActivity(intent2);
        } else if (indicator3 == true) {
            startActivity(intent3);
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