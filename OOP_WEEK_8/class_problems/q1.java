import java.util.*;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.02;
    }

    @Override
    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.01;
    }

    @Override
    String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }

    @Override
    String getType() {
        return "BANKTRANSFER";
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;

                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;

                case "BANKTRANSFER":
                    payment = new BankTransfer(amount);
                    break;

                default:
                    continue;
            }

            double adjustedAmount = payment.calculateAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    payment.getType(),
                    adjustedAmount
            );

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}