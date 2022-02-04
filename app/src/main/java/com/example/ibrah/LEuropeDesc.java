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

public class LEuropeDesc extends AppCompatActivity {

    private ImageSlider ImageSliderLEurope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leurope_desc);

        ImageSliderLEurope = findViewById(R.id.ImageSliderLEurope);

        ArrayList<SlideModel>slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://res.cloudinary.com/grand-luxury/image/upload/w_1440,q_50,f_auto,c_fill,g_center,dpr_1/remote_glh/original/100461-root-exteriors-front-facade.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.deleurope.com/wp-content/uploads/DLE_Rondeel_10414-512x360.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://res.cloudinary.com/grand-luxury/image/upload/w_1440,q_50,f_auto,c_fill,g_center,dpr_1/remote_glh/original/102096-root-premium-deluxe-river-view-bed.jpg", ScaleTypes.FIT));


        ImageSliderLEurope.setImageList(slideModels, ScaleTypes.FIT);

    }
}