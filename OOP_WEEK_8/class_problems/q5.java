import java.util.*;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return Math.min(2 + (0.10 * distance), 10);
    }

    @Override
    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    String getType() {
        return "METRO";
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double distance = Double.parseDouble(input[1]);

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;

                case "TRAIN":
                    transport = new Train(distance);
                    break;

                case "METRO":
                    double peakHourFactor =
                            Double.parseDouble(input[2]);

                    transport = new Metro(distance, peakHourFactor);
                    break;

                default:
                    continue;
            }

            double fare = transport.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    transport.getType(),
                    fare
            );

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}