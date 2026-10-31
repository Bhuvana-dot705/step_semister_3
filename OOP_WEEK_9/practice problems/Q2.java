import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
    abstract String getType();
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels[i] = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new ExpressParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new FragileParcel(weight, value);
                    break;
            }
        }

        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}