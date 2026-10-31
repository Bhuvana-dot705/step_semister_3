import java.util.*;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void display() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(),
                calculateAverage(),
                calculateGrade());
    }
}

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        int[] marks = new int[3];

        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, marks);
        student.display();

        sc.close();
    }
}