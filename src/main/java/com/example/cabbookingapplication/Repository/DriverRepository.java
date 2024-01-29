package com.example.cabbookingapplication.Repository;

import com.example.cabbookingapplication.Model.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverRepository {
    private List<Driver> drivers;

    public DriverRepository() {
        this.drivers = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public synchronized Driver findDriverByName(String driverName) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(driverName)) {
                return driver;
            }
        }
        return null;
    }

    public synchronized List<Driver> getDrivers() {
        return drivers;
    }


}
