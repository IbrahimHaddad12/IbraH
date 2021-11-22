package com.example.ibrah;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    MediaPlayer mediaPlayer;


    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
     return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.chopin);

    }
}