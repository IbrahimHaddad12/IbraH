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


public class MurakaDesc extends AppCompatActivity {

    private ImageSlider ImageSliderMuraka;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muraka_desc);

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