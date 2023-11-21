import java.util.Arrays;
import java.util.Scanner;

public class DNAPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a DNA sequence: ");
        String input = scanner.nextLine();
        checkValidInput(input);
        System.out.println("isWatsonCrick: " + isWatsonCrick(input));
        scanner.close();
    }

    public static boolean isWatsonCrick(String dnaInput) {
        if (dnaInput.isEmpty()) return true;
        char[] dnaChars = dnaInput.toCharArray();
        DoubleEndedQueueImpl<Character> queue = new DoubleEndedQueueImpl<>();
        for (char dnaChar : dnaChars) {
            if (dnaChar == 'A') queue.addLast('T');
            if (dnaChar == 'T') queue.addLast('A');
            if (dnaChar == 'C') queue.addLast('G');
            if (dnaChar == 'G') queue.addLast('C');
        }
        queue.reverse();
        String reversedDna = queue.toString();
        return reversedDna.equals(dnaInput);
    }

    public static void checkValidInput(String input) {
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c != 'A' && c != 'T' && c != 'C' && c != 'G') throw new IllegalArgumentException();
        }
    }
}