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
    public void display() {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Toyota");

            //MENU - options
            System.out.println("1. Search by a price range: ");
            System.out.println("2. Search by make or model ");
            System.out.println("3. Search by year: ");
            System.out.println("4. Search by color: ");
            System.out.println("5. Search by mileage range: ");
            System.out.println("6. Find vehicles by type (car, truck, SUV, van): ");
            System.out.println("7.  List all vehicles: ");
            System.out.println("8. Add a vehicle: ");
            System.out.println("9. Remove a vehicle: ");
            System.out.println("99. Exit!");

            //userinput
            System.out.println("Select an option from the menu above: ");
            String userInput = scanner.nextLine();

            //menu option handling
            switch (userInput) {

                case "1":
                    processGetByPriceRequest();
                    break;

                case "2":
                    processGetByMakeModelRequest();
                    break;

                case "3":
                    processGetByYearRequest();
                    break;

                case "4":
                    processGetByColorRequest();
                    break;

                case "5":
                    processGetByMileageRequest();
                    break;

                case "6":
                    processGetByVehicleTypeRequest();
                    break;

                case "7":
                    processAllVehiclesRequest();
                    break;

                case "8":
                    processAddVehicleRequest();
                    break;

                case "9":
                    processRemoveVehicleRequest();
                    break;

                case "99":
                    //stop loop
                    running = false;
                    break;

                default:
                    System.out.println("Please select a number from the list above");
            }
        }
    }

    public void processGetByPriceRequest(){
        //min amt
        System.out.println("Enter a minimum amount: ");
        double minAmt = scanner.nextDouble();
        //max amt
        System.out.println("Enter a maximum amount: ");
        double maxAmt = scanner.nextDouble();
        //hate scanner numbers
        scanner.nextLine();
    }
}
