package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {//Restaurant class
    private String name;
    private String address;
    private String phoneNum;
    //compared to previous projects, this declaration allows each DEALERSHIP do have its own inventory
    //one dealership could have 500, while the others 12
    //no data sharing
    private ArrayList<Vehicle> inventory;

    //constructor
    public Dealership(String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.inventory = new ArrayList<>();
    }

    //getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    //this gets vehicles doesnt it??
    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = new ArrayList<>(inventory);
    }

    //add vehicle
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    //remove vehicle
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
    //price
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v: inventory){
            if (v.getPrice() >= min && v.getPrice() <= max){
                results.add(v);
            }
        }
        return results;
    }

    //make or model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
                results.add(v);
        }
        return results;
    }

    //year
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v: inventory){
            if (v.getYear() >= min && v.getYear() <= max){
                results.add(v);
            }
        }
        return results;
    }
    //color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                results.add(v);
            }
        }
        return results;
    }
    //mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v: inventory){
            if (v.getOdometer() >= min && v.getOdometer() <= max){
                results.add(v);
            }
        }
        return results;
    }
    //type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v: inventory){
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(v);
            }
        }
        return results;
    }
    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle v : inventory) {
            if (v.getVin() == vin) {
                return v;
            }
        }
        return null;
    }

}
