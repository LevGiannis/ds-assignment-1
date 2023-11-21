import java.util.Arrays;
import java.util.Scanner;

public class DNAPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a DNA sequence: ");
        String input = scanner.nextLine();
        checkValidInput(input);
        System.out.println("isWatsonCrick: " + isWatsonCrickPalindrome(input));
        scanner.close();
    }

    public static boolean isWatsonCrickPalindrome(String dnaInput) {
        if (dnaInput.isEmpty()) return true;
        DoubleEndedQueueImpl<Character> queue = new DoubleEndedQueueImpl<>();
        char[] dnaChars = dnaInput.toCharArray();
        for (char dnaChar : dnaChars) {
            if (dnaChar == 'A') queue.addFirst('T');
            if (dnaChar == 'T') queue.addFirst('A');
            if (dnaChar == 'C') queue.addFirst('G');
            if (dnaChar == 'G') queue.addFirst('C');
        }
        String reversedDna = queue.toString();
        return reversedDna.equals(dnaInput);
    }

    public static void checkValidInput(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') throw new IllegalArgumentException("Invalid DNA sequence. Only characters A, T, C, and G are allowed.");
        }
    }
}