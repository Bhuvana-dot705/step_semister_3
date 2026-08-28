import java.util.Scanner;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } 
            else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // If strings have different lengths,
        // remaining characters are mismatches.
        if (original.length() != typed.length() &&
            firstMismatch == -1) {

            firstMismatch = length;
        }

        int totalCharacters = original.length();

        double accuracy =
            (matched * 100.0) / totalCharacters;

        System.out.println();

        System.out.printf(
            "Matched: %d/%d | Accuracy: %.2f%%",
            matched, totalCharacters, accuracy
        );

        if (firstMismatch == -1) {

            System.out.println(" | No Mismatches");

        } else {

            char originalChar =
                original.charAt(firstMismatch);

            char typedChar =
                firstMismatch < typed.length()
                ? typed.charAt(firstMismatch)
                : '-';

            System.out.println(
                " | First Mismatch at position "
                + (firstMismatch + 1)
                + " ('" + originalChar
                + "' vs '" + typedChar + "')"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}