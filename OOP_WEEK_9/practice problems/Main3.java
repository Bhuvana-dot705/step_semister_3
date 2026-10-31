import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000;

    double getTransportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return 40000 + getTransportFee();
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return 20000 + getTransportFee();
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    students[i] = new ScholarshipStudent(name);
                    break;
            }
        }

        for (Student student : students) {
            double fee = student.calculateFee();
            total += fee;

            System.out.printf("%s: %.2f%n",
                    student.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);

        sc.close();
    }
}