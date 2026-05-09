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
    private List<Vehicle> inventory;

    //constructor


    public Dealership(String name, String address, String phoneNum, List<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.inventory = inventory;


        //creating object
        inventory = new ArrayList<>();
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

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }
}
