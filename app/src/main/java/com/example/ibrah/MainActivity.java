package com.example.ibrah;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends Activity implements View.OnLongClickListener {


    private static final String TAG = "FIREBASE";
    private Button buttonlogin;
    private Button buttonsignup;
    private EditText editTextPassword, editTextTextEmailAddress;
    private FirebaseAuth mAuth;
    private Intent musicIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize firebase auth
        mAuth = FirebaseAuth.getInstance();

        //this will start the service, as a result so will the music
        musicIntent = new Intent(this, MusicService.class);
        startService(musicIntent);



        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonlogin = findViewById(R.id.buttonlogin);
        buttonsignup=findViewById(R.id.buttonsignup);

        //sets the required button to response to long click,otherwise it won't
        buttonlogin.setOnLongClickListener(this);
        buttonsignup.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        }));

        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        String email = sp.getString("email", "");
        String password = sp.getString("password", "");
        if(!email.equals("")&& !password.equals("")){
            editTextTextEmailAddress.setText(email);
            editTextPassword.setText(password);
        }
    }

    public void login(View view) {
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

            // startActivity(intent)

    }
    login(editTextTextEmailAddress.getText().toString(), editTextPassword.getText().toString());
}

    //clears the email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
        editTextTextEmailAddress.setText("");
        editTextPassword.setText("");
        return true;
    }

   public void login(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           // Sign in success, update UI with the signed-in user's information
                           Log.d(TAG, "signInWithEmail:success");
                           FirebaseUser user = mAuth.getCurrentUser();
                           Intent intent = new Intent(MainActivity.this, HotelPageActivity.class);
                           intent.putExtra("name", editTextTextEmailAddress.getText().toString());
                           startActivity(intent);


                       } else {
                           // If sign in fails, display a message to the user.
                           Log.w(TAG, "signInWithEmail:failure", task.getException());
                           Toast.makeText(MainActivity.this, "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();

                       }

                       // ...
                   }
               });


   }


}