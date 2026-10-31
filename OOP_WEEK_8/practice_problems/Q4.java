import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Employee[] employees = new Employee[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees[i] = new FullTimeEmployee(name, salary);
                    break;

                case "PARTTIME":
                    employees[i] = new PartTimeEmployee(name, salary);
                    break;

                case "INTERN":
                    employees[i] = new Intern(name, salary);
                    break;
            }
        }

        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            total += bonus;

            System.out.printf("%s: %.2f%n",
                    employee.name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}