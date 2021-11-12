package com.example.ibrah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HotelPageActivity extends AppCompatActivity implements DialogInterface.OnClickListener{


    private TextView textViewTakePicture;
    private Button ButtonCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_page);

        textViewTakePicture = findViewById(R.id.textViewTakePicture);
        ButtonCamera= findViewById(R.id.Camera);

        String name = getIntent().getStringExtra( "name");

        ButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraActivity();
            }

            private void CameraActivity() {
                Intent intent= new Intent(HotelPageActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==dialog.BUTTON_POSITIVE){
            super.onBackPressed();
            dialog.cancel();
        }
        if(which==dialog.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }
    @Override
    public void onBackPressed(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", this);
        builder.setNegativeButton("No", this);
        AlertDialog dialog=builder.create();
        dialog.show();

    }


    //inflate the design of the required menu on top of the activity//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settingsmenu:
                Toast.makeText(this,"Settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                //  closeApplication();//

                break;
        }
        return super.onOptionsItemSelected(item);
    }


}