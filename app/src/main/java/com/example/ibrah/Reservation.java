package com.example.ibrah;

public class Reservation {

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


}
