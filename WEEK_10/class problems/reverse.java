import java.util.*;

public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }

        sc.close();
    }
}