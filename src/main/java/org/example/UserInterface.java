package org.example;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;
    private DealershipFileManager fileManager;

    //constructor


    public UserInterface(Dealership dealership, Scanner scanner, DealershipFileManager fileManager) {
        this.dealership = dealership;
        this.scanner = scanner;
        this.fileManager = fileManager;
        init();
    }

    //load dealership??
    private void init(){
        //load csv
        this.dealership=fileManager.getDealership();
    }
    //menu loop
}
