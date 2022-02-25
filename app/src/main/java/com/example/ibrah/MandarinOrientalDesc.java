package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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

    private ImageSlider ImageSliderMuraka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandarin_oriental_desc);

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