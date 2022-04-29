package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateRecipe extends AppCompatActivity {

    private ListView ingredientsListView = null;
    private ListView stepListView = null;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        // Create references to the objects in the main layout
        ingredientsListView = (ListView)findViewById(R.id.lvItems);
        stepListView = (ListView)findViewById(R.id.lvStepItems);
        final EditText edit_title = findViewById(R.id.editTextRecipeName);
        Button uploadImgBtn = findViewById(R.id.uploadImgBtn);
        Button saveBtn = findViewById(R.id.saveBtn);
        ImageView img = findViewById(R.id.imgView);
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.numStars);
        final EditText editItem = (EditText)findViewById(R.id.enterNewItem);
        final EditText editStep = (EditText)findViewById(R.id.enterNewStep);


        // upload img button
        uploadImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


        // Create a an arraylist to hold all the items
        final ArrayList<String> ingredientsList = new ArrayList<String>();
        final ArrayList<String> stepsList = new ArrayList<String>();

        // Create an ArrayAdaptor object to be able to bind ArrayLists to ListViews
        final ArrayAdapter<String> ingredientsArrayAdaptor = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ingredientsList);
        ingredientsListView.setAdapter(ingredientsArrayAdaptor);

//        final ArrayAdapter<String> stepsArrayAdaptor = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, stepsList);
//        ingredientsListView.setAdapter(stepsArrayAdaptor);

        // Listens for certain keys to be pushed, particular the dpad center key or enter key
        editItem.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER)) {
                        // add item in the EditText to the ingredients list
                        ingredientsList.add(0, editItem.getText().toString());
                        //Update the view by notifying the ArrayAdapter of the data changes
                        ingredientsArrayAdaptor.notifyDataSetChanged();
                        editItem.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }

    // Upload Image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

    /** Called when the user taps the Update button */
    public void saveRecipe(View view) {
        Button button = (Button) findViewById(R.id.saveBtn);
        EditText editTextRecipeName = (EditText) findViewById(R.id.editTextRecipeName);
        EditText editTimeToCook = (EditText) findViewById(R.id.timeToCook);
        EditText editDateAdded = (EditText) findViewById(R.id.dateAdded);
        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.numStars);
        int ratingNumber =  simpleRatingBar.getNumStars(); // get rating number from a rating bar

    }

    /** Called when the user taps the Back Button under Create Recipe */
    public void allRecipes(View view) {
        Intent intent = new Intent(this, AllRecipes.class);
        startActivity(intent);
    }


}