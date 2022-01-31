package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Scale;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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


public class AmanzoeDesc extends AppCompatActivity {

    private ImageSlider ImageSliderAmanzoe;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amanzoe_desc);

        ImageSliderAmanzoe = findViewById(R.id.ImageSliderAmanzoe);

        ArrayList<SlideModel>slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe-Gallery-1.jpg?itok=8Ka85Vdg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe_Gallery_2.jpg?itok=4as4M02m", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe-Greece-9.jpg?itok=pBW5th3P", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.aman.com/sites/default/files/styles/masonry_extra_large/public/2021-03/Amanzoe_Gallery_7.jpg?itok=-qpYI1dF", ScaleTypes.FIT));

        ImageSliderAmanzoe.setImageList(slideModels, ScaleTypes.FIT);



    }






}