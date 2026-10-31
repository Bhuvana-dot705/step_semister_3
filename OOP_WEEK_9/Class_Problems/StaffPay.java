import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double weeklySalary;

    FullTime(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class Hourly extends Staff {
    double hours;
    double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class StaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    staff[i] = new FullTime(name, sc.nextDouble());
                    break;

                case "HOURLY":
                    staff[i] = new Hourly(
                            name, sc.nextDouble(), sc.nextDouble());
                    break;

                case "INTERN":
                    staff[i] = new Intern(name, sc.nextDouble());
                    break;
            }
        }

        double total = 0;

        for (Staff person : staff) {
            double pay = person.calculatePay();
            total += pay;

            System.out.printf("%s: %.2f%n", person.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", total);

        sc.close();
    }
}