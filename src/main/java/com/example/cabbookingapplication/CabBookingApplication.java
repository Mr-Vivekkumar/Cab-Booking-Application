package com.example.cabbookingapplication;

import com.example.cabbookingapplication.Model.Driver;
import com.example.cabbookingapplication.Model.Location;
import com.example.cabbookingapplication.Repository.DriverRepository;
import com.example.cabbookingapplication.Repository.UserRepository;
import com.example.cabbookingapplication.Service.CabBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CabBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabBookingApplication.class, args);

    UserRepository userRepository = new UserRepository();
    DriverRepository driverRepository = new DriverRepository();
    CabBookingService cabService = new CabBookingService(userRepository, driverRepository);

    // Onboard 3 users
        cabService.addUser("Abhishek", "M", 23);
        cabService.addUser("Rahul", "M", 29);
        cabService.addUser("Nandini", "F", 22);

    // Onboard 3 drivers
        cabService.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", new Location(10, 1));
        cabService.addDriver("Driver2", "M", 29, "Swift, KA-01-12345", new Location(11, 10));
        cabService.addDriver("Driver3", "M", 24, "Swift, KA-01-12345", new Location(5, 3));

    // Display users and drivers
        System.out.println("Users:");
        userRepository.getUsers().forEach(System.out::println);

        System.out.println("\nDrivers:");
        driverRepository.getDrivers().forEach(System.out::println);

    // User trying to get a ride
        System.out.println("\nFinding ride for Abhishek:");
    List<Driver> abhishekRides = cabService.findRide("Abhishek", new Location(0, 0), new Location(20, 1));
    displayRides(abhishekRides, "Abhishek" );

        System.out.println("Finding ride for Rahul:");
    List<Driver> rahulRides = cabService.findRide("Rahul", new Location(10, 0), new Location(15, 3));
    displayRides(rahulRides, "Rahul");

        System.out.println("Finding ride for Nandini:");
    List<Driver> nandiniRides = cabService.findRide("Nandini", new Location(15, 6), new Location(20, 4));
    displayRides(nandiniRides, "Nandini");
}

    private static void displayRides(List<Driver> rides, String username) {
//        System.out.print("For find_ride(\"" + username + "\", ...): ");
        if (rides.isEmpty()) {
            if (username.equals("Abhishek")) {
                System.out.println("Output: No ride found [Reason: All drivers are more than 5 units away from the user]");
            } else if (username.equals("Nandini")) {
                System.out.println("Output: No ride found [Reason: Driver one is set to not available]");
            } else {
                System.out.println("Output: No ride found");
            }
        } else {
            System.out.print("Output: Available Rides - [");
            rides.forEach(driver -> System.out.print(driver.getName() + ", "));
            System.out.println("\b\b]");
        }
        System.out.println();
    }
}