import java.util.*;

abstract class Booking {

    // Common fee written only once
    static final double BOOKING_FEE = 50.0;

    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    abstract String getMode();
}

class Bus extends Booking {

    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class Train extends Booking {

    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class Flight extends Booking {

    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + (distance * 4);
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class Travel{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;
            }
        }

        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n",
                    booking.getMode(),
                    booking.calculateTotal());
        }

        sc.close();
    }
}