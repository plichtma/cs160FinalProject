package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

public class Rec2Recipe extends AppCompatActivity {

    public static Boolean POPUPOPENED2 = false;

    public static Boolean NOTEADDED = false;
    public static String NEWNOTE = "";
    public static ScrollView MAINREC2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec2_recipe);
        ScrollView MAINREC2 = (ScrollView) findViewById(R.id.rectwo_layout);

        if (NOTEADDED == true) {
            TextView bullet = (TextView) findViewById(R.id.textViewBulletRec2);
            TextView new_note = (TextView) findViewById(R.id.textViewNewNoteRec2);
            bullet.setVisibility(View.VISIBLE);
            new_note.setText(NEWNOTE);
            new_note.setVisibility(View.VISIBLE);
        }
    }
    /** Called when the user taps the share icon */
    public void shareRecipe(View view) {
        Intent intent = new Intent(this, ShareRecipe.class);
        startActivity(intent);
    }

    /** Called when the user taps the folder icon to add recipe to folder*/
    public void addRecipeToFolderPopup(View view) {
        Intent intent = new Intent(this, AddRecipeToFolder.class);
        POPUPOPENED2 = true;
        startActivity(intent);
    }

    /** Called when the user taps the back icon to go back to home page*/
    public void backToRecipes(View view) {
        //store indicators then reset them
        Boolean indicator1 = AllRecipes.ALLRECPBCOOKIE;
        Boolean indicator2 = FolderTwo.FOLDER2PBCOOKIE;
        AllRecipes.ALLRECPBCOOKIE = false;
        FolderTwo.FOLDER2PBCOOKIE = false;
        //prepare back options
        Intent intent1 = new Intent(this, AllRecipes.class);
        Intent intent2 = new Intent(this, FolderTwo.class);
        if (indicator2 == true) {
            startActivity(intent2);
        } else {
            startActivity(intent1);
        }
    }

    public void saveNote(View view) {
        Intent intent = new Intent(this, Rec2Recipe.class);
        NOTEADDED = true;
        startActivity(intent);
    }

    // dismiss the popup window when cancel button clicked
    public void cancelNote(View view) {
        Intent intent = new Intent(this, Rec2Recipe.class);
        startActivity(intent);
    }


    /**Called when user taps plus button */
    public void onButtonShowNewNotePopupWindow(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.add_note, MAINREC2);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);


        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        EditText addnote = (EditText) popupView.findViewById(R.id.editTextAddedNote);
        addnote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                NEWNOTE = s.toString();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
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
    }

    /** Reset steps when reset is pressed*/
    public void resetSteps(View view) {
        CheckBox step1 = (CheckBox)findViewById(R.id.checkBoxStep1);
        CheckBox step2 = (CheckBox)findViewById(R.id.checkBoxStep2);
        CheckBox step3 = (CheckBox)findViewById(R.id.checkBoxStep3);
        CheckBox step4 = (CheckBox)findViewById(R.id.checkBoxStep4);
        CheckBox step5 = (CheckBox)findViewById(R.id.checkBoxStep5);
        CheckBox step6 = (CheckBox)findViewById(R.id.checkBoxStep6);
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
    }
}