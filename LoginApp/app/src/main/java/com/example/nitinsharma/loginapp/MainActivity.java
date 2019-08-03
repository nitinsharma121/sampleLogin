package com.example.nitinsharma.loginapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nitinsharma.ToDoItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button add;
    RecyclerView recyclerView;
    ItemsBean itemsBean;
    ToDoAdapter adapter;
    ArrayList<ItemsBean> arrayList;
    SQLiteDatabase sqLiteDatabase;

    ToDoItems toDoItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoItems=new ToDoItems(this,"items",null,1);
        sqLiteDatabase=toDoItems.getWritableDatabase();
        sqLiteDatabase=toDoItems.getReadableDatabase();

        arrayList=new ArrayList<>();
        adapter=new ToDoAdapter(this,arrayList);


        arrayList.add(new ItemsBean("Three Copy","For School","false"));
        arrayList.add(new ItemsBean("Dress","For Daughter","false"));

        add=findViewById(R.id.add);
        recyclerView=findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Items;", null);


        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("Title");
            int indexx = cursor.getColumnIndex("Description");

            int index2 = cursor.getColumnIndex("Check_Box");


            String title = cursor.getString(index);
            String description = cursor.getString(indexx);
            String checkBox = cursor.getString(index2);

            arrayList.add(new ItemsBean(title,description,checkBox));
        }
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,AddItem.class);
                startActivityForResult(i,1);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1 && resultCode==RESULT_OK){
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Items;", null);


            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex("Title");
                int indexx = cursor.getColumnIndex("Description");

                int index2 = cursor.getColumnIndex("Check_Box");


                String title = cursor.getString(index);
                String description = cursor.getString(indexx);
                String checkBox = cursor.getString(index2);

                arrayList.add(new ItemsBean(title,description,checkBox));
            }
            recyclerView.setAdapter(adapter);
            Toast.makeText(this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
