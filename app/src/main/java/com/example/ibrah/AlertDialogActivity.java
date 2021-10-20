package com.example.ibrah;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
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
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", this);
        builder.setNegativeButton("No", this);
        AlertDialog dialog=builder.create();
        dialog.show();

    }
}