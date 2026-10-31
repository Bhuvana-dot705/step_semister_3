import java.util.*;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    String name;
    LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            switch (type) {
                case "BASIC":
                    plans[i] = new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plans[i] = new StandardPlan(name, startDate);
                    break;

                case "PREMIUM":
                    plans[i] = new PremiumPlan(name, startDate);
                    break;
            }
        }

        for (SubscriptionPlan plan : plans) {
            System.out.println(plan.name + ": "
                    + plan.getRenewalDate());
        }

        sc.close();
    }
}