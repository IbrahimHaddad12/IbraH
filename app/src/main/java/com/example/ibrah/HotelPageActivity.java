package com.example.ibrah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HotelPageActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final int NOTIFICATION_REMINDER_NIGHT = 1;
    private FirebaseAuth maFirebaseAuth = FirebaseAuth.getInstance();
    // Write a message to the database
    //TODO fix https
    private FirebaseDatabase database = FirebaseDatabase.getInstance(https://ibrah-99f52-default-rtdb.europe-west1.firebasedatabase.app/);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_page);



        String UID = maFirebaseAuth.getUid();
        DatabaseReference myRef = database.getReference("users/"+UID);



        String name = getIntent().getStringExtra( "name");

        Intent notifyIntent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000*60*60*24, pendingIntent);

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
  public void Amanzoe(View view){

        //TODO change destination to amanzoe description page...
      Intent intent= new Intent(HotelPageActivity.this,SignUpActivity.class);
      startActivity(intent);
  }
    public void Muraka(View view){

        //TODO change destination to Muraka description page...
        Intent intent= new Intent(HotelPageActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void DeLEurope(View view){

        //TODO change destination to De L'Europe Amsterdam description page...
        Intent intent= new Intent(HotelPageActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

}

