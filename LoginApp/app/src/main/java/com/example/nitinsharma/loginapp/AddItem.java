package com.example.nitinsharma.loginapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.nitinsharma.ToDoItems;

public class AddItem extends AppCompatActivity {
    EditText title,description;
    Button done;
    String titleContent,descriptionContent;
    ImageButton back;
    int check;
    ToDoItems toDoItems;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        toDoItems=new ToDoItems(this,"Items",null,1);
        sqLiteDatabase=toDoItems.getWritableDatabase();
        sqLiteDatabase=toDoItems.getReadableDatabase();

        title=findViewById(R.id.title);
        description=findViewById(R.id.des);



        done=findViewById(R.id.done);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem.super.onBackPressed();
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                checkData();
                if(check==2){
                    ContentValues values = new ContentValues();
                    values.put("Title", titleContent);
                    values.put("Description", descriptionContent);
                    values.put("Check_Box","false");
                    sqLiteDatabase.insert("Items", null, values);
                    Intent i=new Intent(AddItem.this,MainActivity.class);
                    setResult(RESULT_OK,i);
                    finish();
                }

            }
        });

    }
    public void getData(){
        titleContent=title.getText().toString().trim();
        descriptionContent=description.getText().toString().trim();


    }

    public void checkData(){
        if(titleContent.isEmpty()){
            title.setError("Pls Enter Title!!");
            check=0;
        }
        else if(descriptionContent.isEmpty()){
            description.setError("Pls Enter Description!!");
            check=0;
        }
        else{
            check=2;
        }

    }
}
