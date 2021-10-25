package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnLongClickListener {

    private Button buttonlogin;
    private Button buttonsignup;
    private EditText editTextPassword, editTextTextEmailAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonlogin = findViewById(R.id.buttonlogin);

        //sets the required button to response to long click,otherwise it won't
        buttonlogin.setOnLongClickListener(this);
        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        String email = sp.getString("email", "");
        String password = sp.getString("password", "");
        if(!email.equals("")&& !password.equals("")){
            editTextTextEmailAddress.setText(email);
            editTextPassword.setText(password);
        }
    }


    public void login(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        if (!editTextTextEmailAddress.getText().toString().equals("")){
            //saving email and password of user in a local file for future use
            //create sp file
            SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor = sp.edit();
            //write the wanted settings
            editor.putString("email", editTextTextEmailAddress.getText().toString());
            editor.putString("password", editTextPassword.getText().toString());

            //save and close file
            editor.commit();


        startActivity(intent);
    }

}
    public void signup(View view) {
        Intent intent = new Intent( this, SignUpActivity.class);
        startActivity(intent);
    }
    //clears the email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextTextEmailAddress.setText("");
        editTextPassword.setText("");
        return true;
    }
}