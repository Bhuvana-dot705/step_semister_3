import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10;
    }

    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }

    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return Math.max(hours * 50, 100);
    }

    String getType() {
        return "TRUCK";
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Vehicle[] vehicles = new Vehicle[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
            }
        }

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            total += charge;

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}