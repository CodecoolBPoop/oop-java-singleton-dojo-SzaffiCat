package com.codecool.singletonDojo;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.Random;

public class PrinterPool {

    private static PrinterElement[] printerElementInstances = new PrinterElement[10];
    private static final PrinterPool instance = new PrinterPool();
    private Random random = new Random();

    static {
        for (int printerCounter = 0; printerCounter < printerElementInstances.length; printerCounter++) {
            printerElementInstances[printerCounter] = new PrinterElement();
        }
    }

    private PrinterPool() {
    }

    public static PrinterPool getInstance(){
        return instance;
    }

    // Prints out the given String
    public void print(String toPrint) {
        PrinterElement printer = getAvailablePrinter();
        if (printer == null){
            printer = printerElementInstances[random.nextInt(printerElementInstances.length)];
        } else{
            printer.reserve();
        }
        System.out.println("PrinterPool " + printer.getId() + " is printing.");
    }

    private PrinterElement getAvailablePrinter(){
        PrinterElement printer= null;
        for (int i = 0; i < printerElementInstances.length && printer == null; i++) { //TODO:with random number
            if (printerElementInstances[i].isAvailable()) {
                printer = printerElementInstances[i];
            }
        }
        return printer;
    }
}
