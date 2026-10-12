class AttendanceSheet {
    private final String[] students;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(
                    "Capacity cannot be negative"
            );
        }

        students = new String[capacity];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Invalid student name");
            return;
        }

        if (isPresent(name)) {
            System.out.println(name + " is already marked present");
            return;
        }

        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
            System.out.println(name + " marked present");
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class attendence {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " +
                sheet.getPresentCount());

        System.out.println("Is Ben present? " +
                sheet.isPresent("Ben"));

        System.out.println("Is Chen present? " +
                sheet.isPresent("Chen"));
    }
}