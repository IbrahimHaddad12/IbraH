package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Calendar;

public class MandarinOrientalDesc extends AppCompatActivity {

    Button CheckOut;
    Button CheckIn;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    DatePickerDialog.OnDateSetListener onCheckOutDateSetListener;
    private ImageSlider ImageSliderMuraka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandarin_oriental_desc);

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        CheckIn = findViewById(R.id.CheckIn);
        CheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MandarinOrientalDesc.this, android.R.style.Theme_Holo_Dialog_MinWidth,
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(MandarinOrientalDesc.this, android.R.style.Theme_Holo_Dialog_MinWidth,
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

        ImageSliderMuraka = findViewById(R.id.ImageSliderMandarinOriental);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://photos.mandarinoriental.com/is/image/MandarinOriental/canouan-accommodation-lagoon-villa-exterior?wid=540&hei=366&fmt=jpeg&qlt=75,0&op_sharpen=0&resMode=sharp2&op_usm=0,0,0,0&iccEmbed=0&printRes=72&fit=crop", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://photos.mandarinoriental.com/is/image/MandarinOriental/canouan-accommodation-patio-villa-04?wid=540&hei=366&fmt=jpeg&qlt=75,0&op_sharpen=0&resMode=sharp2&op_usm=0,0,0,0&iccEmbed=0&printRes=72&fit=crop", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://photos.mandarinoriental.com/is/image/MandarinOriental/canouan-hotel-entrance?wid=540&hei=366&fmt=jpeg&qlt=75,0&op_sharpen=0&resMode=sharp2&op_usm=0,0,0,0&iccEmbed=0&printRes=72&fit=crop", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://photos.mandarinoriental.com/is/image/MandarinOriental/canouan-fine-dining-romeo-01?wid=540&hei=680&fmt=jpeg&qlt=75,0&op_sharpen=0&resMode=sharp2&op_usm=0,0,0,0&iccEmbed=0&printRes=72&fit=crop", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://photos.mandarinoriental.com/is/image/MandarinOriental/canouan-accommodation-one-bedroom-beachfront-suite-exterior?wid=540&hei=680&fmt=jpeg&qlt=75,0&op_sharpen=0&resMode=sharp2&op_usm=0,0,0,0&iccEmbed=0&printRes=72&fit=crop", ScaleTypes.FIT));

        ImageSliderMuraka.setImageList(slideModels, ScaleTypes.FIT);


    }
}