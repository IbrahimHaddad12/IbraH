package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Reservation extends AppCompatActivity {

    private int numGuests;
    private int numRooms;

    public Reservation(int numGuests, int numRooms){

        this.numGuests=numGuests;
        this.numRooms=numRooms;

    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);





    }
}










