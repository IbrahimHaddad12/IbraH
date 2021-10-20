package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayListActivity extends AppCompatActivity {

    //the object of the view - design
    private ListView myListView;
    //the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;
    //object containing the items to be displayed - data
    private ArrayList<Item> list;   //Item laken e7na bedna n3'ayro l hotel//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);

        list = new ArrayList<>();
        list.add(new Item("this is my first item", R.drawable.ronaldo, true, 50));
        list.add(new Item("this is not my first item", R.drawable.ic_launcher_background, true, 51));

        //reference to the list view so it can be programmed
        myListView = findViewById(R.id.myListView);
        //connect adapter with data
        myAdapter = new CustomAdapter(this, R.layout.item_row, list);
        //connect adapted with view
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Item: " + list.get(i), Toast.LENGTH_LONG).show();
            }
        });
    myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            list.remove(i);
            myAdapter.notifyDataSetChanged();
            return false;
        }
    });

    }
}