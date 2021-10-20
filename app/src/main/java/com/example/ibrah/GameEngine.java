package com.example.ibrah;

import android.content.Context;

public class GameEngine {

    private static GameEngine instance;

    private Context context;

    public static GameEngine getInstance() {

        if(instance == null){

            instance = new GameEngine();

        }
        return instance;

    }

    private GameEngine(){

    }

    public void createGrid(Context context){
        this.context = context;

        //create the grid and store it//

    }

}


