package com.carrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Car Rental Agency!");
            System.out.println("1. Input Vehicle Details");
            System.out.println("2. Display Vehicle Details");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inputVehicleDetails(scanner);
                    break;
                case 2:
                    displayVehicleDetails(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();
    }

    private static void inputVehicleDetails(Scanner scanner) {
        System.out.println("Enter vehicle type (Car, Motorcycle, Truck): ");
        String vehicleType = scanner.nextLine();

        Vehicle vehicle = null;

        switch (vehicleType.toLowerCase()) {
            case "car":
                vehicle = createCar(scanner);
                break;
            case "motorcycle":
                vehicle = createMotorcycle(scanner);
                break;
            case "truck":
                vehicle = createTruck(scanner);
                break;
            default:
                System.out.println("Invalid vehicle type!");
                return;
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private static Car createCar(Scanner scanner) {
        System.out.println("Enter car make: ");
        String make = scanner.nextLine();
        System.out.println("Enter car model: ");
        String model = scanner.nextLine();
        System.out.println("Enter car year of manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter number of doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter fuel type (Petrol, Diesel, Electric): ");
        String fuelType = scanner.nextLine();

        Car car = new Car(make, model, year);
        car.setNumberOfDoors(doors);
        car.setFuelType(fuelType);

        return car;
    }

    private static Motorcycle createMotorcycle(Scanner scanner) {
        System.out.println("Enter motorcycle make: ");
        String make = scanner.nextLine();
        System.out.println("Enter motorcycle model: ");
        String model = scanner.nextLine();
        System.out.println("Enter motorcycle year of manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter number of wheels: ");
        int wheels = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter motorcycle type (Sport, Cruiser, Off-road): ");
        String type = scanner.nextLine();

        Motorcycle motorcycle = new Motorcycle(make, model, year);
        motorcycle.setNumberOfWheels(wheels);
        motorcycle.setMotorcycleType(type);

        return motorcycle;
    }

    private static Truck createTruck(Scanner scanner) {
        System.out.println("Enter truck make: ");
        String make = scanner.nextLine();
        System.out.println("Enter truck model: ");
        String model = scanner.nextLine();
        System.out.println("Enter truck year of manufacture: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter cargo capacity (in tons): ");
        double capacity = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter transmission type (Manual, Automatic): ");
        String transmission = scanner.nextLine();

        Truck truck = new Truck(make, model, year);
        truck.setCargoCapacity(capacity);
        truck.setTransmissionType(transmission);

        return truck;
    }

    private static void displayVehicleDetails(Scanner scanner) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to display.");
            return;
        }

        System.out.println("Enter vehicle type to display (Car, Motorcycle, Truck): ");
        String vehicleType = scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicleType.equalsIgnoreCase("car") && vehicle instanceof Car) {
                displayCarDetails((Car) vehicle);
            } else if (vehicleType.equalsIgnoreCase("motorcycle") && vehicle instanceof Motorcycle) {
                displayMotorcycleDetails((Motorcycle) vehicle);
            } else if (vehicleType.equalsIgnoreCase("truck") && vehicle instanceof Truck) {
                displayTruckDetails((Truck) vehicle);
            }
        }
    }

    private static void displayCarDetails(Car car) {
        System.out.println("Car Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
        System.out.println("Fuel Type: " + car.getFuelType());
    }

    private static void displayMotorcycleDetails(Motorcycle motorcycle) {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
        System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
    }

    private static void displayTruckDetails(Truck truck) {
        System.out.println("Truck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());
    }
}