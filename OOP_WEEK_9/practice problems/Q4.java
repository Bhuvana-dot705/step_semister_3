import java.util.*;

interface NightService {
    double calculateNightFare(double fare);
}

abstract class Cab {
    static final double MINIMUM_FARE = 100;

    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();
    abstract String getType();

    double calculateBaseFare() {
        double fare = km * getRate();
        return Math.max(fare, MINIMUM_FARE);
    }
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {

    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    String getType() {
        return "SEDAN";
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {

    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    String getType() {
        return "SUV";
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(cab.getType()
                        + ": night service not available");
            } else {
                double fare = cab.calculateBaseFare();

                if (time.equals("NIGHT")) {
                    fare = ((NightService) cab)
                            .calculateNightFare(fare);
                }

                total += fare;

                System.out.printf("%s: %.2f%n",
                        cab.getType(), fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}