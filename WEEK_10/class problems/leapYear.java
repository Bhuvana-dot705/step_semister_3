import java.util.*;

public class leapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        boolean isLeapYear =
                (year % 400 == 0) ||
                        (year % 4 == 0 && year % 100 != 0);

        if (isLeapYear) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }

        sc.close();
    }
}