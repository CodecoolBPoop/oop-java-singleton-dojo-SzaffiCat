package com.codecool.singletonDojo;

import java.time.LocalTime;

public class PrinterElement {

    private int id;
    private static int idCounter = 0;
    private LocalTime busyEndTime;


    public PrinterElement(){
        this.id = idCounter;
        idCounter++;
        busyEndTime = LocalTime.now();
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return LocalTime.now().isAfter(busyEndTime);

    }

    public void reserve() {
        busyEndTime = LocalTime.now().plusSeconds(5);
    }
}
