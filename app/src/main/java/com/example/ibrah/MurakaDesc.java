package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.number.Scale;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Calendar;


public class MurakaDesc extends AppCompatActivity {

    Button CheckOut;
    Button CheckIn;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    DatePickerDialog.OnDateSetListener onCheckOutDateSetListener;
    private ImageSlider ImageSliderMuraka;
    Button ReserveHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muraka_desc);

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        ReserveHotel=findViewById(R.id.ReserveHotel);
        ReserveHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MurakaDesc.this);
                builder.setTitle("Reserve");
                builder.setMessage("Are you sure you want to reserve a spot?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MurakaDesc.this, "Thank you for your order", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create();
                builder.show();
            }
        });


        CheckIn = findViewById(R.id.CheckIn);
        CheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MurakaDesc.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                CheckIn.setText(date);
            }
        };

        CheckOut = findViewById(R.id.CheckOut);
        CheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MurakaDesc.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        onCheckOutDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        onCheckOutDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                CheckOut.setText(date);
            }
        };

        ImageSliderMuraka = findViewById(R.id.ImageSliderMuraka);

        ArrayList<SlideModel>slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://www.conradmaldives.com/wp-content/uploads/2020/12/The-MURAKA-Sunrise-Deck-1063x614.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.conradmaldives.com/wp-content/uploads/2021/05/The-Muraka-Entrance-1-1063x614.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.conradmaldives.com/wp-content/uploads/2021/05/The-MURAKA-Underwater-Villa-1063x614.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.conradmaldives.com/wp-content/uploads/2021/05/Grand-Water-Villa-Whirlpool-Deck-Drone-Shot-1063x614.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.conradmaldives.com/wp-content/uploads/2021/05/Sunset-Water-Villa-with-Pool-Deck-1063x614.jpg", ScaleTypes.FIT));

        ImageSliderMuraka.setImageList(slideModels, ScaleTypes.FIT);



    }


}