package com.codecool.singletonDojo;

public class PrinterManager {

    // TASKS:
    // 1. Make PrinterPool class a Singleton. I want to access an instance of the PrinterPool class from anywhere in my code
    //    and call its print() method.
    // 2. Implement pooling: Assume we have 10 printers in the office, each with a different Id. The singleton
    //    accessor should return a random printer from these ten that is not busy. If all are busy return a random one.
    //    Keep the instances of these printers in the PrinterPool class.
    //
    // Write some code that tests all functionality!

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            PrinterPool printerPool = PrinterPool.getInstance();
            printerPool.print("Something to print.");
        }
    }

}
