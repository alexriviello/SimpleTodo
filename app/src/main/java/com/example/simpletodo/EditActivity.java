package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editItem;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editItem = findViewById(R.id.editItem);
        buttonSave = findViewById(R.id.buttonSave);

        //makes title more descriptive, let user know where they are
        getSupportActionBar().setTitle("Edit Item");

        // Passes in the text from the mainactivity item clicked on
        editItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // Save when user is done editing
        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Create a new intent which contains the new text
                Intent intent = new Intent();
                // Pass the new data to MainActiity
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, editItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // set the result of the intent
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
