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
//this method is called when service is created
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.chopin);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(300,300);

    }
//when the service is started//
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start(); //starts the music
        return super.onStartCommand(intent, flags, startId);
    }
//when the service is destroyed, stop playing the music//
    @Override
    public void onDestroy() {
        mediaPlayer.stop();

    }

}