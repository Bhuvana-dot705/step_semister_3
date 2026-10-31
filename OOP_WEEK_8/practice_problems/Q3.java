import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }

    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return (units * 10) + 200;
    }

    String getType() {
        return "AC";
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Room[] rooms = new Room[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    rooms[i] = new AcRoom(units);
                    break;
            }
        }

        for (Room room : rooms) {
            double bill = room.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}