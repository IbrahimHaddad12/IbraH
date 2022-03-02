package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.number.Scale;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class AmanzoeDesc extends AppCompatActivity {

    Button CheckOut;
    Button CheckIn;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    DatePickerDialog.OnDateSetListener onCheckOutDateSetListener;
    private ImageSlider ImageSliderAmanzoe;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amanzoe_desc);

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        CheckIn = findViewById(R.id.CheckIn);
        CheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AmanzoeDesc.this, android.R.style.Theme_Holo_Dialog_MinWidth,
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(AmanzoeDesc.this, android.R.style.Theme_Holo_Dialog_MinWidth,
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

        ImageSliderAmanzoe = findViewById(R.id.ImageSliderAmanzoe);

        ArrayList<SlideModel>slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe-Gallery-1.jpg?itok=8Ka85Vdg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe_Gallery_2.jpg?itok=4as4M02m", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe-Greece-9.jpg?itok=pBW5th3P", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe_Gallery_7.jpg?itok=-qpYI1dF", ScaleTypes.FIT));

        ImageSliderAmanzoe.setImageList(slideModels, ScaleTypes.FIT);



    }

}