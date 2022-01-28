package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;
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

public class AmanzoeDesc extends AppCompatActivity {

    ImageButton btPrevious,btNext;
    ImageSwitcher imageSwitcher;

    //TODO add some images for Amanzoe Hotel MUST BE .PNG!
    int imageList[]={R.drawable.Amanzoe2};
    int count=imageList.length;
    int currentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables
        btPrevious=findViewById(R.id.bt_previous);
        btNext=findViewById(R.id.bt_next);
        imageSwitcher=findViewById(R.id.image_switcher);

        // implement the ViewFactory interface and implement
        // unimplemented method that returns an imageView
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
            public View makeView() {
                ImageView imageView= new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT
                        ,ViewGroup.LayoutParams.FILL_PARENT
                ));
                // returning imageview
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageList[0]);
        // set on click listener on left button
        btPrevious.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setting animation to swipe image from right to left
                imageSwitcher.setInAnimation(AmanzoeDesc.this,R.anim.from_right);
                imageSwitcher.setOutAnimation(AmanzoeDesc.this,R.anim.to_left);
                --currentIndex;
                // condition
                if(currentIndex<0)
                    currentIndex=imageList.length-1;
                imageSwitcher.setImageResource((imageList[currentIndex]));
            }
        });

        // set on click listener on right(next) button
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // setting animation to swipe image from left to right
                imageSwitcher.setInAnimation(AmanzoeDesc.this,R.anim.from_left);
                imageSwitcher.setOutAnimation(AmanzoeDesc.this,R.anim.to_right);
                currentIndex++;
                // condition
                if(currentIndex==count)
                    currentIndex=0;
                imageSwitcher.setImageResource(imageList[currentIndex]);
            }
        });
    }
}