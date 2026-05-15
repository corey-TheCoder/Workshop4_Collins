package org.example;

import java.io.*;

public class DealershipFileManager {//load Dealership && Vehicle from CSV
    public Dealership getDealership() {
        //dealership variable
        //starts as null
        Dealership dealership = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            //vatiable to hold lines, storing info
            String line = reader.readLine();

            //checking for existence
            if (line != null) {
                String[] parts = line.split("\\|");
                //dealership object, first line?
                dealership = new Dealership(parts[0], parts[1], parts[2]);
            }

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                //creating vehicle
                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                //has a relationship. adds vehicle to dealership inv
                dealership.addVehicle(vehicle);

            }


        } catch (IOException ex) {
            System.out.println("There was a problem reading the inventory file.");
        } catch (Exception e) {
            System.out.println("Something went wrong with the data in the file. ");
        }
        return dealership;

    }
    //save method
    public void saveDealership(Dealership dealership){
        try (BufferedWriter writer = new BufferedWriter( new FileWriter("src/main/resources/Vehicles.csv"))){
            //creating header
            String header = String.format("%s | %s | %s\n",
                    dealership.getName(), dealership.getAddress(), dealership.getPhoneNum());
            //writing header
            writer.write(header);

            for (Vehicle v : dealership.getInventory()){
                //create vehicle
                String vehicleLine = String.format("%d | %d | %s | %s | %s | %s | " +
                        "%d | %.2f\n",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice());

                //write into file
                writer.write(vehicleLine);
            }

        } catch (IOException e){
            System.out.println("Error saving to file.");
        }


    }

}
