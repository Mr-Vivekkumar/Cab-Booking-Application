package com.example.cabbookingapplication.Model;

public class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private boolean isAvailable;
    private Location currentLocation;

    public Driver(String name, String gender, int age, String vehicleDetails, Location currentLocation) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.isAvailable = true;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ", " + age + " years old) - " + vehicleDetails +
                " (Available: " + isAvailable + ", Location: " + currentLocation + ")";
    }

    public void setDriverAvailability(String driverName, boolean b) {
    }
}
