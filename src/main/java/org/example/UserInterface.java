package org.example;

import java.util.List;
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

    public UserInterface() {
        this.scanner= new Scanner(System.in);
        this.fileManager = new DealershipFileManager();
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
            System.out.println("\n\t\tWelcome to Toyota");

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
    //pricerange
    public void processGetByPriceRequest(){
        //min amt
        System.out.println("Enter a minimum amount: ");
        double minAmt = scanner.nextDouble();
        //max amt
        System.out.println("Enter a maximum amount: ");
        double maxAmt = scanner.nextDouble();
        //hate scanner numbers
        scanner.nextLine();
        //i have to leave a space please
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minAmt,maxAmt);
        //print
        displayVehicles(vehicles);
    }
    //make model
    public void processGetByMakeModelRequest(){
        System.out.println("Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        //print
        displayVehicles(vehicles);
    }
    //year
    public void processGetByYearRequest(){
        System.out.println("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter a maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }
    //color
    public void processGetByColorRequest(){
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }
    //type
    public void processGetByVehicleTypeRequest(){
        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }
    //mileage
    public void processGetByMileageRequest(){
        System.out.println("Enter a minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.println("Enter a maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);
    }
    //display inv
    public void processAllVehiclesRequest(){
        List<Vehicle> inv =dealership.getInventory();
        displayVehicles(inv);
    }
    //user request
    public void processAddVehicleRequest(){
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Odometer Reading: ");
        int miles = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        //object
        Vehicle newVehicle = new Vehicle(vin,year, make, model, type,
                color, miles,price);
        //add
        dealership.addVehicle(newVehicle);
        //save
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added");
    }
    //remove by vin
    public void processRemoveVehicleRequest(){
        System.out.println("Enter VIN to remove vehicle: ");
        int vinNum = scanner.nextInt();
        scanner.nextLine();
        //loop through inv
        //variable for matcing
        Vehicle removeVehicle = null;
        for (Vehicle vehicle : dealership.getInventory()){
            if (vehicle.getVin() == vinNum){
                removeVehicle = vehicle;
                break;
            }
        }
        //if found, remove
        if (removeVehicle != null){
            dealership.removeVehicle(removeVehicle);
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed!");
        }else {
            System.out.println("Vin does not match!");
        }
    }
    public void displayVehicles(List<Vehicle> vehicles){
        //checking if empty
        if (vehicles.isEmpty()){
            System.out.println("\n No vehicles found under that description");
            return;
        }

        //menu
        for (Vehicle v : vehicles){
            System.out.println("\n==========================================================");
            //vin
            System.out.println("VIN: " + v.getVin());
            //year make model
            System.out.println("Year,Make, Model: " + v.getYear() +  " " + v.getMake()+ " " + v.getModel());
            //type
            System.out.println("Type: " + v.getVehicleType());
            //color
            System.out.println("Color: " + v.getColor());
            //mileage
            System.out.println("Mileage: " + v.getOdometer());
            //price
            System.out.println("Price: " + v.getPrice());
            System.out.println("==================================================================");
        }
    }
}
