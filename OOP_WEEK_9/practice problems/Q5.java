import java.util.*;

interface SaverMode {
    double applySaverMode(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();
    abstract String getType();

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {

    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getType() {
        return "AC";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getType() {
        return "WASHER";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] input = line.split(" ");

            String type = input[0];
            double hours = Double.parseDouble(input[1]);

            boolean saver = input.length == 3
                    && input[2].equals("SAVER");

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AirConditioner(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours);
                    break;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(appliance.getType()
                        + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance)
                        .applySaverMode(units);
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}