package com.example.common;

import java.util.ArrayList;

public class Garage {

    private String name;
    private String address;
    private boolean open;
    private ArrayList<String> Cars;

    public Garage() { }

    public Garage(String name, String address, boolean open, ArrayList<String> cars) {
        this.name = name;
        this.address = address;
        this.open = open;
        Cars = cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setCars(ArrayList<String> cars) {
        Cars = cars;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean isOpen() {
        return open;
    }

    public ArrayList<String> getCars() {
        return Cars;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", open=" + open +
                ", Cars=" + Cars +
                '}';
    }
}
